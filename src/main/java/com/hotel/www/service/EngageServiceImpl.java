package com.hotel.www.service;

import com.hotel.www.mapper.EngageMapper;
import com.hotel.www.model.Engage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EngageServiceImpl implements EngageService {

    @Autowired
    EngageMapper engageMapper;

    @Override
    public List<Engage> selectEngageList() {
        return engageMapper.selectEngageList();
    }

    @Override
    public Engage selectRoomByPk(int epk) {
        return engageMapper.selectEngageByPk(epk);
    }

    @Override
    public boolean deleteEngage(int id) {

        if (id>0){
            engageMapper.deleteEngage(id);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean addEngage(Engage engage) {
        engageMapper.addEngage(engage);
        return true;
        }

    @Override
    public boolean updateEngage(Engage engage) {

        if(engage==null){
            return false;
        }else {
            engageMapper.updateEngage(engage);
            return true;
        }

    }

}
