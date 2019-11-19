# -*- coding: UTF-8 -*-
"""
================================================================================
(1) 混淆矩阵(confusion matrix)
	混淆矩阵有助于了解分类中的错误。
在一个二类问题中，分为正例和反例，则矩阵存在四种情况：

		------------------------------------------------------------------------
		|								预测结果
        ------------------------------------------------------------------------
		|			+1						|			-1
--------------------------------------------------------------------------------
		| +1 |	真正例(TP, True Positive)		|	伪反例(FN, False Negative)
真实结果	|    |								|
		| -1 |	伪正例(FP, False Positive)   |	真反例(TN, True Negative)
--------------------------------------------------------------------------------

由此得到的指标:
- 正确率(Precision)  = TP / (TP + FP)  预测为正例的样本中的真正比例的比例
- 召回率(Recall)		= TP / (TP + FN)  预测为正例的真实比例占所有真实正例的比例
在召回率很大的分类器中，真正判错的正例数目并不多。

构造一个高正确率或高召回率的分类器。
================================================================================


						
================================================================================
(2) ROC曲线(ROC curve)
	ROC曲线代表接收者操作特征(receiver operating characteristic)
	一条实线一条虚线
	横轴是伪正例的比例: FP/(FP+TN)
	纵轴是真比例的比例: TP/(TP+FN)
	
	最佳的分类器应该尽可能地处于左上角。
	对不同的ROC曲线进行比较，使用的是曲线下的面积(Area Unser the Curve, AUC)
	一个完美地AUC是1，随机猜测的是0.5
================================================================================
"""
"""
ROC曲线的绘制及AUC计算函数
"""
def plotROC(predStrengths, classLabels):
	import matplotlib.pyplot as plt
	from numpy import array
	cur = (1.0, 1.0)
	ySum = 0.0
	numPosClas = sum(array(classLabels) == 1.0)
	yStep = 1 / float(numPosClas)
	xStep = 1 / float(len(classLabels) - numPosClas)
	sortedIndicies = predStrengths.argsort()
	
	fig = plt.figure()
	fig.clf()
	ax = plt.subplot(111)
	for index in sortedIndicies.tolist()[0]:
		if classLabels[index] == 1.0:
			delX = 0
			delY = yStep
		else:
			delX = xStep
			delY = 0
			ySum += cur[1]
		ax.plot([cur[0], cur[0] - delX], [cur[1], cur[1] - delY], c='b')
		cur = (cur[0] - delX, cur[1] - delY)
	ax.plot([0, 1], [0, 1], 'b--')
	plt.xlabel('FP')
	plt.ylabel('TP')
	plt.title('ROC')
	ax.axis([0, 1, 0, 1])
	plt.show()
	print "AUC: ", ySum * xStep

# 在原有函数的基础上添加一个返回值
def adaBoostTrainDS(dataArr, classLabels, numIt=40):
	from numpy import shape
	from numpy import mat
	from numpy import ones
	from numpy import shape
	from numpy import log
	from numpy import multiply
	from numpy import exp
	from numpy import zeros
	from numpy import sign
	from adaboost import buildStump
	
	weakClassArr = []
	m = shape(dataArr)[0]
	D = mat(ones((m, 1)) / m)
	aggClassEst = mat(zeros((m, 1))) # 保持一个运行时估计值 
	for i in range(numIt):
		print "index:", i
		bestStump, error, classEst = buildStump(dataArr, classLabels, D)
		print "D:", D.T
		# max(error,1e-16) 确保在没有错误时不会发生除零溢出
		alpha = float(0.5 * log((1.0-error) / max(error, 1e-16)))
		bestStump['alpha'] = alpha
		weakClassArr.append(bestStump)
		print "classEst: ", classEst.T
		
		expon = multiply(-1 * alpha * mat(classLabels).T, classEst)
		D = multiply(D, exp(expon))
		D = D / D.sum()
		aggClassEst += alpha * classEst
		print "aggClassEst: ", aggClassEst.T
		
		aggErrors = multiply(sign(aggClassEst) != mat(classLabels).T, ones((m, 1)))
		errorRate = aggErrors.sum() / m
		print "total error: ", errorRate, "\n"
		if errorRate == 0.0:
			break
	return weakClassArr, aggClassEst# 修改之处


def test_plotROC():
	from adaboost import loadDataSet
	dataArr, labelArr = loadDataSet("train.txt")
	_, aggClassEst = adaBoostTrainDS(dataArr, labelArr, 9)
	plotROC(aggClassEst.T, labelArr)

"""
(3) 基于代价函数的分类器决策控制
代价敏感的学习(cost-sensitive learning)
总代价1=TP*0 = FN*1 + FP*1 + TN*0
总代价2=TP*(-5)+FN*1+FP*50+TN*0
总代价函数不一样，则错误的代价不一样

通过总代价可以选择付出最小代价的分类器

在AdaBoost中，可以基于代价函数来调整错误权重向量D
在朴素贝叶斯中，可以选择具有最小期望代价而不是最大概率的类别作为最后的结果
在SVM中，可以在代价函数中对于不同的类别选择不同的参数C


(4) 数据抽样方法
通过欠抽样(undersampling，删除样例)或者过抽样(oversampling，复制样例)来实现

"""

if __name__ == '__main__':
	test_plotROC()
	