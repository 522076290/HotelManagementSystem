package com.hotel.www.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.hotel.www.model.Comment;

import java.util.List;

@Mapper
public interface CommentMapper {

    /**
     * 查询所有评论
     * @return
     */
    List<Comment> selectCommentList();


    /**
     * 通过评论id删除用户
     * @param id
     * @return
     */
    int deleteComment(int id);


    /**
     * 添加用户
     * @param comment
     */
    int addComment(Comment comment);
}
