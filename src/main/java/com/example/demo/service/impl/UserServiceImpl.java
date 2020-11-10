package com.example.demo.service.impl;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    private static final String REGEX_MOBILE = "1[3456789]d{9}";
    private static final String REGEX_EMAIL = "[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+.[a-zA-Z0-9_-]+";

    @Override
    public int delByID(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insUser(User user) {
//        if (!user.getMobile().matches(REGEX_MOBILE)
//                || !user.getEmail().matches(REGEX_EMAIL)
//                || new Date().compareTo(user.getBirthdate())<0)
//            return 0;
        user.setState("1");
        user.setCreate_time(new Date());
        user.setUpdate_time(new Date());
        return userMapper.insert(user);
    }

    @Override
    public int insUserSelective(User user) {
//        if (!user.getMobile().matches(REGEX_MOBILE)
//                || !user.getEmail().matches(REGEX_EMAIL)
//                || new Date().compareTo(user.getBirthdate())<0)
//            return 0;
        user.setState("1");
        user.setCreate_time(new Date());
        user.setUpdate_time(new Date());
        return userMapper.insertSelective(user);
    }

    @Override
    public int updByID(User user) {
        user.setCreate_time(null);
        user.setUpdate_time(new Date());
        System.out.println(user.toString());
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public int updByIDSelective(User user) {
        user.setCreate_time(null);
        user.setUpdate_time(new Date());
        System.out.println(user.toString());
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User selByID(long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> selAllUsers() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return userMapper.selectAll();
    }
}
