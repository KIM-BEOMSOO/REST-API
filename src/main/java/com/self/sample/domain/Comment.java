package com.self.sample.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@Setter
@Getter
public class Comment {
    private int id;
    private String content;
    private Long postId;


}
