package com.hotel.www.controller;

import com.hotel.www.model.Comment;
import com.hotel.www.service.CommentService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 评论接口控制器
 * @author My VM
 */
@RestController
@RequestMapping("api/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    /**
     * 查询评论列表
     * @return
     */
    @ApiOperation(value="查询评论接口", notes="查询所有的评论")
    @RequestMapping(value = "/selectAllComment",method = RequestMethod.POST)
    public Map<String,Object> selectAllComment() {
        Map<String,Object> map = new HashMap<>();
        List<Comment> list = commentService.selectCommentList();
        map.put("data",list);
        return map;
    }

    /**
     * 通过id删除评论
     * @param id
     * @return
     */
    @ApiOperation(value="删除评论接口", notes="通过id删除评论")
    @RequestMapping(value = "/deleteComment",method = RequestMethod.POST)
    public Map<String,Object> deleteComment(int id) {
        Map<String,Object> map = new HashMap<>();
        Boolean flag = commentService.deleteComment(id);
        if(flag==true){
            map.put("data","删除评论成功");
        }else if(flag==false) {
            map.put("data","删除评论失败");
        }
        return map;
    }


    /**
     * 添加评论
     * @param comment
     * @return
     */
    @ApiOperation(value="添加评论接口", notes="添加评论")
    @RequestMapping(value = "/addComment",method = RequestMethod.POST)
    @ApiImplicitParam( required=true, name = "comment",value = "评论实例",dataType = "Comment")
    public Map<String,Object> addAdmin(@RequestBody Comment comment) {
        Map<String,Object> map = new HashMap<>();
        Boolean flag = commentService.addComment(comment);
        if(flag==true){
            map.put("data","评论成功");
        }
        return map;
    }

}
