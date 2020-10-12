package com.hotel.www.mapper;

import com.hotel.www.model.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
    /**
     * 查询用户列表接口
     * @return
     */
    List<Customer> selectCustomerList();


    /**
     * 通过cid查询管理员
     * @param cid
     * @return
     */
    Customer selectCustomerById(String cid);


    /**
     * 通过cusernamea查询管理员
     * @param cusername
     * @return
     */
    Customer selectCustomerByName(String cusername);

    /**
     * 添加用户
     * @param customer
     */
    int addCustomer(Customer customer);

    /**
     * 通过用户id删除用户
     * @param cid
     *
     * @return
     */
    int deleteCustomer(String cid);

    /**
     * 通过用户主键删除用户
     * @param cpk
     *
     * @return
     */
    int deleteCustomerByPk(int cpk);

    /**
     * 更新用户
     * @param customer
     */
    int updateCustomer(Customer customer);
}
