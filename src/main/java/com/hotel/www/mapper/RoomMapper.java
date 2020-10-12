package com.hotel.www.mapper;

import com.hotel.www.model.Room;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 房间Dao接口
 * @author My VM
 */
@Mapper
public interface RoomMapper {
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
     * 通过主键查询房间
     * @return
     */
    Room selectRoomByPk(int id);


    /**
     * 添加房间
     * @param room
     */
    int addRoom(Room room);

    /**
     * 通过id删除房间
     * @param rpk
     * @return
     */
    int deleteRoom(int rpk);


    /**
     * 更新房间
     * @param room
     */
    int updateRoom(Room room);
}
