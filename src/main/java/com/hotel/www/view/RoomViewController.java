package com.hotel.www.view;

import com.hotel.www.model.Admin;
import com.hotel.www.model.Room;
import com.hotel.www.model.RoomType;
import com.hotel.www.service.RoomService;
import com.hotel.www.service.RoomTypeService;
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
@RequestMapping(value ="/admin/room")
public class RoomViewController {
    @Autowired
    RoomService roomService;
    @Autowired
    RoomTypeService roomTypeService;


    /**
     * 返回房间列表
     * */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String roomlist(HttpServletRequest request, HttpServletResponse response, Admin admin) throws IOException {
        HttpSession session = request.getSession();
        List<Room> roomlist = roomService.selectRoomList();
        session.setAttribute("roomlist",roomlist);
        return "room/roomlist";
    }

    /**
     * 删除房间
     * */
    @RequestMapping(value = "/deleteroom", method = RequestMethod.GET)
    public void deleteroom(HttpServletRequest request, HttpServletResponse response,int rpk) throws IOException {
        HttpSession session = request.getSession();
        System.out.println(rpk);
        roomService.deleteRoom(rpk);
        response.sendRedirect(request.getContextPath() +"/admin/room/list");
    }

    /**
     * 返回更新房间页面
     * */
    @RequestMapping(value = "/updateroom", method = RequestMethod.GET)
    public String updateroom(HttpServletRequest request, HttpServletResponse response, Model model, int rpk) throws IOException {
        HttpSession session = request.getSession();
        Room updateroom = roomService.selectRoomByPk(rpk);
        model.addAttribute("updateroom",updateroom);
        return "room/updateroom";
    }



    /**
     * 更新房间
     * */
    @RequestMapping(value = "/checkroomupdate", method = RequestMethod.POST)
    public void checkroomupdate(HttpServletRequest request, HttpServletResponse response,Room room) throws IOException {
        HttpSession session = request.getSession();
        roomService.updateRoom(room);
        response.sendRedirect(request.getContextPath() +"/admin/room/list");
    }

    /**
     * 返回添加房间界面
     * */
    @RequestMapping(value = "/addroom", method = RequestMethod.GET)
    public String addroom(HttpServletRequest request, HttpServletResponse response,Room room) throws IOException {
        return "room/addroom";
    }


    /**
     * 添加房间
     * */
    @RequestMapping(value = "/checkaddroom", method = RequestMethod.POST)
    public void checkaddroom(HttpServletRequest request, HttpServletResponse response,Room room) throws IOException {
        HttpSession session = request.getSession();
        System.out.println(room);
        roomService.addRoom(room);
        response.sendRedirect(request.getContextPath() +"/admin/room/list");
    }

}
