# -*- coding:utf-8 -*-
import sys
import numpy as np
from sklearn.ensemble import RandomForestRegressor


def rf(train_x, train_y, test_x, test_y):
    # 创建rf并预测
    # 参数设置https://blog.csdn.net/u012102306/article/details/52228516
    rf = RandomForestRegressor(n_estimators=100,
                               max_depth=None,
                               min_samples_split=2,
                               min_samples_leaf=1,
                               min_weight_fraction_leaf=0.0,
                               max_leaf_nodes=None,
                               bootstrap=True,
                               oob_score=False,
                               n_jobs=1,
                               random_state=None,
                               verbose=0,
                               warm_start=False)
    rf.fit(train_x, train_y)
    yhat_train = rf.predict(train_x)
    yhat_test = rf.predict(test_x)

    return yhat_train, yhat_test

if __name__ == '__main__':
    # 存放所有的参数 最后一个为第一个列表的长度（分割时用）
    list_str = []
    list1 = []
    list2 = []
    list3 = []
    list4 = []
    for i in range(1, len(sys.argv)):
        list_str.append(sys.argv[i].replace(",", ""))
    # 处理第一个还有最后一个元素的格式
    list_str[0] = list_str[0].replace("[", "")
    list_str[len(sys.argv) - 2] = list_str[len(sys.argv) - 2].replace("]", "")
    list_float = list(map(float, list_str))
    # 取出参数
    # 一维数组test_y的长度
    test_y_count = int(list_float[len(list_float) - 1])
    # 一维数组train_y的长度
    train_y_count = int(list_float[len(list_float) - 2])
    # 二维数组test_x的列数test_col_count
    test_col_count = int(list_float[len(list_float) - 3])
    # 二维数组test_x的行数test_row_count
    test_row_count = int(list_float[len(list_float) - 4])
    # 二维数组train_x的列数train_col_count
    train_col_count = int(list_float[len(list_float) - 5])
    # 二维数组train_x的行数train_row_count
    train_row_count = int(list_float[len(list_float) - 6])

    # 根据参数取出数组
    list1 = list_float[0:int(train_row_count * train_col_count)]
    list2 = list_float[int(train_row_count * train_col_count):int(train_row_count * train_col_count) + train_y_count]
    list3 = list_float[int(train_row_count * train_col_count) + train_y_count:int(
        train_row_count * train_col_count) + train_y_count + int(test_row_count * test_col_count)]
    list4 = list_float[
            int(train_row_count * train_col_count) + train_y_count + int(test_row_count * test_col_count):int(
                train_row_count * train_col_count) + train_y_count + int(
                test_row_count * test_col_count) + test_y_count]
    # 将
    train_x = np.array(list1).reshape((train_row_count, train_col_count))
    train_y = list2
    test_x = np.array(list3).reshape((test_row_count, test_col_count))
    test_y = list4
    print(rf(train_x, train_y, test_x, test_y))
