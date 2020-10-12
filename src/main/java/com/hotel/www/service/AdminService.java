package com.hotel.www.service;

import com.hotel.www.model.Admin;

import java.util.List;

/**
 * 管理员服务接口
 * @author My VM
 */
public interface AdminService {

    /**
     * 查询管理员列表
     *  @return List<Admin>
     * */
     List<Admin> selectAdminList();

    /**
     * 通过username查询管理员
     * @param username
     * @return Admin
     */
     Admin selectAdminByname(String username);

    /**
     * 添加管理员
     * @param admin
     */
    boolean addAdmin(Admin admin);


    /**
     * 通过id删除管理员
     * @param auserid
     * @return
     */
    boolean deleteAdmin(int auserid);


    /**
     * 通过id更新管理员
     * @param admin
     * @return
     */
    boolean updateAdmin(Admin admin);

}
