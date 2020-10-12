package com.hotel.www.service;

import com.hotel.www.model.Customer;

import java.util.List;

public interface CustomerService {

    /**
     * 查询管理员列表
     *  @return List<Admin>
     * */
    List<Customer> selectCustomerList();


    /**
     * 添加管理员
     * @param admin
     */
    boolean addCustomer(Customer admin);

    /**
     * 通过cid查询用户
     * @param cid
     * @return
     */
    Customer selectCustomerById(String cid);


    /**
     * 通过id删除管理员
     * @param cid
     * @return
     */
    boolean deleteCustomer(String cid);

    /**
     * 通过id删除管理员
     * @param cpk
     * @return
     */
    boolean deleteCustomerByPk(int cpk);


    /**
     * 通过cusernamea查询管理员
     * @param cusername
     * @return
     */
    Customer selectCustomerByName(String cusername);

    /**
     * 通过cid更新用户
     * @param customer
     * @return
     */
    boolean updateCustomer(Customer customer);


}
