package com.hotel.www.service;

import com.hotel.www.model.RoomType;

import java.util.List;

public interface RoomTypeService {

    /**
     * 查询房间类型列表
     * @return
     */
    List<RoomType> selectRoomTypeList();

    /**
     * 通过类型编号查询类型
     * @return
     */
    RoomType selectRoomTypeById(String id);

    /**
     * 添加房间类型
     * @param roomType
     */
    boolean addRoomType(RoomType roomType);

    /**
     * 通过tid删除房间类型
     * @param tid
     * @return
     */
    boolean deleteRoomType(String tid);

    /**
     * 通过tid更新房间类型
     * @param roomType
     * @return
     */
    boolean updateRoomType(RoomType roomType);
}
