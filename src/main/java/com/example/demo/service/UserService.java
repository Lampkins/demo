package com.example.demo.service;

import com.example.demo.pojo.User;

import java.util.List;

public interface UserService {

    /**
     * 根据用户id删除用户
     * @param id 用户id
     * @return 影响记录数
     */
    int delByID(Long id);

    /**
     * 增加一个用户（完整信息）
     * @param user 用户信息
     * @return 影响记录数
     */
    int insUser(User user);

    /**
     * 增加一个用户（部分信息）
     * @param user 用户信息
     * @return 影响记录数
     */
    int insUserSelective(User user);

    /**
     * 根据用户id更新用户信息（完整信息）
     * @param user 用户信息
     * @return 影响记录数
     */
    int updByID(User user);

    /**
     * 根据用户id更新用户信息（部分信息）
     * @param user 用户信息
     * @return 影响记录数
     */
    int updByIDSelective(User user);

    /**
     * 根据用户id查询用户
     * @param id 用户id
     * @return 影响记录数
     */
    User selByID(long id);

    List<User> selAllUsers();
}
