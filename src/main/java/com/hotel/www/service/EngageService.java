package com.hotel.www.service;

import com.hotel.www.model.Engage;

import java.util.List;

public interface EngageService {

    /**
     * 查询所有订单
     * @return
     */
    List<Engage> selectEngageList();

    /**
     * 通过房间主键查询房间
     * @param epk
     * @return
     */
    Engage selectRoomByPk(int epk);


    /**
     * 通过id删除订单
     * @param id
     * @return
     */
    boolean deleteEngage(int id);


    /**
     * 添加订单
     * @param engage
     */
    boolean addEngage(Engage engage);


    /**
     * 更新用户
     * @param engage
     * @return
     */
    boolean updateEngage(Engage engage);
}
