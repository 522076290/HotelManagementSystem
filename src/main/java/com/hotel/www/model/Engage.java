package com.hotel.www.model;

public class Engage {
    /**主键*/
    private  Integer epk;
    /**用户名*/
    private String cname;
    /**用户真实姓名*/
    private String crealname;
    /**用户电话*/
    private String ctel;
    /**用户身份证*/
    private String cidcard;
    /**房间编号*/
    private String rid;
    /**房间位置*/
    private String rlocation;
    /**预抵时间*/
    private String patime;
    /**预定时间*/
    private String engtime;
    /**备注*/
    private String remark;
    /**预定状态标志*/
    private Integer engagemark;

    public Integer getEpk() {
        return epk;
    }

    public void setEpk(Integer epk) {
        this.epk = epk;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCrealname() {
        return crealname;
    }

    public void setCrealname(String crealname) {
        this.crealname = crealname;
    }

    public String getCtel() {
        return ctel;
    }

    public void setCtel(String ctel) {
        this.ctel = ctel;
    }

    public String getCidcard() {
        return cidcard;
    }

    public void setCidcard(String cidcard) {
        this.cidcard = cidcard;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getRlocation() {
        return rlocation;
    }

    public void setRlocation(String rlocation) {
        this.rlocation = rlocation;
    }

    public String getPatime() {
        return patime;
    }

    public void setPatime(String patime) {
        this.patime = patime;
    }

    public String getEngtime() {
        return engtime;
    }

    public void setEngtime(String engtime) {
        this.engtime = engtime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getEngagemark() {
        return engagemark;
    }

    public void setEngagemark(Integer engagemark) {
        this.engagemark = engagemark;
    }
}
