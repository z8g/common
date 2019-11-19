# -*- coding: UTF-8 -*-

from numpy import array
from numpy import corrcoef
from numpy import mat
import regression
import unittest

class  regression_TestCase(unittest.TestCase):
	def test_stand_regres(self):
		x_arr, y_arr = regression.load_dataset('ex0.txt')
		print(x_arr[0:2])

		ws = regression.stand_regres(x_arr, y_arr)
		print(ws)

		# y = wx[0] = ws[1] * X1
		x_matrix = mat(x_arr)
		y_matrix = mat(y_arr)

		import matplotlib.pyplot as plt
		fig = plt.figure()
		ax = fig.add_subplot(111)
		ax.scatter(x_matrix[:, 1].flatten().A[0], y_matrix.T[:, 0].flatten().A[0])

		x_copy = x_matrix.copy()
		x_copy.sort(0)
		y = x_copy * ws
		print array(x_copy[:, 1])
		print "y"
		print array(y)
		ax.plot(array(x_copy[:, 1]), array(y))
		plt.show()

		print "corrcoef", corrcoef(y.T, y_matrix)

	def test_locally_weighted_linear_regession(self):
		x_arr, y_arr = regression.load_dataset('ex0.txt')
		print("real: ", y_arr[0])

		print("predict(k=1.0): ", regression.lwlr(x_arr[0], x_arr, y_arr, 1.0))
		print("predict(k=0.001): ", regression.lwlr(x_arr[0], x_arr, y_arr, 0.001))

		y_hat = regression.lwlr_test(x_arr, x_arr, y_arr, 0.001)

		# 绘图
		x_mat = mat(x_arr)
		srt_ind = x_mat[:, 1].argsort(0)
		x_sort = x_mat[srt_ind][:, 0,:]

		import matplotlib.pyplot as plt
		fig = plt.figure()
		ax = fig.6(111)
		ax.plot(array(x_sort[:, 1]), array(y_hat[srt_ind]))
		ax.acatter(x_mat[:, 1].flatten().A[0], 
				   mat(y_arr).T.flatten().A[0], 
				   s=2, 
				   c='red')
		plt.show()

if __name__ == '__main__':
    unittest.main()
