# -*- coding: UTF-8 -*-

import unittest
import svm

class Svm_TestCase(unittest.TestCase):
    def test_svm_(self):
        dataset,labels = svm.create_dataset('dataset.txt')
        print dataset
        print labels
    
    

if __name__ == '__main__':
    unittest.main()

