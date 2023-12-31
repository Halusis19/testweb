package com.example.testweb.controller;

import com.example.testweb.pojo.Emp;
import com.example.testweb.pojo.Result;
import com.example.testweb.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        Emp e = empService.login(emp);
        return e!=null?Result.success():Result.error("用户名或密码错误");
    }
}
