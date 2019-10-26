# -*- coding: UTF-8 -*-
import knn
import numpy
import os
import unittest

class Test_knn(unittest.TestCase):
    def test_create_dataset(self):
        group, labels = knn.create_dataset()
        print group
        print labels

    """
    约会网站例子
    """
    def test_main_dating(self):
        test_ratio = 0.50
        dataset_matrix, labels = knn.read_matrix('dating/dataset.txt')
        norm_matrix, ranges, min_value = knn.auto_norm(dataset_matrix)
        size = norm_matrix.shape[0]
        test_num = int(size * test_ratio)
        err_count = 0.0

        for i in range(test_num):
            classifier_result = knn.classify0(norm_matrix[i, :],
                                              norm_matrix[test_num:size,:],
                                              labels[test_num:size],
                                              3)
            print "predict: %d real: %d" % (classifier_result, labels[i])
            if classifier_result != labels[i]:
                err_count += 1.0
                
        err_rate = err_count / float(test_num)
        print 'total: %d error: %d rate: %f' % (test_num, err_count, err_rate)

    """
    手写数字识别例子
    """
    def test_main_hand_writing(self):
        labels = []
        
        train_files = os.listdir('digits/train')
        train_size = len(train_files)
        train_matrix = numpy.zeros((train_size, 1024))
        for i in range(train_size):
            file_name = train_files[i]  # 0_22.txt
            labels.append(get_label(file_name))
            train_matrix[i,:] = knn.read_vector('digits/train/%s' % file_name)

        test_files = os.listdir('digits/test')
        test_size = len(test_files)
        err_count = 0.0
        for i in range(test_size):
            file_name = test_files[i]  # 0_22.txt
            real_label = get_label(file_name)
            test_vector = knn.read_vector('digits/test/%s' % file_name)
            classifier_result = knn.classify0(test_vector,
                                              train_matrix,
                                              labels,
                                              3)
            print "predict: %s real: %s" % (classifier_result, real_label)
            if classifier_result != real_label:
                err_count += 1.0
            
        err_rate = err_count / float(test_size)
        print 'total: %d error: %d rate: %f' % (test_size, err_count, err_rate)

"""
手写数字识别中根据文件名读取出标签
"""
def get_label(file_name):
    return int(file_name.split('.')[0].split('_')[0])
        
if __name__ == '__main__':
    unittest.main()

