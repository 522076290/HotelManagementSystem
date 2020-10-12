package com.hotel.www.service;

import com.hotel.www.mapper.RoomTypeMapper;
import com.hotel.www.model.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {
    @Autowired
    RoomTypeMapper roomTypeMapper;

    @Override
    public List<RoomType> selectRoomTypeList() {
        return roomTypeMapper.selectRoomTypeList();
    }

    @Override
    public RoomType selectRoomTypeById(String id) {
        return roomTypeMapper.selectRoomTypeById(id);
    }

    @Override
    public boolean addRoomType(RoomType roomType) {
        RoomType rom = roomTypeMapper.selectRoomTypeById(roomType.getTid());
        if(rom!=null){
            return false;
        }else {
            roomTypeMapper.addRoomType(roomType);
        }
        return true;
    }

    @Override
    public boolean deleteRoomType(String tid) {
        if(tid.equals("")&&tid==null){
            return false;
        }else if(selectRoomTypeById(tid)==null){
            return false;
        }
        else {
            roomTypeMapper.deleteRoomType(tid);
            return true;
        }
    }

    @Override
    public boolean updateRoomType(RoomType roomType) {
        return false;
    }
}
