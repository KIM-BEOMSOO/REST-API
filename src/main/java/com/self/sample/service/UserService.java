package com.self.sample.service;

import com.self.sample.domain.User;
import com.self.sample.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public int insertUser(User user) throws Exception {
        return userMapper.insertUser(user);
    }
    public List<User> selectUser() throws Exception {
        return userMapper.selectUser();
    }

    public int deleteUser(int id) throws Exception{
        return userMapper.deleteUser(id);
    }

    public List<User> selectUserInfo(int id) throws Exception {
        return userMapper.selectUserInfo(id);
    }


}
