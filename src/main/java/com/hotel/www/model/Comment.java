package com.hotel.www.model;

public class Comment {

    /**主键*/
    private Integer pk;
    /**用户名*/
    private String cname;
    /**用户电话*/
    private  String ctel;
    /**评论时间*/
    private  String time;
    /**评论类型*/
    private int type;
    /**评论内容*/
    private  String comment;

    public Integer getPk() {
        return pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCtel() {
        return ctel;
    }

    public void setCtel(String ctel) {
        this.ctel = ctel;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
