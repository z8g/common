# -*- coding: UTF-8 -*-

import adaboost
import unittest


class  AdaBoost_TestCase(unittest.TestCase):
    def test_load_simple_data(self):
		dataMat, classLabels=adaboost.loadSimpleData()
		print dataMat, classLabels
		
	
		 
if __name__ == '__main__':
    unittest.main()

