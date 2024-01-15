package com.self.sample.mapper;

import com.self.sample.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    /*사원정보 등록*/
    int insertUser(User user) throws Exception;

    /*사원정보 검색*/
    List<User> selectUser() throws Exception;

    /*사원 상세정보 조회*/
    List<User> selectUserInfo(int id) throws Exception;

    /*사원정보 삭제*/
    int deleteUser(int id) throws Exception;


}
