package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.Result;
import com.example.demo.utils.ResultUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Resource
    private UserService userServiceImpl;

    @PostMapping
    public Result addUser(@RequestBody User user) {
        int row = userServiceImpl.insUserSelective(user);
        if (row == 0)
            return ResultUtils.failure4();
        return ResultUtils.success("添加成功");
    }

    /**
     * 逻辑删除
     */
    @DeleteMapping("/{id}")
    public Result delUserByID(@PathVariable long id) {
        User user = new User();
        user.setId(id);
        user.setState("-1");
        int row = userServiceImpl.updByIDSelective(user);
        if (row == 0)
            return ResultUtils.failure4("删除失败");
        return ResultUtils.success("成功删除"+row+"个用户");
    }

    @PutMapping
    public Result updUserByID(@RequestBody User user) {
        int row = userServiceImpl.updByIDSelective(user);
        if (row == 0)
            return ResultUtils.failure4("修改失败");
        return ResultUtils.success("修改成功");
    }


    @GetMapping("/{id}")
    public Result getUserByID(@PathVariable long id){
        User user = userServiceImpl.selByID(id);
        if (user == null)
            return ResultUtils.success("用户不存在");
        return ResultUtils.success(user);
    }

    @GetMapping
    public Result getAllUsers () {
        return ResultUtils.success(userServiceImpl.selAllUsers());
    }
}
