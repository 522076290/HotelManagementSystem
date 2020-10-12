package com.hotel.www.controller;


import com.hotel.www.model.Encryptpwd;
import com.hotel.www.utils.EncryptUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 工具类控制器
 * @author My VM
 */
@RestController
@RequestMapping("api/util")
public class UtilController {

    private EncryptUtil encryptUtil =EncryptUtil.getInstance();


    /***
     * MD5加密
     */
    @ResponseBody
    @RequestMapping(value = "/encrypt",method = RequestMethod.POST)
    @ApiOperation(value="加密接口", notes="返回加密后的字符")
    @ApiImplicitParam( required=true, name = "encryptpwd",value = "字符串类型",dataType = "Encryptpwd")
    public Map<String,Object> encrypt(@RequestBody Encryptpwd encryptpwd){
      Map<String,Object> map = new HashMap<>();
      String newpwd = encryptUtil.MD5(encryptpwd.getNewpwd());
      map.put("newpwd",newpwd);
      return  map;
    }


}
