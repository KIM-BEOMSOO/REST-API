package com.self.sample.service;

import com.self.sample.domain.Comment;
import com.self.sample.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;

    public int insertComment(Comment comment) throws Exception {
        return commentMapper.insertComment(comment);
    }

    public List<Comment> selectCommentsByPostId(Long postId) throws Exception {
        return commentMapper.selectCommentsByPostId(postId);
    }
}
