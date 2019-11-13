# -*- coding: UTF-8 -*-

"""
SVM有很多种实现，下面是其中最流行的一种实现：
	序列最小优化(Sequential Minimal Optimization, SMO)算法
在此之后将介绍如何使用一种称为核函数(Kernel)的方式将SVM扩展到更多数据集上。

基于最大间隔

================================================================================
								[寻找最大间隔]
分隔超平面的形式：
	w^T * x + b

要计算点A到分隔超平面的距离，就必须给出分隔面的法线或垂线的长度：
	|w^T+b| / ||w||

类别标签选择-1和1而不选择0和1的原因：
1. 相差一个符号，方便数学上的处理
2. 不管是哪类，label*(w^T * x + b)都会产生一个很大的正数

接着必须找到具有最小间隔的数据点，一旦找到后，就需要对该间隔最大化：
arg max{min( label * (w^T * x + b) * (1 / ||w||) )}

固定一个因子而最大化其他因子，约束条件：
	label*(w^T * x + b) >= 1.0

引入拉格朗日乘子法，将超平面写成数据点的形式，优化目标函数最后可以写成：
	max(a)[sum(a[]) - 1/2 * sum((label(i) * label(j)<x(i),x(j)>)[])]
	C>=a>=0,常数C用于控制最大化间隔和保证大部分点的函数间隔小于1.0这个两个目标的权重

一旦求出的所有的a，分隔超平面就可以通过a来表达，SVM中的主要工作就是求这些a
"""

from numpy import mat
from numpy import multiply
from numpy import random
from numpy import shape
from numpy import zeros
from numpy import nonzero
"""
SMO算法中的辅助函数
"""
def loadDataSet(fileName):
	dataMat = []
	labelMat = []
	fr = open(fileName)
	for line in fr.readlines():
		lineArr = line.strip().split('\t')
		dataMat.append([float(lineArr[0]), float(lineArr[1])])
		labelMat.append(float(lineArr[2]))
	return dataMat, labelMat

def selectJrand(i, m):
	j = i
	while(j == i):
		j = int(random.uniform(0, m))
	return j

def clipAlpha(aj, H, L):
	if aj > H:
		aj = H
	if L > aj:
		aj = L
	return aj

# 计算误差
def getError(dataMatrix, labelMat, alphas, b, index):
	return b + float(multiply(alphas, labelMat).T *
					 (dataMatrix * dataMatrix[index, :].T)) - labelMat[index]


"""
SMO函数：
创建一个alpha向量并将其初始化为0向量
当迭代次数小于最大迭代次数时(外循环):
    对数据集中的每个向量(内循环):
        如果该数据向量可以被优化:
            随机选择另外一个数据向量
            同时优化这两个向量
            如果两个向量都不能被优化，退出内循环
    如果所有向量都没被优化，增加迭代数目，继续下一次循环
"""
def smoSimple(dataMatIn, classLabels, C, toler, maxIter):
	dataMatrix = mat(dataMatIn)
	labelMat = mat(classLabels).transpose()
	b = 0
	m, n = shape(dataMatrix)
	alphas = mat(zeros((m, 1))) # [创建一个alpha向量并将其初始化为0向量]
	iter = 0
	while (iter < maxIter): # [当迭代次数小于最大迭代次数时(外循环):]
		alphaPairsChanged = 0
		for i in range(m): # [对数据集中的每个向量(内循环):]
			Ei = getError(dataMatrix, labelMat, alphas, b, i)

			canBeOptimized = ((labelMat[i] * Ei < -toler) and (alphas[i] < C)) \
				or ((labelMat[i] * Ei > toler) and (alphas[i] > 0))  # 能否被优化

			if not canBeOptimized: # [如果该数据向量不可以被优化:]
				break

			j = selectJrand(i, m) # [随机选择另外一个数据向量]
			Ej = getError(dataMatrix, labelMat, alphas, b, j)
			
			# 存储旧的alpha列表
			alphaIold = alphas[i].copy()
			alphaJold = alphas[j].copy()

			# 保证alpha在0与C之间
			if labelMat[i] != labelMat[j]:
				L = max(0, alphas[j] - alphas[i])
				H = min(C, alphas[j] - alphas[i] + C)
			else:
				L = max(0, alphas[j] + alphas[i] - C)
				H = min(C, alphas[j] + alphas[i])
			if L == H:
				print "L==H"
				continue

			eta = dataMatrix[i,:] * dataMatrix[j,:].T * 2.0 \
				- dataMatrix[i,:] * dataMatrix[i,:].T \
				- dataMatrix[j,:] * dataMatrix[j,:].T
			if eta >= 0:
				print "eta>0"
				continue

			alphas[j] -= labelMat[j] * (Ei-Ej) / eta
			alphas[j] = clipAlpha(alphas[j], H, L)
			if abs(alphas[j]-alphaJold) < 0.00001:
				print "j not moving enough"
				continue

			# 对i进行修改，修改量与j相同，但方向相反
			alphas[i] += labelMat[j] * labelMat[i] * (alphaJold - alphas[j])

			b1 = b - Ei - labelMat[i] * (alphas[i]-alphaIold) \
				* dataMatrix[i,:] \
				* dataMatrix[i,:].T \
			- labelMat[j] * (alphas[i]-alphaJold) \
				* dataMatrix[i,:] \
				* dataMatrix[j,:].T

			b2 = b - Ej - labelMat[i] * (alphas[i]-alphaIold) \
				* dataMatrix[i,:] \
				* dataMatrix[j,:].T \
			- labelMat[j] * (alphas[j]-alphaJold) \
				* dataMatrix[j,:] \
				* dataMatrix[j,:].T

			if   (0 < alphas[i]) and (C > alphas[j]):
				b = b1
			elif (0 < alphas[j]) and (C > alphas[j]):
				b = b2
			else:
				b = (b1 + b2) / 2.0
			alphaPairsChanged += 1
			print "iter: %d i: %d changed %d" % (iter, i, alphaPairsChanged)
		if (alphaPairsChanged == 0):
			iter += 1
	return alphas, b 

