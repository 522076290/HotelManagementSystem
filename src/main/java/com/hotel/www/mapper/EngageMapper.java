package com.hotel.www.mapper;

import com.hotel.www.model.Engage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EngageMapper {

    /**
     * 查询所有订单
     * @return
     */
    List<Engage> selectEngageList();


    /**
     * 通过评论id删除订单
     * @param eid
     * @return
     */
    int deleteEngage(int eid);


    /**
     * 添加订单
     * @param engage
     */
    int addEngage(Engage engage);

    /**
     * 更新订单
     * @param engage
     */
    int updateEngage(Engage engage);

    /**
     * 通过主键查询订单
     * @return
     */
    Engage selectEngageByPk(int epk);

}
