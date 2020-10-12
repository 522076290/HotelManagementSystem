package com.hotel.www.model;

public class RoomType {

    /**主键*/
    private  Integer tpk;
    /**房间类型编号*/
    private  String  tid;
    /**房间类型*/
    private  String  rtype;
    /**床位数*/
    private  Integer bed;
    /**单价*/
    private  float  price;
    /**押金*/
    private  float  foregift;
    /**备注*/
    private  String remark;
    /**删除标记*/
    private  Integer delmark;

    public Integer getTpk() {
        return tpk;
    }

    public void setTpk(Integer tpk) {
        this.tpk = tpk;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getRtype() {
        return rtype;
    }

    public void setRtype(String rtype) {
        this.rtype = rtype;
    }

    public Integer getBed() {
        return bed;
    }

    public void setBed(Integer bed) {
        this.bed = bed;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getForegift() {
        return foregift;
    }

    public void setForegift(float foregift) {
        this.foregift = foregift;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getDelmark() {
        return delmark;
    }

    public void setDelmark(Integer delmark) {
        this.delmark = delmark;
    }
}
