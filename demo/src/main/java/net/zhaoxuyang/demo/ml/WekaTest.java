/*
https://blog.csdn.net/chekongfu/article/details/84231789
截止到本书写作之时，Weka 总共包含 267 个算法，其中：数据预处理（82），属性选择（33），分类和回归（133），聚类（12），关联规则挖掘（7）。图形界面非常适合用于探索数据，而 Java API 可以让你开发新的机器学习方案并在应用中使用这些算法。
在这里插入图片描述
Weka 是在 GNU 通用公共许可证（GNU GPL）下发布的，这意味着你可以复制、分发和修改它，只要你跟踪源文件中的更改并将其保存在 GNU GPL 下。你甚至可以进行商业分发，但前提是你必须公开源代码或获得商业许可证。

除了几种支持的文件格式外，Weka 还提供了自己的默认数据格式 ARFF，用于通过属性 - 数据对描述数据。它由两部分组成：第一部分包含标题头，它指定所有属性（即特性）及其类型；例如，标称、数字、日期和字符串。第二部分包含数据，其中每行对应于一个实例。标题头中的最后一个属性隐式地被视为目标变量，缺失的数据用问号标记。例如，用 ARFF 文件格式编写的 Bob 实例如下:

    @RELATION person_dataset
    
    @ATTRIBUTE `Name`  STRING
    @ATTRIBUTE `Height`  NUMERIC
    @ATTRIBUTE `Eye color`{blue, brown, green}
    @ATTRIBUTE `Hobbies`  STRING
    
    @DATA
    'Bob', 185.0, blue, 'climbing, sky diving'
    'Anna', 163.0, brown, 'reading'
    'Jane', 168.0, ?, ?

该文件由三个部分组成。第一部分以 @relation 关键字开始，指定数据集名称。下一部分以 @ATTRIBUTE 关键字开始，后面是属性名和类型。可用的类型是 STRING（字符串）、NUMERIC（数字）、DATE（日期）和一组分类值。最后一个属性被隐式假设为我们想要预测的目标变量。最后一部分以 @DATA 关键字开始，每行后面跟着一个实例。实例值用逗号分隔，并且必须遵循与第二部分中的属性相同的顺序。

Weka 的 Java API 由以下的顶层包组成：


weka.associations：这些是关联规则学习的数据结构和算法，包括 Apriori、 predictive apriori、FilteredAssociator、FP-Growth、Generalized Sequential Patterns (GSP)、Hotspot 和 Tertius。

weka.classifiers：这些是监督学习算法、评估期和数据结构。该包由以下几个部分组成：

weka.classifiers.bayes：它实现了贝叶斯（Bayesian）方法，包括朴素贝叶斯、贝式网络、贝叶斯逻辑回归等。

weka.classifiers.evaluation：这些是评价统计、混淆矩阵、ROC 曲线等标称和数值预测的监督评价算法。

weka.classifiers.functions：这些是回归算法，包括线性回归、保序回归、高斯过程、支持向量机、多层感知器、表决感知器等。

weka.classifiers.lazy：这些是基于实例的算法，比如 k- 最近邻、K*，惰性贝叶斯规则。

weka.classifiers.meta：这些是监督学习元算法，包括 AdaBoost、bagging、加性回归、随机委员会（random committee）等。

weka.classifiers.mi：这些是多实例算法，如 Citation-KNN、多样性密度、MI AdaBoost 等。

weka.classifiers.rules：这些是基于变治法（separate-and-conquer）、Ripper、Part、Prism 的决策表和决策规格。

weka.classifiers.trees：这些是各种决策树算法，包括 ID3、C4.5、M5、功能树、逻辑树、随机森林等。

weka.clusterers：这些是聚类算法，包括 k-means、Clope、Cobweb、DBSCAN 层次聚类、Farthest 等

weka.core：这些是各种实用类、数据表示、配置文件等。

weka.datagenerators：这些是用于分类、回归和聚类算法的数据生成器。

weka.estimators：这些是用于离散 / 标称域、条件概率估计等的各种数据分布估计。

weka.experiment：这是一组类，支持运行实验所需的配置、数据集、模型设置和统计信息。

weka.filters：这些是基于属性和基于实例的选择算法，用于监督和非监督数据预处理。

weka.gui：这些是实现 Explorer、Experimenter、和 Knowledge Flow 的图形界面。Explorer 允许你调查数据集、算法及其参数，并使用散点图和其他可视化的形式对数据集进行可视化。Experimenter 用于设计批量实验，但它只能用于分类和回归问题。Knowledge Flow 实现了可视化的拖放式用户界面来构建数据流，如：加载数据、应用过滤器、构建分类器和评估。

 */
package net.zhaoxuyang.demo.ml;

import java.util.Arrays;

/**
 *
 * @author zhaoxuyang
 */
public class WekaTest {

    public static void main(String[] args) {
        Object[] result = createDataset();
        System.out.println(Arrays.deepToString(result));
    }

    // 多返回值
    public static Object[] createDataset() {
        Object[] result = new Object[2];
        result[0] = new String[]{
            "A", "B"
        };
        result[1] = new int[]{1, 2};
        return result;
    }
}
