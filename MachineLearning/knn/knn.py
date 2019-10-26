# -*- coding: UTF-8 -*-
import numpy
import operator
"""
================================================================================
kNN算法的步骤：
1. 计算已知类别数据集中的点与当前点之间的距离(欧式距离公式)
2. 按照距离递增次序排序
3. 选取与当前距离最小的k个点
4. 确定前k个点所在类别的出现频率
5. 返回前k个点出现频率最高的类别作为当前点的预测分类
================================================================================
"""

"""
名称: 创建数据集和标签
用法: group,lables = kNN.createDataSet()
@return 数据集,标签列表
"""
def create_dataset():
    group = numpy.array([[1.0, 1.1], [1.0, 1.0], [0, 0], [0, 0.1]])
    lables = ['A', 'B', 'B', 'B']
    return group, lables

"""
名称: kNN分类
用法: classify0([0,0],group,lables,3)

@param u 用于分类的输入向量
@param dataSet 输入的训练样本集
@param lables 标签向量(labels的元素数量和dataSet的行数相同)
@param k 选择最近邻居的数目
@return 输入向量所属类别(用标签中的元素表示)
"""
def classify0(u, dataset, labels, k):
    dataset_size = dataset.shape[0]
    diff_matrix = numpy.tile(u, (dataset_size, 1)) - dataset
    distances = (((diff_matrix ** 2).sum(axis=1)) ** 0.5).argsort()
    
    class_count_map = {}
    for i in range(k):
        key = labels[distances[i]]
        class_count_map[key] = class_count_map.get(key, 0) + 1
    
    value_tree_set = sorted(class_count_map.iteritems(),
                            key=operator.itemgetter(1),
                            reverse=True)
                            
    return value_tree_set[0][0]

"""
名称: 归一化特征值 (将取值范围处理为 [0,1] 或者 [-1,1] 之间)
用法: normDataSet, ranges, minValues = kNN.autoNorm(m)

@param dataset 数据集
@return 归一化数据集, 数据集范围, 最小值

下面公式可以将任意数值转化到0到1区间内:
newValue = (oldValue - min) / (max - min)
"""
def auto_norm(dataset):
    min_value = dataset.min(0)
    max_value = dataset.max(0)
    ranges = max_value - min_value
    norm_dataset = numpy.zeros(numpy.shape(dataset))
    row = dataset.shape[0]
    norm_dataset = dataset - numpy.tile(min_value, (row, 1))
    norm_dataset = norm_dataset / numpy.tile(ranges, (row, 1))
    return norm_dataset, ranges, min_value


"""
名称: 将文件内容读入矩阵(dating例子)
用法: dataset_matrix,label_list = read_matrix('knnDataSet.txt')

@param filepath 文件路径
@return 数据集矩阵,标签列表

前三列读入数据集矩阵，后一列读入标签列表
"""
def read_matrix(filepath):
    file_reader = open(filepath)
    lines = file_reader.readlines()
    dataset_matrix = numpy.zeros((len(lines), 3))
    label_list = []
    index = 0
    for line in lines:
        items = line.strip().split('\t')
        dataset_matrix[index, :] = items[0:3]
        label_list.append(int(items[-1]))
        index += 1
    return dataset_matrix, label_list

"""
名称: 将文件内容读入向量(手写数字识别例子)
用法: return_vector = read_vector('digits/test/0_1.txt')

@param filepath 文件路径
@return 向量

将文件内容读到一列中
"""
def read_vector(filepath):
    return_vector = numpy.zeros((1, 1024))
    file_reader = open(filepath)
    for i in range(32):
        line = file_reader.readline()
        for j in range(32):
            return_vector[0, 32 * i + j] = int(line[j])
    return return_vector