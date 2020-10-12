package com.hotel.www.mapper;

import com.hotel.www.model.RoomType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 房间类型Dao接口
 * @author My VM
 */
@Mapper
public interface RoomTypeMapper {

    /**
     * 查询房间类型列表
     * @return
     */
    List<RoomType> selectRoomTypeList();

    /**
     * 通过类型编号查询房间类型
     * @return
     */
    RoomType selectRoomTypeById(String id);


    /**
     * 添加房间类型
     * @param roomType
     */
    int addRoomType(RoomType roomType);

    /**
     * 通过id删除房间类型
     * @param rtypeid
     * @return
     */
    int deleteRoomType(String rtypeid);


    /**
     * 更新房间类型
     * @param roomType
     */
    int updateRoomType(RoomType roomType);
}
