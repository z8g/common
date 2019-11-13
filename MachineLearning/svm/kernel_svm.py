# -*- coding: UTF-8 -*-

from numpy import exp
from numpy import mat
from numpy import multiply
from numpy import shape
from numpy import zeros
from numpy import nonzero
import svm

"""
能否像线性情况一样，利用强大的工具来捕捉数据中的这种模式？
下面使用核函数(Kernel)将数据转换成易于分类器理解的形式：
	1. 核函数
	2. 径向基函数(radial basis function)
	3. 分类器

核函数可以把数据从某个很难处理的形式转换成另一个较容易处理的形式，
是一种空间映射（通俗地讲是另一种计算距离的方法）

一种流行的核函数，是径向基函数。采用向量作为自变量的函数，能够基于向量距离运算输出一个标量。
	k(x, y) = exp((-||x-y||^2) / (2*r^2))
r 是由用户定义的用于确定到达率(reach)或者说核函数跌到0的速度参数。
"""
def kernelTrans(X, A, kTup):
	m, n = shape(X)
	K = mat(zeros((m, 1)))
	if kTup[0] == 'lin':
		K = X * A.T
	elif kTup[0] == 'rbf':
		for j in range(m):
			deltaRow = X[j, :] - A
			K[j] = deltaRow * deltaRow.T
		K = exp(K / (-1 * kTup[1] ** 2))
	else:
		raise NameError('kernel function name error')
	return K

class optStruct:
	def __init__(self, dataMatIn, classLabels, C, toler, kTup):
		self.X = dataMatIn
		self.lableMat = classLabels
		self.C = C
		self.tol = toler
		self.m = shape(dataMatIn)[0]
		self.alphas = mat(zeros((self.m, 1)))
		self.b = 0
		self.eCache = mat(zeros((self.m, 2)))
		self.K = mat(zeros((self.m, self.m)))
		for i in range(self.m):
			self.K[:, i] = kernelTrans(self.X, self.X[i, :], kTup)


# 内循环
def innerL(i, oS):
	Ei = svm.calcEk(oS, i)

	# 能否被优化
	canBeOptimized = \
		((oS.labelMat[i] * Ei < -oS.tol) and (oS.alphas[i] < oS.C)) or \
		((oS.labelMat[i] * Ei > oS.tol)  and (oS.alphas[i] > 0))

	if not canBeOptimized: # [如果该数据向量不可以被优化:]
		return 0

	j, Ej = svm.selectJ(i, oS, Ei) # [随机选择另外一个数据向量]

	# 存储旧的alpha列表
	alphaIold = oS.alphas[i].copy()
	alphaJold = oS.alphas[j].copy()

	# 保证alpha在0与C之间
	if oS.labelMat[i] != oS.labelMat[j]:
		L = max(0, oS.alphas[j] - oS.alphas[i])
		H = min(oS.C, oS.alphas[j] - oS.alphas[i] + oS.C)
	else:
		L = max(0, oS.alphas[j] + oS.alphas[i] - oS.C)
		H = min(oS.C, oS.alphas[j] + oS.alphas[i])
	if L == H:
		print "L==H"
		return 0

	# [修改]
	eta = 2.0 * oS.K[i, j] - oS.K[i, i] - oS.K[j, j]
	
	if eta >= 0:
		print "eta>0"
		return 0

	oS.alphas[j] -= oS.labelMat[j] * (Ei-Ej) / eta
	oS.alphas[j] = svm.clipAlpha(oS.alphas[j], H, L)

	svm.updateEk(oS, j)

	if abs(oS.alphas[j] - alphaJold) < 0.00001:
		print "j not moving enough"
		return 0

	# 对i进行修改，修改量与j相同，但方向相反
	oS.alphas[i] += oS.labelMat[j] * oS.labelMat[i] * (alphaJold - oS.alphas[j])
	svm.updateEk(oS, i)

	# [修改]
	b1 = oS.b - Ei - oS.labelMat[i] * (oS.alphas[i]-alphaIold) * oS.K[i, i] \
		- oS.labelMat[j] * (oS.alphas[j]-alphaJold) * oS.K[i, j]

	b2 = oS.b - Ej - oS.labelMat[i] * (oS.alphas[i]-alphaIold) * oS.K[i, j] \
		- oS.labelMat[j] * (oS.alphas[j]-alphaJold) * oS.K[j, j]

	if   (0 < oS.alphas[i]) and (oS.C > oS.alphas[j]):
		oS.b = b1
	elif (0 < oS.alphas[j]) and (oS.C > oS.alphas[j]):
		oS.b = b2
	else:
		oS.b = (b1 + b2) / 2.0
	return 1

# 计算E值并返回
def calcEk(oS, k):
	fXk = oS.b + float(multiply(oS.alphas, oS.labelMat).T * oS.K[:, k])
	Ek = fXk - float(oS.labelMat[k])
	return Ek


# 外循环
def smoP(dataMatIn, classLabels, C, toler, maxIter, kTup=('lin', 0)):
	oS = optStruct(mat(dataMatIn), mat(classLabels).transpose(), C, toler)
	iter = 0
	entireSet = True
	alphaPairsChanged = 0

	while (iter < maxIter) and ((alphaPairsChanged > 0) or entireSet):
		alphaPairsChanged = 0

		if entireSet:
			for i in range(oS.m): # 遍历所有的值
				alphaPairsChanged += innerL(i, oS)
				print "fullSet, iter: %d i:%d pairs changed %d" %\
					(iter, i, alphaPairsChanged)
		else:
			nonBoundIs = nonzero((oS.alphas.A > 0) * (oS.alphas.A < C))[0]
			for i in nonBoundIs:
				alphaPairsChanged += innerL(i, oS)
				print "non-bound, iter: %d i%d pairs changed %d" %\
					(iter, i, alphaPairsChanged)
				iter += 1

		if entireSet:
			entireSet = False
		elif (alphaPairsChanged == 0):
			entireSet = True
		else:
			print "iteration number: %d" % iter

	return oS.alphas, oS.b


def testRbf(k1=1.3):
	dataArr, labelArr = svm.loadDataSet('dataset.txt')
	alphas, b = smoP(dataArr, labelArr, 200, 0.0001, 10000, ('rbf', k1))
