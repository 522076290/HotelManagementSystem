package com.hotel.www.view;

import com.hotel.www.model.Customer;
import com.hotel.www.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value ="/admin/customer")
public class CustomerViewController {

    @Autowired
    CustomerService customerService;


    /**
     * 返回用户列表
     * */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String roomlist(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        List<Customer> customerlist = customerService.selectCustomerList();
        session.setAttribute("customerlist",customerlist);
        return "customer/customerlist";
    }


    /**
     * 删除用户
     * */
    @RequestMapping(value = "/deletecustomer", method = RequestMethod.GET)
    public void deletecustomer(HttpServletRequest request, HttpServletResponse response,int cpk) throws IOException {
        HttpSession session = request.getSession();
        customerService.deleteCustomerByPk(cpk);
        response.sendRedirect(request.getContextPath() +"/admin/customer/list");
    }

}
