package com.self.sample.mapper;


import com.self.sample.domain.Comment;
import com.self.sample.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    int insertComment(Comment comment) throws Exception;
    List<Comment> selectCommentsByPostId(Long postId) throws Exception;

}
