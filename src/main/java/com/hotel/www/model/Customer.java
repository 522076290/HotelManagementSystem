package com.hotel.www.model;

public class Customer {
    /**主键*/
    private  Integer cpk;
    /**用户编号*/
    private  String cid;
    /**用户备注*/
    private  String  remark;
    /**用户登录名*/
    private  String  cusername;
    /**用户密码*/
    private  String   cpwd;
    /**用户真实姓名*/
    private  String   crealname;
    /**用户电话*/
    private  String   ctel;
    /**用户注册时间*/
    private  String   cdate;
    /**用户身份信息*/
    private  String   cidcard;

    public Integer getCpk() {
        return cpk;
    }

    public void setCpk(Integer cpk) {
        this.cpk = cpk;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCusername() {
        return cusername;
    }

    public void setCusername(String cusername) {
        this.cusername = cusername;
    }

    public String getCpwd() {
        return cpwd;
    }

    public void setCpwd(String cpwd) {
        this.cpwd = cpwd;
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

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    public String getCidcard() {
        return cidcard;
    }

    public void setCidcard(String cidcard) {
        this.cidcard = cidcard;
    }
}
