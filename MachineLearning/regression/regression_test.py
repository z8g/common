# -*- coding: UTF-8 -*-

from numpy import array
from numpy import corrcoef
from numpy import mat
import regression
import unittest

class  regression_TestCase(unittest.TestCase):
#	def test_stand_regres(self):
#		x_arr, y_arr = regression.load_dataset('ex0.txt')
#		print(x_arr[0:2])
#
#		ws = regression.stand_regres(x_arr, y_arr)
#		print(ws)
#
#		# y = wx[0] = ws[1] * X1
#		x_matrix = mat(x_arr)
#		y_matrix = mat(y_arr)
#
#		import matplotlib.pyplot as plt
#		fig = plt.figure()
#		ax = fig.add_subplot(111)
#		ax.scatter(x_matrix[:, 1].flatten().A[0], y_matrix.T[:, 0].flatten().A[0])
#
#		x_copy = x_matrix.copy()
#		x_copy.sort(0)
#		y = x_copy * ws
#		print array(x_copy[:, 1])
#		print "y"
#		print array(y)
#		ax.plot(array(x_copy[:, 1]), array(y))
		#plt.show()

#		print "corrcoef", corrcoef(y.T, y_matrix)

#	def test_locally_weighted_linear_regession(self):
#		x_arr, y_arr = regression.load_dataset('ex0.txt')
#		print("real: ", y_arr[0])
#
#		print("predict(k=1.0): ", regression.lwlr(x_arr[0], x_arr, y_arr, 1.0))
#		print("predict(k=0.001): ", regression.lwlr(x_arr[0], x_arr, y_arr, 0.001))
#
#		y_hat = regression.lwlr_test(x_arr, x_arr, y_arr, 0.001)
#
#		# 绘图
#		x_mat = mat(x_arr)
#		srt_ind = x_mat[:, 1].argsort(0)
#		x_sort = x_mat[srt_ind][:, 0,:]

#		import matplotlib.pyplot as plt
#		fig = plt.figure()
#		ax = fig.sub_plot(111)
#		ax.plot(array(x_sort[:, 1]), array(y_hat[srt_ind]))
#		ax.acatter(x_mat[:, 1].flatten().A[0], 
#				   mat(y_arr).T.flatten().A[0], 
#				   s=2, 
#				   c='red')
#		plt.show()
	
	def test_rss_error(self):
		ab_x, ab_y = regression.load_dataset('abalone.txt')
		
		# 训练集
		y_hat01=regression.lwlr_test(ab_x[0:99],ab_x[0:99],ab_y[0:99],0.1)
		y_hat1=regression.lwlr_test(ab_x[0:99],ab_x[0:99],ab_y[0:99],1)
		y_hat10=regression.lwlr_test(ab_x[0:99],ab_x[0:99],ab_y[0:99],10)
		
		print(regression.rss_error(ab_y[0:99], y_hat01.T))
		print(regression.rss_error(ab_y[0:99],y_hat1.T))
		print(regression.rss_error(ab_y[0:99],y_hat10.T))
		
		# 测试集
		y_hat01=regression.lwlr_test(ab_x[100:199],ab_x[0:99],ab_y[0:99],0.1)
		y_hat1=regression.lwlr_test(ab_x[100:199],ab_x[0:99],ab_y[0:99],1)
		y_hat10=regression.lwlr_test(ab_x[100:199],ab_x[0:99],ab_y[0:99],10)
		
		print(regression.rss_error(ab_y[100:199], y_hat01.T))
		print(regression.rss_error(ab_y[100:199],y_hat1.T))
		print(regression.rss_error(ab_y[100:199],y_hat10.T))
		
		# 和简单的线性回归做个比较
		ws = regression.stand_regres(ab_x[0:99],ab_y[0:99])
		y_hat=mat(ab_x[100:199])*ws
		err = regression.rss_error(ab_y[100:199], y_hat.T.A)
		print err
	
	def test_ridge_regres(self):
		ab_x, ab_y = regression.load_dataset('abalone.txt')
		ridge_weights = regression.ridge_test(ab_x, ab_y)
		
	def test_stageWise(self):
		xArr, yArr = regression.load_dataset('abalone.txt')
		print regression.stageWise(xArr,yArr,0.01,200)
		regression.crossValidation(xArr,yArr,10)
	
if __name__ == '__main__':
    unittest.main()
