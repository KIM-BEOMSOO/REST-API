package com.self.sample.domain;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ResponseEntityUtil {

    /*사원정보 검색*/
    public static ResponseEntity<Object> selectSuccessResponse(List<User> result) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Success");

        MyResponse response = new MyResponse(200, "success", "ok", result);
//        return new ResponseEntity<>(response, headers, HttpStatus.OK);
          return ResponseEntity.ok().headers(headers).body(response);
    }

    /*사원정보 삭제+삽입*/
    /*댓글 등록+조회*/
    public static ResponseEntity<Object> deleteSuccessResponse() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Success");

        return ResponseEntity.ok().headers(headers).body("success");
    }


}
