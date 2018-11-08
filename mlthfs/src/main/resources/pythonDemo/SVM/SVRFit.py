#!/usr/bin/python
# -*- coding: <encoding name> -*-
"""
=====支持向量机模型

主函数SVRFit (Obsx,Obsy)，内部调用MetricsValue函数
接受参数
    Obsx [[],[],[],[]] 二维数组
    Obsy [] 一维数组
返回值：
    MetrValue(R,V10,V20,D,Rmse)
    yfit

"""
import sys
import numpy as np


# 评估指标
def MetricsValue(yobs, yfit):
    yyobs = np.array(yobs)
    yyfit = np.array(yfit)
    data = [yyobs, yyfit]
    R = np.corrcoef(data)[0, 1]  # 相关系数
    # 预报的变幅误差
    yo_yp = yyfit - yyobs
    BFWC = yo_yp / np.ptp(yyobs)
    V10 = np.size(np.where((abs(BFWC) <= 0.1))) / np.size(yyobs)  # 非常要注意这个括号 没有括号估计内部执行顺序不对
    V20 = np.size(np.where((abs(BFWC) <= 0.2))) / np.size(yyobs)
    # 确定性系数
    D1 = np.sum(yo_yp ** 2)
    D2 = np.sum((yyobs - np.mean(yyobs)) ** 2)
    D = 1 - D1 / D2
    # 均方根误差RMSe
    Rmse1 = sum(yo_yp ** 2)
    Rmse = np.sqrt(Rmse1 / np.size(yyobs))
    return R, V10, V20, D, Rmse


# 拟合
def SVRFit(Obsx, Obsy):
    from sklearn.svm import SVR
    from sklearn.model_selection import cross_val_predict
    xobs = np.array(Obsx)
    yobs = np.array(Obsy)
    modelFit = SVR(kernel='rbf', C=1e3, gamma=0.1)
    yfit = cross_val_predict(modelFit, xobs, yobs, cv=2)  # 交叉验证返回对应的拟合值，根据Obsy和yfit计算评估指标
    MetrValue = MetricsValue(yobs, yfit)
    modelFit.fit(xobs, yobs)
    print('MetrValue', MetrValue)
    print('yfit', yfit)
    return MetrValue, yfit


if __name__ == "__main__":
    # 接受参数===============start============================
    # 存放所有的参数 最后一个为第一个列表的长度（分割时用）
    list_str = []
    # 存放字符型list
    list1_str = []
    list2_str = []
    # 字符型转换为int型
    list_int = []
    list1_int = []
    list2_int = []
    # 存放转换出来的二维数组
    list1_int2 = []
    for i in range(1, len(sys.argv)):
        list_str.append(sys.argv[i].replace(",", ""))
    # 处理第一个还有最后一个元素的格式
    list_str[0] = list_str[0].replace("[", "")
    list_str[len(sys.argv) - 2] = list_str[len(sys.argv) - 2].replace("]", "")
    # 年数（行数）
    year_count = int(list_str[len(list_str) - 1])
    # 因子个数（列数）
    x_count = int(list_str[len(list_str) - 2])
    # 第一个数组
    list1_str = list_str[0:int(year_count * x_count)]
    list1_int = list(map(int, list1_str))
    # 使用numpy库的函数将一维数组转换为二维
    list1_int2 = np.array(list1_int).reshape((year_count, x_count))
    # 第二个数组
    list2_str = list_str[int(year_count * x_count):len(list_str) - 2]
    list2_int = list(map(int, list2_str))

    SVRFit(list1_int2, list2_int)
