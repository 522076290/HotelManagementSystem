package com.hotel.www.controller;

import com.hotel.www.model.Engage;
import com.hotel.www.service.EngageService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/engage")
public class EngageController {

    @Autowired
    EngageService engageService;


    /**
     * 查询订单列表
     * @return
     */
    @ApiOperation(value="查询订单接口", notes="查询所有的订单")
    @RequestMapping(value = "/selectAllEngage",method = RequestMethod.POST)
    public Map<String,Object> selectAllEngage() {
        Map<String,Object> map = new HashMap<>();
        List<Engage> list = engageService.selectEngageList();
        map.put("data",list);
        return map;
    }


    /**
     * 通过id删除订单
     * @param id
     * @return
     */
    @ApiOperation(value="删除订单接口", notes="通过id删除订单")
    @RequestMapping(value = "/deleteEngage",method = RequestMethod.POST)
    public Map<String,Object> deleteEngage(int id) {
        Map<String,Object> map = new HashMap<>();
        Boolean flag = engageService.deleteEngage(id);
        if(flag==true){
            map.put("data","删除订单成功");
        }else if(flag==false) {
            map.put("data","删除订单失败");
        }
        return map;
    }


    /**
     * 添加用户
     * @param engage
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addEngage",method = RequestMethod.POST)
    @ApiOperation(value="添加订单接口", notes="添加订单")
    @ApiImplicitParam( required=true, name = "engage",value = "订单实例",dataType = "Engage")
    public Map<String,Object> addEngage(@RequestBody Engage engage) {
        Map<String,Object> map = new HashMap<>();

        boolean flag = engageService.addEngage(engage);
        if(flag==true){
            map.put("data","订单预定成功");
        }else if(flag==false) {
            map.put("data","订单预定失败");
        }
        return map;
    }


    /**
     * 更新用户接口
     * @param engage
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateEngage",method = RequestMethod.POST)
    @ApiOperation(value="更新订单接口", notes="更新指定订单")
    @ApiImplicitParam( required=true, name = "engage",value = "订单实例",dataType = "Engage")
    public Map<String,Object> updateEngage(@RequestBody Engage engage) {
        Map<String,Object> map = new HashMap<>();
        boolean flag = engageService.updateEngage(engage);
        if(flag==true){
            map.put("data","更新订单成功");
        }else if(flag==false) {
            map.put("data","更新失败,订单不存在");
        }
        return map;
    }


}
