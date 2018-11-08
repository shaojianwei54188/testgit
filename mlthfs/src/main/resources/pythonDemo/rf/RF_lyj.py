# -*- coding: utf-8 -*-
import xlrd
import xlsxwriter
from sklearn.ensemble import RandomForestRegressor


#读取数据函数
def build_data(file):
    file = xlrd.open_workbook(file)
    table = file.sheets()[0] #通过索引顺序获取
    nrows = table.nrows #返回行数
    x = [] #预报因子，data
    y = [] #预报对象，label
    for nrow in range(nrows):
        temp = table.row_values(nrow) #返回该行中所有单元格的数值
        y.append(temp[0])
        x.append(temp[1:])
    return x,y

#写入数据函数
def write_excel(file,data):
    workbook = xlsxwriter.Workbook(file)
    sheet = workbook.add_worksheet()
    for i in range(len(data)):
        sheet.write(i,0,data[i])
    workbook.close()

#读取数据
train_x,train_y = build_data("train.xlsx")
test_x,test_y = build_data("test.xlsx")

#创建rf并预测
rf = RandomForestRegressor()
rf.fit(train_x, train_y)
yhat_train = rf.predict(train_x)
yhat_test = rf.predict(test_x)
# print("yhat_train:"+yhat_train)
# print("yhat_test:"+yhat_test)
print("12333")
# write_excel("train_result.xlsx",yhat_train)
# write_excel("test_result.xlsx",yhat_test)






