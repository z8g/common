# -*- coding: UTF-8 -*-
"""
		线性回归
优点：结果易于理解，计算上不复杂
缺点：对非线性的数据拟合不好
适用数据类型：数值型和标称型数据

		回归的一般方法
(1) 收集数据:	任意方法
(2)	准备数据:	数值型数据，标称型数据将被转换成二值型数据
(3) 分析数据:	绘制出数据的可视化二维图将有助于对数据做出理解和分析。
			在采用缩减求得新回归系数后，可以将新拟合线绘在图上对比
(4) 训练算法:	找到回归系数
(5) 测试算法:	使用R^2或者预测值好数据的拟合度，来分析模型的效果
(6) 适用算法:	使用回归，可以在给定输入的时候预测出一个数值，这是对分类方法的提升，
			因为这样可以预测连续型数据而不仅仅是离散的类别标签
		
		使用平方误差求出回归方程
sum { (y[i]-(x[i]^T)*w)^2 }

w2 = ((X^T)*X)^(-1)*(X^T)*y ，表示估计的w的最优解

		OLS(ordinary least squares, 最小二乘法)
"""
from numpy import exp
from numpy import eye
from numpy import linalg
from numpy import mat
from numpy import mean
from numpy import shape
from numpy import var
from numpy import zeros
from numpy import inf
from numpy import array
from numpy import nonzero
from numpy import multiply
import random


"""
加载数据
"""
def load_dataset(file_name):
	num_feat = len(open(file_name).readline().split('\t')) - 1
	data_matrix = []
	label_matrix = []
	file_reader = open(file_name)
	for line in file_reader.readlines():
		line_arr = []
		cur_line = line.strip().split('\t')
		for i in range(num_feat):
			line_arr.append(float(cur_line[i]))
		data_matrix.append(line_arr)
		label_matrix.append(float(cur_line[-1]))
	return data_matrix, label_matrix

"""
计算最佳拟合曲线的参数
w2 = ((X^T)*X)^(-1)*(X^T)*y ，表示估计的w的最优解
"""
def stand_regres(x_arr, y_arr):
	x_matrix = mat(x_arr)
	y_matrix = mat(y_arr).T
	xtx_matrix = x_matrix.T * x_matrix
	if linalg.det(xtx_matrix) == 0.0:
		print "is singular"
		return
	ws = xtx_matrix.I * (x_matrix.T * y_matrix)
	return ws

"""
局部加权线性回归(Locally Weighted Linear Regession, LWLR)
线性回归可能出现欠拟合问题，因为它要求的是具有最小均方误差的无偏估计。
有些方法中允许引入一些偏差，从而降低预测的均方误差。
	w2 =((X^T) * W * X)^(-1) * (X^T) * (W^y)
LWLR使用核来对附近的点赋予更高的权重，核的类型可以自由选择，最常用的是高斯核，对应的权重如下：
	w(i,j) = exp((|x(i)-x|) / (-2 * k^2))

"""
def lwlr(test_point, x_arr, y_arr, k=1.0):
	x_mat = mat(x_arr)
	y_mat = mat(y_arr).T
	m = shape(x_mat)[0]
	weights = mat(eye((m)))
	
	for j in range(m):
		diff_mat = test_point - x_mat[j, :]
		weights[j, j] = exp(diff_mat * diff_mat.T / (-2.0 * k ** 2))
	xtx = x_mat.T * (weights * x_mat)
	if linalg.det(xtx) == 0.0:
		print "This is singular"
		return
	ws = xtx.I * (x_mat.T * (weights * y_mat))
	return test_point * ws

def lwlr_test(test_arr, x_arr, y_arr, k=1.0):
	m = shape(test_arr)[0]
	y_hat = zeros(m)
	for i in range(m):
		y_hat[i] = lwlr(test_arr[i], x_arr, y_arr, k)
	return y_hat

def rss_error(y_arr, y_hat_arr):
	return ((y_arr-y_hat_arr) ** 2).sum()

"""
缩减(shrinkage)系数来理解数据
如果特征比样本点还多，输入的矩阵就不是满秩矩阵，求逆时就会出现问题。
为了解决这个问题，而引入了岭回归(ridge regression)的概念
接着是lasso法

第二种是前向逐步回归，可以得到和lasso差不多的效果，且更容易实现。
================================================================================
岭回归就是在矩阵X^T * X上加一个rI从而使得矩阵非奇异，进而能对X^T * X + r求逆，
其中矩阵I是一个m*m的单位矩阵，对角线上元素全为1，其他元素全为0，则计算回归系数的公式变为：
		w2 = (X^T * X + r * I )^(-1) * X^T * y
		
"""
def ridge_regres(x_mat, y_mat, lam=0.2):
	xtx = x_mat.T * x_mat
	denom = xtx + eye(shape(x_mat)[1]) * lam
	if linalg.det(denom) == 0.0:
		print "is singular"
		return
	ws = denom.I * (x_mat.T * y_mat)
	return ws

