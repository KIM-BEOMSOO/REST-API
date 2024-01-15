package com.self.sample.controller;

import com.self.sample.domain.Comment;
import com.self.sample.domain.User;
import com.self.sample.service.CommentService;
import com.self.sample.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    /*정보 삭제*/
    @PostMapping("/delete")
    public ResponseEntity<String> deleteUser(int id) throws Exception {
        int a = userService.deleteUser(id);
        if (a == 1) {
            return new ResponseEntity<>("사용자가 성공적으로 삭제되었습니다.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("사용자 삭제에 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*정보 삽입*/
    @PostMapping("/add")
    public ResponseEntity<String> addUser(User user) throws Exception {
        int a = userService.insertUser(user);
        if (a == 1) {
            return new ResponseEntity<>("사용자 등록에 성공했습니다.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("사용자 등록에 실패했씁니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*정보 검색*/
    @GetMapping("/select")
    public ResponseEntity<List<User>> selectUser() throws Exception {
        List<User> list = userService.selectUser();
        if (!list.isEmpty()) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(list, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*사원 상세정보*/
    @GetMapping("/select/{id}")
    public ResponseEntity<List<User>> select(@PathVariable int id) throws Exception {
        List<User> list = userService.selectUserInfo(id);
        if(!list.isEmpty()){
            return new ResponseEntity<>(list, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(list, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /*댓글 등록*/
    @PostMapping("/select/{id}/comment")
    public ResponseEntity<String> addComment(@PathVariable("id") int id,Comment content) throws Exception {
        content.setPostId((long) id);
        int a = commentService.insertComment(content);
        if (a == 1) {
            return new ResponseEntity<>("댓글 삽입 성공", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("댓글 삽입 실패", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*댓글 조회*/
    @GetMapping("/select/{postId}/comments")
    public ResponseEntity<List<Comment>> getCommentsForUser(@PathVariable Long postId,Comment content) throws Exception{
        try {
            List<Comment> comments = commentService.selectCommentsByPostId(content.getPostId());
            return new ResponseEntity<>(comments, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public String welcome()  {
        return "Welcome";
    }
}
