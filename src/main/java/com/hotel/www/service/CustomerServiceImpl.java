package com.hotel.www.service;

import com.hotel.www.mapper.CustomerMapper;
import com.hotel.www.model.Customer;
import com.hotel.www.utils.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务实现层
 * @author My VM
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerMapper customerMapper;

    private EncryptUtil encryptUtil =EncryptUtil.getInstance();


    @Override
    public List<Customer> selectCustomerList() {
        return customerMapper.selectCustomerList();
    }

    @Override
    public boolean addCustomer(Customer customer) {

        Customer cus =customerMapper.selectCustomerById(customer.getCid());
        if(cus!=null){
            return false;
        }else {
            //加密
            String newpwd =encryptUtil.MD5(customer.getCpwd());
            customer.setCpwd(newpwd);
            customerMapper.addCustomer(customer);
            return true;
        }
    }

    @Override
    public Customer selectCustomerById(String cid) {

        return customerMapper.selectCustomerById(cid);
    }

    @Override
    public boolean deleteCustomer(String cid) {

        Customer customer = customerMapper.selectCustomerById(cid);

        if (!(customer==null)){
            customerMapper.deleteCustomer(cid);
                    return true;
        }else {
            return false;
        }

    }

    @Override
    public boolean deleteCustomerByPk(int cpk) {
        customerMapper.deleteCustomerByPk(cpk);
        return true;
    }

    @Override
    public Customer selectCustomerByName(String cusername) {
        return customerMapper.selectCustomerByName(cusername);
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        Customer newcustomer = customerMapper.selectCustomerById(customer.getCid());

        if(customer.getCid().equals("")&&customer.getCid()==null){
            return false;
        }
        else {
            customerMapper.updateCustomer(customer);
            return true;
        }
    }


}
