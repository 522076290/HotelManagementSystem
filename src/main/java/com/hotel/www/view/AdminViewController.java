package com.hotel.www.view;

import com.hotel.www.model.Admin;
import com.hotel.www.model.Room;
import com.hotel.www.service.AdminService;
import com.hotel.www.service.RoomService;
import com.hotel.www.utils.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class AdminViewController {

    @Autowired
    AdminService adminService;
    @Autowired
    RoomService roomService;

    private EncryptUtil encryptUtil = EncryptUtil.getInstance();

    /**
     * 返回登录页面
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String Buy(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        return "login";
    }


    /**
     * 检查登录
     */
    @RequestMapping(value = "/chekclogin", method = RequestMethod.POST)
    public String chekclogin(HttpServletRequest request, HttpServletResponse response, Model model, Admin admin) throws IOException {

        Admin myadmin = adminService.selectAdminByname(admin.getAusername());
        if (myadmin == null) {
            model.addAttribute("msg", "error");
            return "login";
        } else if (myadmin.getAusername().equals(admin.getAusername()) && myadmin.getApwd().equals(encryptUtil.MD5(admin.getApwd()))) {
            HttpSession session = request.getSession();
            session.setAttribute("AdminInfo", myadmin);
            response.sendRedirect(request.getContextPath() + "/admin");
        } else {
            model.addAttribute("msg", "error");
            return "login";
        }
        return "login";
    }


    /**
     * 返回管理员后台
     * */
    @RequestMapping(value ="/admin",method = RequestMethod.GET)
    public String admin(HttpServletRequest request, HttpServletResponse response,Model model, Admin admin) throws IOException {

        HttpSession session = request.getSession();
        return "admin";

    }

    /**
     * 返回更新管理员后台
     * */
    @RequestMapping(value ="/admin/updateadmin",method = RequestMethod.GET)
    public String updateadmin(HttpServletRequest request, HttpServletResponse response,Model model, Admin admin) throws IOException {
        HttpSession session = request.getSession();
        return "adminupdate";
    }

    /**
     * 更新管理员
     * */
    @RequestMapping(value ="/admin/checkadminupdate",method = RequestMethod.POST)
    public void checkadminupdate(HttpServletRequest request, HttpServletResponse response,Admin admin) throws IOException {
        adminService.updateAdmin(admin);
        response.sendRedirect(request.getContextPath() + "/logout");
    }


    /**
     * 返回head界面
     * */
    @RequestMapping(value = "/head", method = RequestMethod.GET)
    public String head(HttpServletRequest request, HttpServletResponse response, Admin admin){
        return "head";
    }

    /**
     * 返回footer界面
     * */
    @RequestMapping(value = "/footer", method = RequestMethod.GET)
    public String footer(Map<String,Object> map){
        return "footer";
    }

    /**
     * 返回模态框
     * */
    @RequestMapping(value = "/alert", method = RequestMethod.GET)
    public String alert(Map<String,Object> map){
        return "alert";
    }


    /**
     * 退出界面
     * */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("AdminInfo");
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath() +"/login");
    }


}
