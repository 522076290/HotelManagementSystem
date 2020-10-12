package com.hotel.www.service;

import com.hotel.www.mapper.AdminMapper;
import com.hotel.www.model.Admin;
import com.hotel.www.utils.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 管理员服务层实现
 * @author My VM
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    private EncryptUtil encryptUtil =EncryptUtil.getInstance();

    /**
     * 查询管理员列表
     * @return
     */
    @Override
    public List<Admin> selectAdminList() {
        return adminMapper.selectAdminList();
    }

    /**
     * 通过username查询管理员
     * @param username
     * @return
     */
    @Override
    public Admin selectAdminByname(String username) {
        return adminMapper.selectAdminByname(username);
    }

    /**
     * 添加管理员
     * @param admin
     */
    @Override
    public boolean addAdmin(Admin admin) {

        //加密
        String pwd = encryptUtil.MD5(admin.getApwd());
        admin.setApwd(pwd);


        Admin admin2 =adminMapper.selectAdminById(admin.getAuserid());
        if(admin2!=null){
            return false;
        }
        else if (admin.getAuserid()!=null && !"".equals(admin.getAuserid())){
            try{
                int e = adminMapper.addAdmin(admin);
                if (e>0){
                    return true;
                }else {
                    throw new RuntimeException("添加管理员失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("添加管理员失败:" + e.getMessage());
            }
        }else {
            throw new RuntimeException("信息不能为空！");
        }
    }

    @Override
    public boolean deleteAdmin(int auserid) {

        if (auserid>0){
            try{
                int e = adminMapper.deleteAdmin(auserid);
                if (e>0){
                    return true;
                }else {
                    throw new RuntimeException("删除管理员信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("删除管理员信息失败:" + e.toString());
            }
        }else {
            throw new RuntimeException("删除用户不能为空！");
        }

    }

    @Override
    public boolean updateAdmin(Admin admin) {
        //加密
        String pwd = encryptUtil.MD5(admin.getApwd());
        admin.setApwd(pwd);
        adminMapper.updateAdmin(admin);
        return true;
    }
}
