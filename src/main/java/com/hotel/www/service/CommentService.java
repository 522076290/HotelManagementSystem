package com.hotel.www.service;

import com.hotel.www.model.Comment;

import java.util.List;

public interface CommentService {

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
    boolean deleteComment(int id);


    /**
     * 添加评论
     * @param comment
     */
    boolean addComment(Comment comment);
}
