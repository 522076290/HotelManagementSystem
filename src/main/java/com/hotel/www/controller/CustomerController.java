package com.hotel.www.controller;

import com.hotel.www.model.Customer;
import com.hotel.www.service.CustomerService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户空制接口
 * @author My VM
 */
@RestController
@RequestMapping("api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * 查询用户列表
     * @return
     */
    @ApiOperation(value="查询用户接口", notes="查询所有的用户")
    @RequestMapping(value = "/selectAllCustomer",method = RequestMethod.POST)
    public Map<String,Object> selectCustomerList() {
        Map<String,Object> map = new HashMap<>();
        List<Customer> list = customerService.selectCustomerList();
        map.put("data",list);
        return map;
    }


    /**
     * 通过id查询用户
     * @return
     */
    @ResponseBody
    @ApiOperation(value="查询用户接口", notes="通过id查询指定用户")
    @ApiImplicitParam( required=true, name = "cutomer",value = "用户实例",dataType = "Customer")
    @RequestMapping(value = "/selectCustomerById",method = RequestMethod.POST)
    public Map<String,Object> selectCustomerById(@RequestBody Customer cutomer ) throws Exception {
        Map<String,Object> map = new HashMap<>();
        List<Customer> list = new ArrayList<>();
        list.add(customerService.selectCustomerById(cutomer.getCid()));
        map.put("data",list);
        return map;
    }


    /**
     * 通过name查询用户
     * @return
     */
    @ResponseBody
    @ApiOperation(value="查询用户接口", notes="通过name查询指定用户")
    @ApiImplicitParam( required=true, name = "cutomer",value = "用户实例",dataType = "Customer")
    @RequestMapping(value = "/selectCustomerByName",method = RequestMethod.POST)
    public Map<String,Object> selectCustomerByName(@RequestBody Customer cutomer ) throws Exception {
        Map<String,Object> map = new HashMap<>();
        List<Customer> list = new ArrayList<>();
        if (cutomer.getCusername().equals("")){
            map.put("data","查询的用户username不能为空");
            return map;
        }else if(cutomer.getCusername() !=null){
            list.add( customerService.selectCustomerByName(cutomer.getCusername()));
        }
        else {
            map.put("data","查询的信息不存在请检查用户名");
            return map;
        }
        map.put("data",list);
        return map;
    }



    /**
     * 添加用户
     * @param customer
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addCustomer",method = RequestMethod.POST)
    @ApiOperation(value="添加用户接口", notes="添加用户")
    @ApiImplicitParam( required=true, name = "customer",value = "用户实例",dataType = "Customer")
    public Map<String,Object> addCustomer(@RequestBody Customer customer) {
        Map<String,Object> map = new HashMap<>();

        boolean flag = customerService.addCustomer(customer);
        if(flag==true){
            map.put("data","注册成功");
        }else if(flag==false) {
            map.put("data","用户已存在");
        }
        return map;
    }


    /**
     * 更新用户接口
     * @param customer
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateCustomer",method = RequestMethod.POST)
    @ApiOperation(value="更新用户接口", notes="更新指定用户")
    @ApiImplicitParam( required=true, name = "customer",value = "用户实例",dataType = "Customer")
    public Map<String,Object> updateCustomer(@RequestBody Customer customer) {
        Map<String,Object> map = new HashMap<>();
        boolean flag = customerService.updateCustomer(customer);
        if(flag==true){
            map.put("data","修改成功");
        }else if(flag==false) {
            map.put("data","修改失败");
        }
        return map;
    }




    /**
     * 通过id删除用户
     * @param cid
     * @return
     */
    @ApiOperation(value="删除用户接口", notes="通过id删除用户")
    @RequestMapping(value = "/deleteCustomer",method = RequestMethod.POST)
    public Map<String,Object> deleteCustomer(String cid) {
        Map<String,Object> map = new HashMap<>();
        Boolean flag = customerService.deleteCustomer(cid);
        if(flag==true){
            map.put("data","删除用户成功");
        }else if(flag==false) {
            map.put("data","删除用户失败");
        }
        return map;
    }


}
