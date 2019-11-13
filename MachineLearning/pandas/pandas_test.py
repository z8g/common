# -*- coding: UTF-8 -*-
"""
Python有了NumPy的Pandas，用Python处理数据就像使用Exel或SQL一样简单方便。
Pandas是基于NumPy的Python库，它被广泛用于快速分析数据，以及数据清洗和准备等工作。

可以把 Pandas 看作是 Python版的Excel或Table。Pandas 有两种数据结构：
Series和DataFrame，Pandas经过几个版本的更新，目前已经成为数据清洗、处理和分析的不二选择。

本章主要介绍Pandas的两个数据结构：
- Serial简介
- DataFrame简介

================================================================================

科学计算方面NumPy是优势，但NumPy中没有标签，数据清理、数据处理就不是其强项了。
而DataFrame有标签，就像SQL中的表一样，
所以在数据处理方面，DataFrame就更胜一筹了，具体包含以下几方面：

（1）读取数据方面
Pandas提供强大的IO读取工具，csv格式、Excel文件、数据库等都可以非常简便地读取，
对于大数据，pandas也支持大文件的分块读取。

（2）在数据清洗方面
面对数据集，我们遇到最多的情况就是存在缺失值，
Pandas把各种类型数据类型的缺失值统一称为NaN,
Pandas提供许多方便快捷的方法来处理这些缺失值NaN。

（3）分析建模阶段
在分析建模阶段，Pandas自动且明确的数据对齐特性，
非常方便地使新的对象可以正确地与一组标签对齐，
由此，Pandas就可以非常方便地将数据集进行拆分-重组操作。

（4）结果可视化方面
结果展示方面，我们都知道Matplotlib是个数据视图化的好工具，
Pandas与Matplotlib搭配，不用复杂的代码，就可以生成多种多样的数据视图。

================================================================================
Pandas主要采用Series和DataFrame两种数据结构。
- Series是一种类似一维数据的数据结构，由数据(values)及索引(indexs)组成，
- DataFrame是一个表格型的数据结构，
它有一组序列，每列的数据可以为不同类型（NumPy数据组中数据要求为相同类型）,
它既有行索引，也有列索引。

================================================================================
"""
import numpy
import pandas
from pandas import DataFrame
from pandas import Series
import unittest


class  Pandas_TestCase(unittest.TestCase):
    def test_Series(self):
        series = Series([1, 3, 6, -1, 2, 8])
        print series

        series = Series([1, 3, 6, -1, 2, 8],
                        index=['a', 'b', 'c', 'd', 'e', 'f'])
        print series
        print series[['a', 'e']]
        print series[s2 > 1]
        s2 = s2 * 10
        print series

    def test_DataFrame1(self):
        a = numpy.array([1, 2, 3, 4])
        b = numpy.array([5, 6, 7, 8])
        c = numpy.array(['a', 'b', 'c', 'd'])
        data_frame = pandas.DataFrame({'a':a, 'b':b, 'c':c})
        print df
        """
            a   b   c
        0   1   5   a
        1   2   6   b
        2   3   7   c
        3   4   8   d
        """

        d1 = DataFrame(numpy.arange(12).reshape((3, 4)),
                       columns=['a1', 'a2', 'a3', 'a4'],
                       index=['a', 'b', 'c'])
        """
            a1  a2  a3  a4
        a   0   1   2   3
        b   4   5   6   7
        c   8   9   10  11
        """
        print "d1:", d1
        print "d1.index:", d1.index
        print "d1.columns", d1.columns
        print "d1.values", d1.values
  
    def test_DataFrame2(self):
        #生成DataFrame有很多，比较常用的有导入等长列表、字典、numpy数组、数据文件等。
        data = {
            'name':['zhanghua', 'liuting', 'gaofei', 'hedong'],
            'age':[40, 45, 50, 46],
            'addr':['jianxi', 'pudong', 'beijing', 'xian']
        }
        d2 = DataFrame(data)
        #改变列的次序
        d3 = DataFrame(data, 
                       columns=['name', 'age', 'addr'], 
                       index=['a', 'b', 'c', 'd'])
        print d3
        #获取DataFrame结构中数据可以采用obj[]操作、obj.iloc[]、obj.loc[]等命令。
        
        d3[['name']]            #选取某一列
        d3[['name','age']]	##选择多列
        d3['a':'c']	        ##选择行
        d3[1:3]		        ##选择行（利用位置索引）

        d3[d3['age']>40]		###使用过滤条件
        

if __name__ == '__main__':
    unittest.main()

