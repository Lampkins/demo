package com.example.demo.mapper;

import com.example.demo.pojo.User;

import java.util.List;

public interface UserMapper {
    /**
     *  根据主键删除数据库的记录,user
     *
     * @param id 用户id
     */
    int deleteByPrimaryKey(Long id);

    /**
     *  新写入数据库记录,user
     *
     * @param record 用户记录
     */
    int insert(User record);

    /**
     *  动态字段,写入数据库记录,user
     *
     * @param record 用户记录
     */
    int insertSelective(User record);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,user
     *
     * @param record 用户记录
     */
    int updateByPrimaryKeySelective(User record);

    /**
     *  根据主键来更新符合条件的数据库记录,user
     *
     * @param record 用户记录
     */
    int updateByPrimaryKey(User record);

    /**
     *  根据指定主键获取一条数据库记录,user
     *
     * @param id 用户id
     */
    User selectByPrimaryKey(Long id);

    /**
     * 查询所有用户
     * @return 用户列表
     */
    List<User> selectAll();
}