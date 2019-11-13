# -*- coding: UTF-8 -*-

from numpy import exp
from numpy import inf
from numpy import log
from numpy import mat
from numpy import matrix
from numpy import multiply
from numpy import ones
from numpy import shape
from numpy import sign
from numpy import zeros
"""
================================================================================
元算法：对其他算法组合的一种方式
主要关注boosting 方法及其代表分类器AdaBoost
接下来建立一个单层决策树（decision stump）分类器
最后在结束之前讨论一下非均衡问题

将不同的分类器组合的方法称为集成方法（ensemble method）或者元算法（meta-algorithm）：
	可以是不同算法的集成
	也可以是同一算法在不同设置下的集成
================================================================================
bagging：基于数据随机重抽样的分类器构建方法（先进的有随机森林random forset）
boosting：通过关注被已有分类器错分的数据来获得新的分类器，基于所有分类器的加权求和结果(AdaBoost)
================================================================================
				AdaBoost（Adaptive boosting自适应boosting）
			优点：泛化错误率低，易编码，可以应用在大部分分类器上，无参数调整
			缺点：对离群点敏感
			使用数据类型：数值型和标称型数据
================================================================================
AdaBoost运行过程：
	训练数据中国的每个样本，并赋予其一个权重，这些权重构成了向量D。
	一开始，这些权重都初始化成相等值。
	首先在训练数据中训练出一个所分类器并计算出错误率，然后在同一数据集上再次训练弱分类器。
	在第二次训练当中，将会调整每个样本的权重：
		其中第一次分对的样本的权重将会降低，
		其中第一次分错的样本的权重将会提高。
	为每个分类器分配了一个权重值alpha，alpha是基于错误率计算的，	其中错误率：
		e = 未正确分类的样本数目 / 所有样本数目
	而alpha的计算公式如下：
		alpha = ln((1-e)/e) / 2

	计算出alpha值后，可以对权重向量D进行更新，D的计算方法如下：
		如果某个样本被正确分类，则其权重更改为：
			D[i](t+1) = (D[i](t) * e^(-a)) / sum(D)
		如果某个样本被正确分类，则其权重更改为：
			D[i](t+1) = (D[i](t) * e^a) / sum(D)
	
	计算出D后，AdaBoost又开始进入下一轮迭代，不断重复训练，
	直到训练错误率为0或者弱分类器的数目达到用户的指定值为止。
================================================================================
"""

"""
加载数据
"""
def loadSimpleData():
	dataMat = matrix([
					 [1.0, 2.1],
					 [2.0, 1.1],
					 [1.3, 1.0],
					 [1.0, 1.0],
					 [2.0, 1.1]
					 ])
	classLabels = [1.0, 1.0, -1.0, -1.0, 1.0]
	return dataMat, classLabels

"""
单层决策树生成函数
"""
def stumpClassify(dataMatrix, dimen, threshVal, threshIneq):
	retArray = ones((shape(dataMatrix)[0], 1))
	if threshIneq == 'lt':
		retArray[dataMatrix[:, dimen] <= threshVal] = -1.0
	else:
		retArray[dataMatrix[:, dimen] > threshVal] = -1.0
	return retArray
	
def buildStump(dataArr, classLabels, D):
	dataMatrix = mat(dataArr);
	labelMat = mat(classLabels).T
	m, n = shape(dataMatrix)
	numSteps = 10.0
	bestStump = {}
	bestClassEst = mat(zeros((m, 1)))
	minError = inf
	for i in range(n):
		rangeMin = dataMatrix[:, i].min()
		rangeMax = dataMatrix[:, i].max()
		stepSize = (rangeMax-rangeMin) / numSteps
		for j in range(-1, int(numSteps) + 1):
			for inequal in ['lt', 'gt']:
				threshVal = (rangeMin + float(j) * stepSize)
				predictedVals = stumpClassify(dataMatrix, i, threshVal, inequal)
				errArr = mat(ones((m, 1)))
				errArr[predictedVals == labelMat] = 0
				weightedError = D.T * errArr
				if weightedError < minError:
					minError = weightedError
					bestClassEst = predictedVals.copy()
					bestStump['dim'] = i
					bestStump['thresh'] = threshVal
					bestStump['ineq'] = inequal
	return bestStump, minError, bestClassEst

"""
							AdaBoost训练单层决策树
================================================================================
对每次迭代：
	利用buildStump()函数找到最佳的单层决策树
	将最佳单层决策树加入到单层决策树数组
	计算alpha
	计算新的权重向量D
	更新累计类别估计值
	如果错误率等于0.0，则退出循环
================================================================================
"""
def adaBoostTrainDS(dataArr, classLabels, numIt=40):
	weakClassArr = []
	m = shape(dataArr)[0]
	D = mat(ones((m, 1)) / m)
	aggClassEst = mat(zeros((m, 1))) # 保持一个运行时估计值 
	for i in range(numIt):
		print "index:", i
		bestStump, error, classEst = buildStump(dataArr, classLabels, D)
		print "D:", D.T
		# max(error,1e-16) 确保在没有错误时不会发生除零溢出
		alpha = float(0.5 * log((1.0-error) / max(error, 1e-16)))
		bestStump['alpha'] = alpha
		weakClassArr.append(bestStump)
		print "classEst: ", classEst.T
		
		expon = multiply(-1 * alpha * mat(classLabels).T, classEst)
		D = multiply(D, exp(expon))
		D = D / D.sum()
		aggClassEst += alpha * classEst
		print "aggClassEst: ", aggClassEst.T
		
		aggErrors = multiply(sign(aggClassEst) != mat(classLabels).T, ones((m, 1)))
		errorRate = aggErrors.sum() / m
		print "total error: ", errorRate, "\n"
		if errorRate == 0.0:
			break
	return weakClassArr

"""
AdaBoost分类函数
"""
def adaClassify(datToClass, classifierArr):
	dataMatrix = mat(datToClass)
	print "matrix{", dataMatrix , "}"
	m = shape(dataMatrix)[0]
	aggClassEst = mat(zeros((m, 1)))
	for i in range(len(classifierArr)):
		classEst = stumpClassify(dataMatrix,
								 classifierArr[i]['dim'], 
								 classifierArr[i]['thresh'], 
								 classifierArr[i]['ineq'])
		aggClassEst += classifierArr[i]['alpha']*classEst
		# print aggClassEst
	return sign(aggClassEst)



	
	