package com.hotel.www.service;

import com.hotel.www.mapper.RoomMapper;
import com.hotel.www.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{

    @Autowired
    private RoomMapper roomMapper;


    @Override
    public List<Room> selectRoomList() {
        return roomMapper.selectRoomList();
    }

    @Override
    public Room selectRoomById(String id) {
        return roomMapper.selectRoomById(id);
    }

    @Override
    public Room selectRoomByPk(int rpk) {
        return roomMapper.selectRoomByPk(rpk);
    }

    @Override
    public boolean addRoom(Room room) {

        Room rom =roomMapper.selectRoomById(room.getRid());
        if(rom!=null){
            return false;
        }else {
            roomMapper.addRoom(room);
        }
        return true;
    }

    @Override
    public boolean deleteRoom(int rpk) {
            roomMapper.deleteRoom(rpk);
            return true;
    }

    @Override
    public boolean updateRoom(Room room) {

        if(room.getRpk().equals("")&&room.getRpk()==null){
            return false;
        }
        else {
            roomMapper.updateRoom(room);
        }
        return true;
    }

}