"""
下面的程序中包含1个用于清理代码的数据结构和3个用于对E进行缓存的辅助函数，对简单的SMO进行了优化
"""
class optStruct:
	def __init__(self, dataMatIn, classLabels, C, toler):
		self.X = dataMatIn
		self.labelMat = classLabels
		self.C = C
		self.tol = toler
		self.m = shape(dataMatIn)[0]
		self.alphas = mat(zeros((self.m, 1)))
		self.b = 0
		self.eCache = mat(zeros((self.m, 2))) # 缓存误差
	
# 用于选择第二个(内循环)alpha值
def selectJ(i, oS, Ei):
	maxK = -1
	maxDeltaE = 0
	Ej = 0
	oS.eCache[i] = [1, Ei]
	validEcacheList = nonzero(oS.eCache[:, 0].A)[0] # 创建一个非0表
	if (len(validEcacheList)) > 1:
		for k in validEcacheList:
			if k == i:
				continue
			Ek = calcEk(oS, k)
			deltaE = abs(Ei - Ek)

			# 选择具有最大步长的j
			if deltaE > maxDeltaE:
				maxK = k
				maxDeltaE = deltaE
				Ej = Ek
		return maxK, Ej
	else:
		j = selectJrand(i, oS.m)
		Ej = calcEk(oS, j)
		return j, Ej

# 计算E值并返回
def calcEk(oS, k):
	fXk = oS.b + float(multiply(oS.alphas, oS.labelMat).T 
					   * (oS.X * oS.X[k,:].T))
	Ek = fXk - float(oS.labelMat[k])
	return Ek

# 计算误差并存入缓存中
def updateEk(oS, k):
	Ek = calcEk(oS, k)
	oS.eCache[k] = [1, Ek]

# 内循环
def innerL(i, oS):
	Ei = calcEk(oS, i)

	# 能否被优化
	canBeOptimized = \
		((oS.labelMat[i] * Ei < -oS.tol) and (oS.alphas[i] < oS.C)) or \
		((labelMat[i] * Ei > oS.tol)     and (oS.alphas[i] > 0))

	if not canBeOptimized: # [如果该数据向量不可以被优化:]
		return 0

	j, Ej = selectJ(i, oS, Ei) # [随机选择另外一个数据向量]

	# 存储旧的alpha列表
	alphaIold = oS.alphas[i].copy()
	alphaJold = oS.alphas[j].copy()

	# 保证alpha在0与C之间
	if oS.labelMat[i] != oS.labelMat[j]:
		L = max(0,	  oS.alphas[j] - oS.alphas[i])
		H = min(oS.C, oS.alphas[j] - oS.alphas[i] + oS.C)
	else:
		L = max(0,    oS.alphas[j] + oS.alphas[i] - oS.C)
		H = min(oS.C, oS.alphas[j] + oS.alphas[i])
	if L == H:
		print "L==H"
		return 0

	eta = oS.X[i,:] * oS.X[j,:].T * 2.0 \
		- oS.X[i,:] * oS.X[i,:].T \
		- oS.X[j,:] * oS.X[j,:].T
	if eta >= 0:
		print "eta>0"
		return 0

	oS.alphas[j] -= oS.labelMat[j] * (Ei-Ej) / eta
	oS.alphas[j] = clipAlpha(oS.alphas[j], H, L)

	updateEk(oS, j)

	if abs(oS.alphas[j] - alphaJold) < 0.00001:
		print "j not moving enough"
		return 0

	# 对i进行修改，修改量与j相同，但方向相反
	oS.alphas[i] += oS.labelMat[j] * oS.labelMat[i] * (alphaJold - oS.alphas[j])
	updateEk(oS, i)

	b1 = oS.b - Ei - oS.labelMat[i] * (oS.alphas[i]-alphaIold) \
		* oS.X[i,:] \
		* oS.X[i,:].T \
	- oS.labelMat[j] * (oS.alphas[i]-alphaJold) \
		* oS.X[i,:] \
		* oS.X[j,:].T

	b2 = oS.b - Ej - oS.labelMat[i] * (oS.alphas[i]-alphaIold) \
		* oS.X[i,:] \
		* oS.X[j,:].T \
	- oS.labelMat[j] * (oS.alphas[j]-alphaJold) \
		* oS.X[j,:] \
		* oS.X[j,:].T

	if   (0 < oS.alphas[i]) and (oS.C > oS.alphas[j]):
		oS.b = b1
	elif (0 < oS.alphas[j]) and (oS.C > oS.alphas[j]):
		oS.b = b2
	else:
		oS.b = (b1 + b2) / 2.0
	return 1

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
		
		
if __name__ == '__main__':
	dataMat, labelMat = loadDataSet('dataset.txt')
	print dataMat
	print labelMat
	
	alphas, b = smoSimple(dataMat, labelMat, 0.6, 0.001, 40)
	print b
	# print alphas[alphas>0.0]	
	for i in range(100):
		if alphas[i] > 0.0:
			print dataMat[i], labelMat[i]
	print "============================================================="
	
	alphas, b = smoP(dataMat, labelMat, 0.6, 0.001, 40)
	
	print b
	# print alphas[alphas>0.0]	
	for i in range(99):
		if alphas[i] > 0.0:
			print dataMat[i], labelMat[i]