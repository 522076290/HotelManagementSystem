package com.hotel.www.controller;

import com.hotel.www.model.Admin;
import com.hotel.www.service.AdminService;
import com.hotel.www.utils.MD5;
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
 * 管理员接口控制器
 * @author My VM
 */
@RestController
@RequestMapping("api/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * 查询管理员列表
     * @return
     */
    @ApiOperation(value="查询管理员接口", notes="查询所有的管理员")
    @RequestMapping(value = "/selectAllAdmin",method = RequestMethod.POST)
    public Map<String,Object> selectList() {
        Map<String,Object> map = new HashMap<>();
        List<Admin> list = adminService.selectAdminList();
        map.put("data",list);
        return map;
    }

    /**
     * 通过用户名查询管理员
     * @param admin
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "/selectAdminByName",method = RequestMethod.POST)
    @ApiOperation(value="查询管理员接口", notes="通过姓名查询管理员")
    @ApiImplicitParam( required=true, name = "admin",value = "管理员实例",dataType = "Admin")
    public Map<String,Object> selectAdminByName(@RequestBody Admin admin) throws Exception {
        Map<String,Object> map = new HashMap<>();
        List<Admin> lists = new ArrayList<>();
        if (admin.getAusername() !=null){
            lists.add( adminService.selectAdminByname(admin.getAusername()));
        }else {
            map.put("data","查询的信息不存在请检管理员用户名");
            return map;
        }
        map.put("data",lists);
        return map;
    }

    /**
     * 添加管理员
     * @param admin
     * @return
     */
    @ApiOperation(value="添加管理员接口", notes="添加管理员")
    @RequestMapping(value = "/addAdmin",method = RequestMethod.POST)
    @ApiImplicitParam( required=true, name = "admin",value = "管理员实例",dataType = "Admin")
    public Map<String,Object> addAdmin(@RequestBody Admin admin) {
        Map<String,Object> map = new HashMap<>();
        Boolean flag = adminService.addAdmin(admin);
        if(flag==true){
            map.put("data","添加管理员成功");
        }else if(flag==false) {
            map.put("data","添加失败已有相同id管理员");
        }
        return map;
    }


    /**
     * 通过id删除管理员
     * @param auserid
     * @return
     */
    @ApiOperation(value="删除管理员接口", notes="通过id删除管理员")
    @RequestMapping(value = "/deleteAdmin",method = RequestMethod.POST)
    public Map<String,Object> deleteAdmin(int auserid) {
        Map<String,Object> map = new HashMap<>();
        Boolean flag = adminService.deleteAdmin(auserid);
        if(flag==true){
            map.put("data","删除管理员成功");
        }else if(flag==false) {
            map.put("data","删除失败");
        }
        return map;
    }


    /**
     * 更新管理员接口
     * @param Admin
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateAdmin",method = RequestMethod.POST)
    @ApiOperation(value="更新管理员接口", notes="更新指定管理员")
    @ApiImplicitParam( required=true, name = "admin",value = "管理员实例",dataType = "Admin")
    public Map<String,Object> updateCustomer(@RequestBody Admin admin) {
        Map<String,Object> map = new HashMap<>();
        boolean flag = adminService.updateAdmin(admin);
        if(flag==true){
            map.put("data","更新管理员成功");
        }else if(flag==false) {
            map.put("data","更新失败,管理员不存在");
        }
        return map;
    }

}
