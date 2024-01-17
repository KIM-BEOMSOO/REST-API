package com.self.sample.controller;

import com.self.sample.domain.Comment;
import com.self.sample.domain.MyResponse;
import com.self.sample.domain.ResponseEntityUtil;
import com.self.sample.domain.User;
import com.self.sample.service.CommentService;
import com.self.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

//    /*정보 삭제*/
//    @PostMapping("/delete")
//    public ResponseEntity<String> deleteUser(int id) throws Exception {
//        int a = userService.deleteUser(id);
//        if (a == 1) {
//            return new ResponseEntity<>("사용자가 성공적으로 삭제되었습니다.", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("사용자 삭제에 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

//    /*정보 삭제-2번째*/
//    @PostMapping("/delete")
//    public ResponseEntity<MyResponse> deleteUser(int id) throws Exception {
//        int a = userService.deleteUser(id);
//        HttpHeaders headers = new HttpHeaders();
//
//        if (a == 1) {
//            headers.add("Custom-Header","Success");
//            MyResponse myResponse = new MyResponse(200,"success","ok",null);
//            return new ResponseEntity<>(myResponse, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    /*정보 삭제-3번째*/
    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteUser(int id) throws Exception {
        int a = userService.deleteUser(id);

        if (a == 1) {
            return ResponseEntityUtil.deleteSuccessResponse();
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    /*정보 삽입*/
//    @PostMapping("/add")
//    public ResponseEntity<String> addUser(User user) throws Exception {
//        int a = userService.insertUser(user);
//        if (a == 1) {
//            return new ResponseEntity<>("사용자 등록에 성공했습니다.", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("사용자 등록에 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    /*정보 삽입-2번째*/
    @PutMapping("/add")
    public ResponseEntity<Object> addUser(User user) throws Exception {
        int a = userService.insertUser(user);

        if (a == 1) {
            return ResponseEntityUtil.deleteSuccessResponse();
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*정보 검색-ResponseEntity-초안*/
//    @GetMapping("/select")
//    public ResponseEntity<List<User>> selectUser() throws Exception {
//        List<User> list = userService.selectUser();
//        if (!list.isEmpty()) {
//            return new ResponseEntity<>(list, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(list, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    /*정보 검색-ResponseEntity-2번째*/
//    @GetMapping("/select")
//    public ResponseEntity<MyResponse> selectUser() throws Exception {
//        List<User> list = userService.selectUser();
//        HttpHeaders headers = new HttpHeaders();
//
//        if (!list.isEmpty()) {
//            headers.add("Custom-Header", "Success");
//            MyResponse response = new MyResponse(200, "success", "ok", list);
//            return new ResponseEntity<>(response, headers, HttpStatus.OK);
//        } else {
//            headers.add("Custom-Header", "Error");
//            MyResponse response = new MyResponse(500, "error", "Internal Server Error", null);
//            return new ResponseEntity<>(response, headers, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
    
    /*정보 검색-3번째*/
    @GetMapping("/select")
    public ResponseEntity<Object> selectUser() throws Exception {
        List<User> list = userService.selectUser();

        if (!list.isEmpty()) {
            return ResponseEntityUtil.selectSuccessResponse(list);
        } else {
            MyResponse response = new MyResponse(500, "error", "Internal Server Error", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


//    /*사원 상세정보*/
//    @GetMapping("/select/{id}")
//    public ResponseEntity<List<User>> select(@PathVariable int id) throws Exception {
//        List<User> list = userService.selectUserInfo(id);
//        if(!list.isEmpty()){
//            return new ResponseEntity<>(list, HttpStatus.OK);
//        }else{
//            return new ResponseEntity<>(list, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    /*사원 상세정보 2번째*/
    @GetMapping("/select/{id}")
    public ResponseEntity<Object> select(@PathVariable int id) throws Exception {
        List<User> list = userService.selectUserInfo(id);
        if(!list.isEmpty()){
            return ResponseEntityUtil.selectSuccessResponse(list);
        }else{
            return new ResponseEntity<>(list, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*댓글 등록*/
    @PutMapping("/select/{id}/comment")
    public ResponseEntity<Object> addComment(@PathVariable("id") int id,Comment content) throws Exception {
        content.setPostId((long) id);
        int a = commentService.insertComment(content);
        if (a == 1) {
            return ResponseEntityUtil.deleteSuccessResponse();
        } else {
            return new ResponseEntity<>("댓글 삽입 실패", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*댓글 조회*/
    @GetMapping("/select/{postId}/comments")
    public ResponseEntity<Object> getCommentsForUser(@PathVariable Long postId,Comment content) throws Exception{
        List<Comment> comments = commentService.selectCommentsByPostId(content.getPostId());
        return ResponseEntityUtil.deleteSuccessResponse();

    }

    @GetMapping("/")
    public String welcome()  {
        return "Welcome";
    }
}
