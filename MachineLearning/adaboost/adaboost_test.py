# -*- coding: UTF-8 -*-

import adaboost
from numpy import mat
from numpy import ones
import unittest

class  AdaBoost_TestCase(unittest.TestCase):
   
	def test_load_simple_data(self):
		#print "test_load_simple_data"
		dataMat, classLabels = adaboost.loadSimpleData()
		#print dataMat, classLabels

	def test_build_stump(self):
		#print "test_build_stump"
		dataMat, classLabels = adaboost.loadSimpleData()
		D = mat(ones((5, 1)) / 5)
		result = adaboost.buildStump(dataMat, classLabels, D)
		#print result
	
	def test_adaboost_train_ds(self):
		#print "test_adaboost_train_ds"
		dataMat, classLabels = adaboost.loadSimpleData()
		classifierArray = adaboost.adaBoostTrainDS(dataMat, classLabels, 9)
		#print classifierArray
	
	def test_ada_classify(self):
		print "test_ada_classify"
		dataMat, classLabels = adaboost.loadSimpleData()
		classifierArr = adaboost.adaBoostTrainDS(dataMat, classLabels, 9)
#		print "c1:", adaboost.adaClassify([0, 0], classifierArr)
#		print "c2:", adaboost.adaClassify([[5, 5], [0, 0]], classifierArr)
#		print "c2:", adaboost.adaClassify([[0, 0], [5, 5]], classifierArr)
		
		
	"""
	从文件中加载数据
	收集数据：提供的文本文件
	准备数据：确保分类是+1和-1而非1和0
	分析数据：手工检查数据
	训练算法：训练分类器
	测试算法：与逻辑回归比较
	使用算法：观察错误率
	"""
	def test_loadDataSet(self):
		dataArr, labelArr = adaboost.loadDataSet('train.txt')
		print "[dataArr]", dataArr
		print "[labelArr]",labelArr
		classifierArray = adaboost.adaBoostTrainDS(dataArr, labelArr, 9)
		testArr, testLabelArr = adaboost.loadDataSet('test.txt')
		prediction10 = adaboost.adaClassify(testArr, classifierArray)
		errArr = mat(ones((67, 1)))
		print errArr[prediction10 != mat(testLabelArr).T].sum()
	

if __name__ == '__main__':
    unittest.main()

