package com.hotel.www.model;

public class Admin {
    /**主键*/
    private Integer aid;
    /**管理员id*/
    private Integer auserid;
    /**管理员用户名*/
    private String ausername;
    /**管理员密码*/
    private String apwd;
    /**管理员权限*/
    private Integer apuis;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getAuserid() {
        return auserid;
    }

    public void setAuserid(Integer auserid) {
        this.auserid = auserid;
    }

    public String getAusername() {
        return ausername;
    }

    public void setAusername(String ausername) {
        this.ausername = ausername;
    }

    public String getApwd() {
        return apwd;
    }

    public void setApwd(String apwd) {
        this.apwd = apwd;
    }

    public Integer getApuis() {
        return apuis;
    }

    public void setApuis(Integer apuis) {
        this.apuis = apuis;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "aid=" + aid +
                ", auserid=" + auserid +
                ", ausername='" + ausername + '\'' +
                ", apwd='" + apwd + '\'' +
                ", apuis=" + apuis +
                '}';
    }
}
