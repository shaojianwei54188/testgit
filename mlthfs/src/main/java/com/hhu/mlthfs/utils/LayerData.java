package com.hhu.mlthfs.utils;


import java.util.List;

public class LayerData<T> {

    private Integer code = 0;
    private Integer count;
    private List<T> data;
    private String msg = "";
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "LayerData{" +
                " count=" + count +
                ", data=" + data +
                '}';
    }
}
