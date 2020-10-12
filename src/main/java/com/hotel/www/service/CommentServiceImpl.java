package com.hotel.www.service;

import com.hotel.www.mapper.CommentMapper;
import com.hotel.www.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;


    @Override
    public List<Comment> selectCommentList() {
        return commentMapper.selectCommentList();
    }

    @Override
    public boolean deleteComment(int id) {

        if (id>0){
                int e = commentMapper.deleteComment(id);
                if (e>0){
                    return true;
                }
        }
        return false;
    }

    @Override
    public boolean addComment(Comment comment) {
        commentMapper.addComment(comment);
        return true;
    }


}
