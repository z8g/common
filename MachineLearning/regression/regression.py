# -*- coding: UTF-8 -*-
"""
		线性回归
优点：结果易于理解，计算上不复杂
缺点：对非线性的数据拟合不好
适用数据类型：数值型和标称型数据

		回归的一般方法
(1) 收集数据:	任意方法
(2)	准备数据:	数值型数据，标称型数据将被转换成二值型数据
(3) 分析数据:	绘制出数据的可视化二维图将有助于对数据做出理解和分析。
			在采用缩减求得新回归系数后，可以将新拟合线绘在图上对比
(4) 训练算法:	找到回归系数
(5) 测试算法:	使用R^2或者预测值好数据的拟合度，来分析模型的效果
(6) 适用算法:	使用回归，可以在给定输入的时候预测出一个数值，这是对分类方法的提升，
			因为这样可以预测连续型数据而不仅仅是离散的类别标签
		
		使用平方误差求出回归方程
sum { (y[i]-(x[i]^T)*w)^2 }

w2 = ((X^T)*X)^(-1)*(X^T)*y ，表示估计的w的最优解

		OLS(ordinary least squares, 最小二乘法)
"""
from numpy import mat
from numpy import linalg
from numpy import shape
from numpy import eye
from numpy import exp
from numpy import zeros

"""
加载数据
"""
def load_dataset(file_name):
	num_feat = len(open(file_name).readline().split('\t')) - 1
	data_matrix = []
	label_matrix = []
	file_reader = open(file_name)
	for line in file_reader.readlines():
		line_arr = []
		cur_line = line.strip().split('\t')
		for i in range(num_feat):
			line_arr.append(float(cur_line[i]))
		data_matrix.append(line_arr)
		label_matrix.append(float(cur_line[-1]))
	return data_matrix,label_matrix

"""
计算最佳拟合曲线的参数
w2 = ((X^T)*X)^(-1)*(X^T)*y ，表示估计的w的最优解
"""
def stand_regres(x_arr, y_arr):
	x_matrix = mat(x_arr)
	y_matrix = mat(y_arr).T
	xtx_matrix = x_matrix.T * x_matrix
	if linalg.det(xtx_matrix) == 0.0:
		print "is singular"
		return
	ws = xtx_matrix.I * (x_matrix.T * y_matrix)
	return ws

"""
局部加权线性回归(Locally Weighted Linear Regession, LWLR)
线性回归可能出现欠拟合问题，因为它要求的是具有最小均方误差的无偏估计。
有些方法中允许引入一些偏差，从而降低预测的均方误差。
	w2 =((X^T) * W * X)^(-1) * (X^T) * (W^y)
LWLR使用核来对附近的点赋予更高的权重，核的类型可以自由选择，最常用的是高斯核，对应的权重如下：
	w(i,j) = exp((|x(i)-x|) / (-2 * k^2))

"""
def lwlr(test_point, x_arr, y_arr, k=1.0):
	x_mat = mat(x_arr)
	y_mat = mat(y_arr).T
	m = shape(x_mat)[0]
	weights = mat(eye((m)))
	
	for j in range(m):
		diff_mat = test_point - x_mat[j,:]
		weights[j,j] = exp(diff_mat*diff_mat.T/(-2.0*k**2))
	xtx = x_mat.T * (weights * x_mat)
	if linalg.det(xtx) == 0.0:
		print "This is singular"
		return
	ws = xtx.I * (x_mat.T * (weights * y_mat))
	return test_point * ws

def lwlr_test(test_arr, x_arr, y_arr, k=1.0):
	m = shape(test_arr)[0]
	y_hat = zeros(m)
	for i in range(m):
		y_hat[i] = lwlr(test_arr[i],x_arr,y_arr,k)
	return y_hat


