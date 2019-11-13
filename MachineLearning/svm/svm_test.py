# -*- coding: UTF-8 -*-

from numpy import mat
from numpy import shape
from numpy import zeros
from numpy import multiply
import svm
import unittest

"""
非零alphas就是支持向量，其他数据点会被抛弃
"""
def calcWs(alphas, dataArr, classLabels):
	X = mat(dataArr);
	labelMat = mat(classLabels).transpose()
	m, n = shape(X)
	w = zeros((n, 1))
	for i in range(m):
		w += multiply(alphas[i]*labelMat[i], X[i,:].T)
	return w

class  Svm_TestCase(unittest.TestCase):
    def test_sigmoid(self):
		dataMat, labelMat = svm.loadDataSet('dataset.txt')
		alphas, b = svm.smoP(dataMat, labelMat, 0.6, 0.001, 40)
		ws = calcWs(alphas, dataMat, labelMat) # 获得支持向量
		print "ws:",ws
		
		
		"""
		现在对数据进行分类
		第1个数据的类别，大于0属于1类，否则属于-1类(对于数据0，应该属于-1类)
		"""
		dataMat = mat(dataMat)
		print (dataMat[0]*mat(ws) + b) # 第1个数据的类别
		print labelMat[0] # 数据0的类别
		
		# 继续检查其他数据分类结果的正确性
		print (dataMat[1]*mat(ws) + b) # 第2个数据的类别
		print labelMat[1] # 数据1的类别		
		 
		 
		 
if __name__ == '__main__':
    unittest.main()


		