# -*- coding: UTF-8 -*-
import math
import operator
import copy
import pickle
"""
================================================================================
                                决策树
================================================================================
"""

"""
名称: 创建数据集
用法: dataset, labels = create_dataset()
"""
def create_dataset():
    dataset = [
        [1, 1, 'yes'],
        [1, 1, 'yes'],
        [1, 0, 'no'],
        [0, 1, 'no'],
        [0, 1, 'no']
    ]
    labels = ['labelA', 'labelB']
    return dataset, labels


"""
名称: 计算香农熵(度量集合的无序程度,也可以使用基尼不纯度(Gini impurity)度量)
用法: shannon_ent = calc_shannon_ent(dataset)

@param dataset 数据集(要求最后一列是标签)

符号x[i]的信息定义为：
    l(x[i])=-log2(p(x[i]))

计算所有类别所有可能值包含的信息期望值：
    H = -∑(n,i=1)(p(x[i])log2(p(x[i])))

先取出标签，统计出现次数，再通过各标签的出现频率，计算出香农熵。
"""
def calc_shannon_ent(dataset):
    label_count_map = {}
    for items in dataset:
        label = items[-1]
        if label not in label_count_map.keys():
            label_count_map[label] = 0
        label_count_map[label] += 1
    
    size = len(dataset)
    shannon_ent = 0.0
    for key in label_count_map:
        prob = float(label_count_map[key]) / size
        shannon_ent -= prob * math.log(prob, 2)
    
    return shannon_ent


"""
名称: 按照给定特征划分数据集
用法: new_dataset = split_dataset(dataset, axis, value)

append和extend的区别:
>>> a=[1,2,3]
>>> b=[4,5,6]
>>> a.append(b)
>>> a
[1, 2, 3, [4, 5, 6]]

>>> a=[1,2,3]
>>> b=[4,5,6]
>>> a.extend(b)
>>> a
[1, 2, 3, 4, 5, 6]
"""
def split_dataset(dataset, axis, value):
    result = []
    for items in dataset:
        if items[axis] == value:
            reduced_vector = items[:axis]
            reduced_vector.extend(items[axis + 1:])
            result.append(reduced_vector)
    return result



"""
名称: 选择最好的数据集划分点
用法: axis = best_split_axis(dataset)
@param dataset 数据集

通过遍历所有的数据集划分点，依次比较该点与原始香农熵的差异，返回最好的划分点
"""
def best_split_axis(dataset):
    ranges = len(dataset[0]) - 1
    base_ent = calc_shannon_ent(dataset)
    temp_info_gain = 0.0
    best_info_gain = 0.0
    result = -1
    for i in range(ranges):
        feature_list = [example[i] for example in dataset]
        feature_set = set(feature_list)
        new_ent = 0.0
        for value in feature_set:
            sub_dataset = split_dataset(dataset, i, value)
            prob = len(sub_dataset) / float(len(dataset))
            new_ent += prob * calc_shannon_ent(sub_dataset)
        temp_info_gain = base_ent - new_ent
        if(temp_info_gain > best_info_gain):
            best_info_gain = temp_info_gain
            result = i
    return result
            

"""
名称: 返回列表中出现次数最多的一类
"""
def majority_item(class_list):
    class_count_map = {}
    for vote in class_list:
        if vote not in class_count_map.keys():
            class_count_map[vote] = 0
        else:
            class_count_map[vote] += 1
            
    class_count_tree_set = sorted(class_count_map.iteritems(),
                                  key=operator.itemgetter(1),
                                  reverse=True)
    return class_count_tree_set[0][0]



"""
名称: 创建树

1. 类完全相同则停止继续划分
2. 遍历完所有特征时返回出现次数最多的类别
3. 得到列表包含的所有属性值
"""
def create_tree(dataset, label_vector):
    labels = copy.deepcopy(label_vector)
    class_list = [example[-1] for example in dataset]
    if class_list.count(class_list[0]) == len(class_list):
        return class_list[0]
    if len(dataset[0]) == 1:
        return majority_item(class_list)
    
    best_axis = best_split_axis(dataset)
    best_label = labels[best_axis]
    result = {best_label:{}}
    del(labels[best_axis])
    feature_list = [example[best_axis] for example in dataset]
    feature_set = set(feature_list)
    for feature in feature_set:
        sub_labels = labels[:]
        sub_dataset = split_dataset(dataset, best_axis, feature)
        result[best_label][feature] = create_tree(sub_dataset, sub_labels)
    return result


"""
名称: 返回树的叶子总数
"""
def count_leafs(tree):
    result = 0
    first = tree.keys()[0]
    second_dict = tree[first]
    for key in second_dict.keys():
        if type(second_dict[key]).__name__ == 'dict':
            result += count_leafs(second_dict[key])
        else:
            result += 1
    return result

"""
名称: 返回树的深度
"""
def count_depth(tree):
    result = 0
    first = tree.keys()[0]
    second_dict = tree[first]
    for key in second_dict.keys():
        if(type(second_dict[key]).__name__ == 'dict'):
            result = 1 + count_depth(second_dict[key])
        else:
            result = 1
    return result


"""
名称: 决策树分类，返回标签
"""
def classify0(tree, labels, test_vector):
    first = tree.keys()[0]
    second_dict = tree[first]
    index = labels.index(first)
    for key in second_dict.keys():
        if test_vector[index] == key:
            if type(second_dict[key]).__name__ == 'dict':
                class_label = classify0(second_dict[key], labels, test_vector)
            else:
                class_label = second_dict[key]
    return class_label
  

"""
名称: 将树结构持久化到文件系统
"""
def save_tree(tree, filepath):
    file_writer = open(filepath,'w')
    pickle.dump(tree,file_writer)
    file_writer.close()


"""
名称: 从文件系统载入树结构
"""
def load_tree(filepath):
    file_reader = open(filepath)
    return pickle.load(file_reader)
