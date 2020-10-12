package com.hotel.www.model;

public class Room {

    /**
     * 主键
     * */
    private Integer rpk;

    /**
     * 房间编号
     * */
    private String rid;
    /**
     * 房间类型编号
     * */
    private String rtypeid;
    /**
     * 房间状态
     * */
    private String state;
    /**
     * 房间位置
     * */
    private String location;
    /**
     * 房间电话
     * */
    private String rtel;
    /**
     * 房间备注
     * */
    private String remark;
    /**
     * 房间标记
     * */
    private Integer delmark;

    public Integer getRpk() {
        return rpk;
    }

    public void setRpk(Integer rpk) {
        this.rpk = rpk;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getRtypeid() {
        return rtypeid;
    }

    public void setRtypeid(String rtypeid) {
        this.rtypeid = rtypeid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRtel() {
        return rtel;
    }

    public void setRtel(String rtel) {
        this.rtel = rtel;
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

    @Override
    public String toString() {
        return "Room{" +
                "rpk=" + rpk +
                ", rid='" + rid + '\'' +
                ", rtypeid='" + rtypeid + '\'' +
                ", state='" + state + '\'' +
                ", location='" + location + '\'' +
                ", rtel='" + rtel + '\'' +
                ", remark='" + remark + '\'' +
                ", delmark=" + delmark +
                '}';
    }
}
