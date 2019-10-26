# -*- coding: UTF-8 -*-
import numpy
"""
================================================================================
                                逻辑回归
================================================================================
Logistic回归的一般过程:
1. 收集数据：采用任意方法
2. 准备数据：数值型数据（需要进行距离计算），结构化数据最佳
3. 分析数据：任意方法
4. 训练算法：大部分时间用于训练，为了找到最佳的分类回归系数
5. 测试算法：一旦训练步骤完成，分类将会很快
6. 使用算法：输入一些数据，转化成结构化数值；回归系数对数值进行回归计算，判断出类别
================================================================================
优点：计算代价不高，易于理解和实现
缺点：容易欠拟合，分类精度可能不高
适用数据类型：数值型和标称型
================================================================================
最优化算法：
1. 梯度上升法：
要找到函数的最大值，就沿着该函数的梯度方向探寻 w:=w+α∇wf(w)
步骤：
每个回归系数初始化为1
重复R次：
    计算整个数据集的梯度
    使用alpha * gradient更新回归系数的向量
返回回归系数

================================================================================
"""

"""
Sigmoid函数: sigmoid(x) = 1.0/(1+numpy.exp(-x))
Sigmoid函数的输入记为z，则: z = w[0]x[0] + w[1]x[1] + w[2]x[2] + ... + w[n]x[n]
"""
def sigmoid(x):
    return 1.0 / (1 + numpy.exp(-x))

"""
创建数据集
"""
def create_dataset():
    dataset = []
    labels = []
    file_reader = open('dataset.txt')
    for line in file_reader.readlines():
        items = line.strip().split()
        dataset.append([1.0, float(items[0]), float(items[1])])
        labels.append(int(items[2]))
    return dataset, labels
        
"""
梯度上升函数
"""
def grad_ascent(dataset, labels):
    dataset_matrix = numpy.mat(dataset)
    labels_matrix = numpy.mat(labels).transpose()
    m, n = numpy.shape(dataset_matrix)
    weights = numpy.ones((n, 1))
    alpha = 0.001
    batch = 500
    for i in range(batch):
        h = sigmoid(dataset_matrix * weights)
        err = (labels_matrix - h)
        weights = weights + alpha * dataset_matrix.transpose() * err
    return weights

"""
画出数据集合逻辑回归最佳拟合直线的函数
"""
def plot_best_fit(dataset,labels,weights):
    import matplotlib.pyplot as plt
    dataset = numpy.mat(dataset)
    
    dataset_array = numpy.array(dataset)
    size = numpy.shape(dataset_array)[0]
    
    xcord1 = []
    xcord2 = []
    ycord1 = []
    ycord2 = []
    for i in range(size):
        if int(labels[i]) == 1:
            xcord1.append(dataset_array[i, 1])
            ycord1.append(dataset_array[i, 2])
        else:
            xcord2.append(dataset_array[i, 1])
            ycord2.append(dataset_array[i, 2])

    fig = plt.figure()
    ax = fig.add_subplot(111)
    ax.scatter(xcord1, ycord1, s=30, c='red', marker='s')
    ax.scatter(xcord2, ycord2, s=30, c='blue')
    
    x = numpy.arange(-3.0, 3.0, 0.1)
    y = (-weights[0] - weights[1] * x) / weights[2]
    ax.plot(x, y)
    plt.xlabel('X1')
    plt.ylabel('X2')
    plt.show()

def stoc_grad_ascent0(dataset, labels):
    m, n = numpy.shape(dataset)
    alpha = 0.01
    weights = numpy.ones(n)
    for i in range(m):
        h = sigmoid(sum(dataset[i] * weights))
        err = labels - h
        weights = weights + alpha * err * dataset[i]
    return weights

if __name__ == '__main__':
    dataset,labels = create_dataset()
    weights = numpy.array(grad_ascent(dataset,labels))
    plot_best_fit(dataset,labels,weights)
#    weights = stoc_grad_ascent0(dataset,labels)
#    weights = numpy.array(weights)
#
#    plot_best_fit(dataset,labels,weights)



