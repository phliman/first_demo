package com.example.first_demo.controller;

import com.example.first_demo.mapper.UserMapper;
import com.example.first_demo.pojo.User;
import com.example.first_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("/user")
public class IndexController {

    @Autowired
    public UserMapper userMapper;

    @Autowired
    public UserService userService;




    public void gitTest(){
        System.out.println("aaaaaaaaaa");
         System.out.println("bbbb");
    }







    // 新增和修改
    @PostMapping
    public Integer save(@RequestBody User user) {
        // 新增或者更新
        return userService.save(user);
    }
    @GetMapping
    public List<User> index(){
        List<User> allUser = userMapper.findAllUser();
        return allUser;
    }

    @GetMapping("/page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum , @RequestParam Integer pageSize ){
        pageNum=(pageNum - 1 ) * pageSize;

        /*每页的数据*/
        List<User> data = userMapper.selectPage(pageNum, pageSize);

        /*总共的页数*/
        Integer total = userMapper.selectTotal();

       Map<String, Object> res = new HashMap<>();
        res.put("data",data);
        res.put("total",total);


        return res;
    }


}
