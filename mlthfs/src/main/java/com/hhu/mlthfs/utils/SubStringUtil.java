package com.hhu.mlthfs.utils;

/**
 * 截取指定两个字符之间的字符串
 * param:原字符串，第一个字符，最后一个字符。
 * 返回： 截取到的字符串
 */
public class SubStringUtil {

    public static String subString(String string, String str1, String str2){
        //记录特定字符str1、str2索引
        int beginIndex = string.indexOf(str1);
        int endIndex = string.indexOf(str2);
        //索引<0，表示字符串中不存在字符，return
        if(beginIndex < 0){
            return "[" + string + "]" + " 中不存在 " + str1 + "，无法截取";
        } else if(endIndex < 0){
            return "[" + string + "]" + " 中不存在 " + str2 + "，无法截取";
        }
        //参数str1 str2位置可调换，不管str1 str2在字符串中的位置顺序如何，都能截取它们之间的字符串
        if(beginIndex > endIndex){
            int tempIndex = beginIndex;
            beginIndex = endIndex;
            endIndex = tempIndex;
            String tempStr = str1;
            str1 = str2;
            str2 = tempStr;
        }
        //截取 第一个substring()方法包含边界字符str1或str2,为了使截取结果不包含边界，用第二个substring()方法去掉边界字符
        String result = string.substring(beginIndex, endIndex).substring(str1.length());
        return result;
    }
}
