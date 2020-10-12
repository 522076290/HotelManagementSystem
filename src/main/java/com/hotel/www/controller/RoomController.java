package com.hotel.www.controller;


import com.hotel.www.model.Admin;
import com.hotel.www.model.Room;
import com.hotel.www.service.RoomService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.hotel.www.utils.DESUtil.getEncryptString;

/**
 * 房间控制器
 * @author My VM
 */
@RestController
@RequestMapping("api/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    /**
     * 查询房间列表
     * @return
     */
    @ApiOperation(value="查询房间接口", notes="查询所有房间")
    @RequestMapping(value = "/selectAllRoom",method = RequestMethod.POST)
    public Map<String,Object> selectList() {
        Map<String,Object> map = new HashMap<>();
        List<Room> list = roomService.selectRoomList();
        map.put("data",list);
        return map;
    }

    /**
     * 通过id查询房间
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectRoomById",method = RequestMethod.POST)
    @ApiOperation(value="查询房间接口", notes="通过id查询房间")
    @ApiImplicitParam( required=true, name = "room",value = "房间实例",dataType = "Room")
    public Map<String,Object> selectRoomById(@RequestBody Room room) throws Exception  {
        Map<String,Object> map = new HashMap<>();
        List<Room> list=new ArrayList<>();
        list.add(roomService.selectRoomById(room.getRid()));
        map.put("data",list);
        return map;
    }


    /**
     * 添加房间
     * @param room
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addRoom",method = RequestMethod.POST)
    @ApiOperation(value="添加房间接口", notes="添加房间")
    @ApiImplicitParam( required=true, name = "room",value = "房间实例",dataType = "Room")
    public Map<String,Object> addRoom(@RequestBody Room room) {
        Map<String,Object> map = new HashMap<>();
        boolean flag = roomService.addRoom(room);
        if(flag==true){
            map.put("data","添加房间成功");
        }else if(flag==false) {
            map.put("data","添加房间失败");
        }
        return map;
    }


    /**
     * 通过rid删除房间
     * @param rpk
     * @return
     */
    @RequestMapping(value = "/deleteRommById",method = RequestMethod.POST)
    @ApiOperation(value="删除房间接口", notes="通过id删除房间")
    public Map<String,Object> deleteAdmin(int rpk) {
        Map<String,Object> map = new HashMap<>();
        Boolean flag = roomService.deleteRoom(rpk);
        if(flag==true){
            map.put("data","删除房间成功");
        }else if(flag==false) {
            map.put("data","删除房间失败");
        }
        return map;
    }

    /**
     * 更新房间
     * @param room
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateRoom",method = RequestMethod.POST)
    @ApiOperation(value="更新房间接口", notes="更新指定房间")
    @ApiImplicitParam( required=true, name = "room",value = "房间实例",dataType = "Room")
    public Map<String,Object> updateRoom(@RequestBody Room room) {
        Map<String,Object> map = new HashMap<>();
        boolean flag = roomService.updateRoom(room);
        if(flag==true){
            map.put("data","更新房间成功");
        }else if(flag==false) {
            map.put("data","更新房间失败");
        }
        return map;
    }



}
