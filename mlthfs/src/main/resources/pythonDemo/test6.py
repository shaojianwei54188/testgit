# -*- coding:utf-8 -*-
import sys

print("=============start-------------")
#存放所有的参数 最后一个为第一个列表的长度（分割时用）
list_str = []
#存放字符型list
list1_str=[]
list2_str=[]
#字符型转换为int型
list_int=[]
list1_int=[]
list2_int=[]

print("len(sys.argv[1:])==",len(sys.argv[1:]))
print("sys.argv[1:]==",sys.argv[1:])

for i in range(1, len(sys.argv)):
    list_str.append(sys.argv[i].replace(",", ""))
print("list_str[0]==",list_str[0])
print("len(list_str)==",len(list_str))
#处理第一个还有最后一个元素的格式
list_str[0] = list_str[0].replace("[", "")
list_str[len(sys.argv)-2] = list_str[len(sys.argv)-2].replace("]", "")

print("=before===String-list===list_str",list_str)
#取出最后一个数作为第一个列表的长度来分割列表
list1Size=int(list_str[len(list_str)-1])
print("list1Size==",list1Size)
#根据size取出第一个列表list[a:b]表示取出下表为a到下标为b-1的值组成一个list
list1_str=list_str[0:list1Size]
print("list1_str==",list1_str)
#取出第二个列表
list2_str=list_str[list1Size:len(list_str)-1]
print("list2_str==",list2_str)
#将str转换为int
list_int=list(map(int, list_str))
list1_int=list(map(int, list1_str))
list2_int=list(map(int, list2_str))
print("list_int==",list_int)
print("list1_int==",list1_int)
print("list2_int==",list2_int)
print(MetricsValue(list1_int,list2_int))
print("-------------end===============")
