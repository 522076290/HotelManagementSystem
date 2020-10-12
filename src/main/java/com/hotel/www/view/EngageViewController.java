package com.hotel.www.view;


import com.hotel.www.model.Engage;
import com.hotel.www.model.Room;
import com.hotel.www.service.EngageService;
import com.hotel.www.service.RoomService;
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

@Controller
@RequestMapping(value ="/admin/engage")
public class EngageViewController {

    @Autowired
    EngageService engageService;
    @Autowired
    RoomService roomService;


    /**
     * 返回用户列表
     * */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String roomlist(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        List<Engage> engageslist = engageService.selectEngageList();
        session.setAttribute("engageslist",engageslist);
        return "engage/engageslist";
    }

    /**
     * 删除订单
     * */
    @RequestMapping(value = "/deleteengage", method = RequestMethod.GET)
    public void deleteengage(HttpServletRequest request, HttpServletResponse response,int epk) throws IOException {
        HttpSession session = request.getSession();
        Engage myengage = engageService.selectRoomByPk(epk);
        engageService.deleteEngage(epk);
        Room room  = roomService.selectRoomById(myengage.getRid());
        room.setState("a");
        roomService.updateRoom(room);
        response.sendRedirect(request.getContextPath() +"/admin/engage/list");
    }


    /**
     * 返回更新订单页面
     * */
    @RequestMapping(value = "/updateengage", method = RequestMethod.GET)
    public String updateengage(HttpServletRequest request, HttpServletResponse response, Model model, int epk) throws IOException {
        HttpSession session = request.getSession();
        Engage updateengage = engageService.selectRoomByPk(epk);
        model.addAttribute("updateengage",updateengage);
        return "room/updateengage";
    }

}
