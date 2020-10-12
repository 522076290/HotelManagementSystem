package com.hotel.www.service;

import com.hotel.www.model.Room;

import java.util.List;

public interface RoomService {

    /**
     * 查询房间列表
     * @return
     */
    List<Room> selectRoomList();

    /**
     * 通过房间编号查询房间
     * @return
     */
    Room selectRoomById(String id);


    /**
     * 通过房间主键查询房间
     * @param rpk
     * @return
     */
    Room selectRoomByPk(int rpk);

    /**
     * 添加房间
     * @param room
     */
    boolean addRoom(Room room);

    /**
     * 通过rid删除房间
     * @param rpk
     * @return
     */
    boolean deleteRoom(int rpk);

    /**
     * 通过rid更新房间
     * @param room
     * @return
     */
    boolean updateRoom(Room room);

}