def ridge_test(x_arr, y_arr):
	x_mat = mat(x_arr)
	y_mat = mat(y_arr).T
	x_mean = mean(y_arr, 0)
	x_var = var(x_mat, 0)
	x_mat = (x_mat - x_mean) / x_var
	num_test_pts = 30
	w_mat = zeros((num_test_pts, shape(x_mat)[1]))
	for i in range(num_test_pts):
		ws = ridge_regres(x_mat, y_mat, exp(i-10))
		w_mat[i, :] = ws.T
	return w_mat



def regularize(xMat):#regularize by columns
    inMat = xMat.copy()
    inMeans = mean(inMat,0)   #calc mean then subtract it off
    inVar = var(inMat,0)      #calc variance of Xi then divide by it
    inMat = (inMat - inMeans)/inVar
    return inMat

"""
前向逐步回归(贪心算法):

数据标准化，使其分布满足0均值和单位方差
在每轮迭代过程中:
	设置当前最小误差lowestError为正无穷
	对每个特征:
		增大或缩小:
			改变一个系数得到一个新的W
			计算新W下的误差
			如果误差Error小于当前最小误差lowestError:
				设置Wbest等于当前的W
			将W设置为新的Wbest
"""
def stageWise(xArr, yArr, eps=0.01, numIt=100):
	xMat = mat(xArr)
	yMat = mat(yArr).T
	yMean = mean(yMat, 0)
	xMat = regularize(xMat)
	m,n = shape(xMat)
	returnMat = zeros((numIt, n))
	ws = zeros((n,1))
	wsTest = ws.copy()
	wsMax = ws.copy()
	for i in range(numIt):
		print ws.T
		lowestError = inf
		for j in range(n):
			for sign in [-1,1]:
				wsTest = ws.copy()
				wsTest[j] += eps*sign
				yTest = xMat*wsTest
				rssE = rss_error(yMat.A, yTest.A)
				if rssE < lowestError:
					lowestError = rssE
					wsMax = wsTest
		ws = wsMax.copy()
		returnMat[i,:]=ws.T
	return returnMat
    
def crossValidation(xArr,yArr,numVal=10):
    m = len(yArr)                           
    indexList = range(m)
    errorMat = zeros((numVal,30))#create error mat 30columns numVal rows
    for i in range(numVal):
        trainX=[]; trainY=[]
        testX = []; testY = []
        random.shuffle(indexList)
        for j in range(m):#create training set based on first 90% of values in indexList
            if j < m*0.9: 
                trainX.append(xArr[indexList[j]])
                trainY.append(yArr[indexList[j]])
            else:
                testX.append(xArr[indexList[j]])
                testY.append(yArr[indexList[j]])
        wMat = ridge_test(trainX,trainY)    #get 30 weight vectors from ridge
        for k in range(30):#loop over all of the ridge estimates
            matTestX = mat(testX); matTrainX=mat(trainX)
            meanTrain = mean(matTrainX,0)
            varTrain = var(matTrainX,0)
            matTestX = (matTestX-meanTrain)/varTrain #regularize test with training params
            yEst = matTestX * mat(wMat[k,:]).T + mean(trainY)#test ridge results and store
            errorMat[i,k]=rss_error(yEst.T.A,array(testY))
            #print errorMat[i,k]
    meanErrors = mean(errorMat,0)#calc avg performance of the different ridge weight vectors
    minMean = float(min(meanErrors))
    bestWeights = wMat[nonzero(meanErrors==minMean)]
    #can unregularize to get model
    #when we regularized we wrote Xreg = (x-meanX)/var(x)
    #we can now write in terms of x not Xreg:  x*w/var(x) - meanX/var(x) +meanY
    xMat = mat(xArr); yMat=mat(yArr).T
    meanX = mean(xMat,0); varX = var(xMat,0)
    unReg = bestWeights/varX
    print "the best model from Ridge Regression is:\n",unReg
    print "with constant term: ",-1*sum(multiply(meanX,unReg)) + mean(yMat)