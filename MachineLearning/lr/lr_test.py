import lr
import numpy
import unittest

class  Lr_TestCase(unittest.TestCase):
    def test_sigmoid(self):
        print "\n", "test_sigmoid"

        for i in range(-4, 5):
            print i, lr.sigmoid(i)
        print "===================="
        for i in range(-60, 80, 20):
            print i, lr.sigmoid(i)

    def test_create_dataset(self):
        print "\n", "test_create_dataset"
        dataset, labels = lr.create_dataset()
        print dataset,
        print labels
    
    def test_grad_ascent(self):
        print "\n", "test_grad_ascent"
        dataset, labels = lr.create_dataset()
        weights = lr.grad_ascent(dataset, labels)
        print weights
        
if __name__ == '__main__':
    unittest.main()

