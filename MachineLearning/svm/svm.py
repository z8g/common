# -*- coding: UTF-8 -*-
"""
支持向量机(Support Vector Machines,SVM)
序列最小化(Sequentail Minimal Optimization,SMO)
================================================================================
优点：泛化错误率低，计算开销不大，结果易解释
缺点：对参数调节和核函数(kernel)的选择敏感，原始分类器不加修改仅使用于处理二类问题
使用数据类型：数值型和标称型
================================================================================
1. 收集数据：可以使用任意方法
2. 准备数据：需要数值型数据
3. 分析数据：有助于可视化分割超平面
4. 训练算法：SVM的大部分时间都源自训练，该过程主要实现两个参数的调优
5. 测试算法：十分简单的计算过程就可以实现
6. 使用算法：适用几乎所有分类问题
"""
def create_dataset(filepath):
    dataset = []
    labels = []
    file_reader = open(filepath)
    for line in file_reader.readlines():
        strs = line.strip().split('\t')
        dataset.append([float(strs[0]), float(strs[1])])
        labels.append(float(strs[2]))
    return dataset, labels

"""
@param i 第一个alpha的下标
@param m 所有alpha的数目
"""
def select_jrand(i, m):
    j = i
    while(j == i):
        j = int(random.uniform(0, m))
    return j

"""
用于调整大于H或者小于L的alpha值
"""
def clip_alpha(aj, high, low):
    if aj > high:
        aj = high
    if aj < low:
        aj = low
    return aj

"""
SMO函数：
创建一个alpha向量并将其初始化为0向量
当迭代次数小于最大迭代次数时(外循环):
    对数据集中的每个向量(内循环):
        如果该数据向量可以被优化:
            随机选择另外一个数据向量
            同时优化这两个向量
            如果两个向量都不能被优化，退出内循环
    如果所有向量都没被优化，增加迭代数目，继续下一次循环
"""
def smo_simple(dataset, labels, C, toler, max_iter):
    dataset_matrix = numpy.mat(dataset)
    labels_matrix = numpy.mat(labels).transpose()
    b = 0
    m, n = numpy.shape(dataset_matrix)
    alphas = numpy.mat(zeros((m, 1)))
    init_iter = 0
    while init_iter < max_iter:
        alpha_pairs_changed = 0
        for i in range(m):
            fxi = float(numpy.multiply(alphas, labels_matrix).T * 
                        (dataset_matrix * dataset_matrix[i, :].T)) + b
            ei = fxi - float(labels_matrix[i])
            
    
    
    
    
