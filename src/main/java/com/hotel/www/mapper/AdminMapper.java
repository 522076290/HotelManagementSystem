package com.hotel.www.mapper;


import com.hotel.www.model.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 管理员Dao接口
 * @author My VM
 */
@Mapper
public interface AdminMapper {
    /**
     * 查询管理员列表接口
     * @return
     */
     List<Admin> selectAdminList();

    /**
     * 通过username查询管理员
     * @param ausername
     * @return
     */
     Admin selectAdminByname(String ausername);

    /**
     * 通过auserid查询管理员
     * @param auserid
     * @return
     */
    Admin selectAdminById(int auserid);


    /**
     * 添加管理员
     * @param admin
     */
    int addAdmin(Admin admin);

    /**
     * 通过管理员id删除管理员用户
     * @param auserid
     * @return
     */
    int deleteAdmin(int auserid);


    /**
     * 更新管理员
     * @param admin
     */
    int updateAdmin(Admin admin);
}
