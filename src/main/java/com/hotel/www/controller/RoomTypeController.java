package com.hotel.www.controller;

import com.hotel.www.model.RoomType;
import com.hotel.www.service.RoomService;
import com.hotel.www.service.RoomTypeService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 房间类型控制器
 * @author My VM
 */
@RestController
@RequestMapping("api/roomtype")
public class RoomTypeController {

    @Autowired
    RoomTypeService roomTypeService;

    /**
     * 查询房间类型列表
     * @return
     */
    @ApiOperation(value="查询房间类型接口", notes="查询所有房间类型")
    @RequestMapping(value = "/selectAllRoomType",method = RequestMethod.POST)
    public Map<String,Object> selectAllRoomType() {
        Map<String,Object> map = new HashMap<>();
        List<RoomType> list = roomTypeService.selectRoomTypeList();
        map.put("data",list);
        return map;
    }


    /**
     * 通过id查询房间类型
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectRoomTypeById",method = RequestMethod.POST)
    @ApiOperation(value="查询房间类型接口", notes="通过id查询房间类型")
    @ApiImplicitParam( required=true, name = "roomType",value = "房间类型实例",dataType = "RoomType")
    public Map<String,Object> selectRoomTypeById(@RequestBody RoomType roomType) throws Exception  {
        Map<String,Object> map = new HashMap<>();
        List<RoomType> list=new ArrayList<>();
        list.add(roomTypeService.selectRoomTypeById(roomType.getTid()));
        map.put("data",list);
        return map;
    }



    /**
     * 添加房间类型
     * @param roomType
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addRoomType",method = RequestMethod.POST)
    @ApiOperation(value="添加房间类型接口", notes="添加房间类型")
    @ApiImplicitParam( required=true, name = "roomType",value = "房间实例类型",dataType = "RoomType")
    public Map<String,Object> addRoom(@RequestBody RoomType roomType) {
        Map<String,Object> map = new HashMap<>();
        boolean flag = roomTypeService.addRoomType(roomType);
        if(flag==true){
            map.put("data","添加房间类型成功");
        }else if(flag==false) {
            map.put("data","添加房间类型失败");
        }
        return map;
    }



    /**
     * 通过tid删除房间类型
     * @param tid
     * @return
     */
    @RequestMapping(value = "/deleteRommTypeById",method = RequestMethod.POST)
    @ApiOperation(value="删除房间类型接口", notes="通过id删除房间类型")
    public Map<String,Object> deleteRommTypeById(String tid) {
        Map<String,Object> map = new HashMap<>();
        Boolean flag = roomTypeService.deleteRoomType(tid);
        if(flag==true){
            map.put("data","删除房间类型成功");
        }else if(flag==false) {
            map.put("data","删除房间类型失败");
        }
        return map;
    }

}
