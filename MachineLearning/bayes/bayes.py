# -*- coding: UTF-8 -*-

"""
================================================================================
                                朴素贝叶斯
================================================================================
优点：在数据较少的情况下仍然有效，可以处理多类别问题
缺点：对于输入数据的准备方式较为敏感
使用数据类型：标称型数据
================================================================================
条件概率：事件A在事件B发生的条件下发生的概率。
P(A|B) = P(AB)/P(B)
================================================================================
"""

import numpy
import re
"""
名称: 返回数据集和标签
"""
def create_dataset():
    dataset = [
        ['my', 'dog', 'has', 'flea', 'problems', 'help', 'please'],
        ['maybe', 'not', 'take', 'him', 'to', 'dog', 'park', 'stupid'],
        ['my', 'dalmation', 'is', 'so', 'cute', 'I', 'love', 'him'],
        ['stop', 'posting', 'stupid', 'worthless', 'garbage'],
        ['mr', 'licks', 'ate', 'my', 'steak', 'how', 'to', 'stop', 'him'],
        ['quit', 'buying', 'worthless', 'dog', 'food', 'stupid']
    ]
    labels = [0, 1, 0, 1, 0, 1]
    return dataset, labels

"""
名称: 创建一个包含在所有文档中出现的不重复词的列表
遍历数据集，各项中元素去重，项与项之间取并集
"""
def create_vocab_list(dataset):
    vocab_set = set([])
    for doc in dataset:
        vocab_set = vocab_set | set(doc)
    return list(vocab_set)

"""
名称: 判断dataset中的词汇是否在vocab_list中
如果存在则该下标的值置为1
"""
def get_vector(vocab_list, word_set):
    return_vector = [0] * len(vocab_list)
    for word in word_set:
        if word in vocab_list:
            return_vector[vocab_list.index(word)] = 1
        else:
            print "[%s] is not in vocabulary" % word
    return return_vector

"""
训练算法：从词向量计算概率

计算每个类别中的文档数目
对每篇训练文档：
    对每个类别：
        如果词条出现在文档中：增加该词条的计数值
        增加所有词条的计数值

对每个类别：
    对每个词条：
        将该词条的数目除以总词条数目得到条件概率

返回每个类别的条件概率

=========================================
根据现实情况修改分类器(之前的情况)：
p0_denom = 0.0
p1_denom = 0.0
p1_vector = p1_num / p1_denom
p0_vector = p0_num / p0_denom

1. 如果其中一个概率值为0，最后的乘积也为0，解决的办法是改成2.0
2. 太多很小的数相乘造成下溢出的问题，解决的办法是取log
"""
def train0(train_matrix, train_category):
    doc_size = len(train_matrix)
    word_size = len(train_matrix[0])
    p = sum(train_category) / float(doc_size)
    p0_num = numpy.ones(word_size)
    p1_num = numpy.ones(word_size)
    p0_denom = 2.0
    p1_denom = 2.0
    
    for i in range(doc_size):
        if train_category[i] == 1:
            p1_num += train_matrix[i]
            p1_denom += sum(train_matrix[i])
        else:
            p0_num += train_matrix[i]
            p0_denom += sum(train_matrix[i])
    p1_vector = numpy.log(p1_num / p1_denom)
    p0_vector = numpy.log(p0_num / p0_denom)
    return p0_vector, p1_vector, p

"""
朴素贝叶斯分类
"""
def classify0(classify_vec, p0_vec, p1_vec, classify_p):
    p1 = sum(classify_vec * p1_vec) + numpy.log(classify_p)
    p0 = sum(classify_vec * p0_vec) + numpy.log(1.0 - classify_p)
    if p1 > p0:
        return 1
    else:
        return 0



"""
过滤垃圾邮件
"""

"""
将邮件文本分割成单词列表
"""
def split_email(filepath):
    email_text = open(filepath).read()
    regex = re.compile('\\W*')
    strs = regex.split(email_text)
    return [s.lower() for s in strs if len(s) > 2]



