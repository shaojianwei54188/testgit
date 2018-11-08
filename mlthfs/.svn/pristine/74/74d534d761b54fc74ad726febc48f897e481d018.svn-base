import sys

# 评估指标
def MetricsValue(yobs,yfit):
    import numpy as np
    yyobs=np.array(yobs)
    yyfit=np.array(yfit)
    data =[yyobs, yyfit]
    R=np.corrcoef(data) [0,1]              # 相关系数

    # 预报的变幅误差
    yo_yp=yyfit-yyobs
    BFWC=yo_yp/np.ptp(yyobs)
    V10 = np.size(np.where((abs(BFWC) <= 0.1)))/np.size(yyobs)  # 非常要注意这个括号 没有括号估计内部执行顺序不对
    V20 = np.size(np.where((abs(BFWC) <=0.2))) / np.size(yyobs)

    # 确定性系数
    D1=np.sum(yo_yp**2)
    D2=np.sum((yyobs-np.mean(yyobs))**2)
    D=1-D1/D2

    #均方根误差RMSe
    Rmse1=sum(yo_yp**2)
    Rmse=np.sqrt(Rmse1/np.size(yyobs))

    print("R",R)
    return R,V10,V20,D,Rmse

if __name__ == '__main__':
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