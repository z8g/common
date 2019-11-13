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
		print "c1:", adaboost.adaClassify([0, 0], classifierArr)
		print "c2:", adaboost.adaClassify([[5, 5], [0, 0]], classifierArr)
		print "c2:", adaboost.adaClassify([[0, 0], [5, 5]], classifierArr)
	

if __name__ == '__main__':
    unittest.main()

