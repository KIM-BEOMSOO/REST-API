package com.self.sample.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class MyResponse {
    private final int code;
    private final String status;
    private final String message;
    private final List<User> result;

    public MyResponse(int code, String status, String message, List<User> result) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.result = result;
    }
}
