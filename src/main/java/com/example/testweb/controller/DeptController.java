package com.example.testweb.controller;

import com.example.testweb.pojo.Dept;
import com.example.testweb.pojo.Result;
import com.example.testweb.service.impl.DeptServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 部门管理Controller
 */
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptServiceImpl deptService;

    @GetMapping
    public Result list(){
        log.info("查询全部");
        return Result.success(deptService.list());
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("删除" + id);
        deptService.delete(id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Dept dept){
        System.out.println("添加");
        deptService.add(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getId(@PathVariable Integer id){
        Dept dept = deptService.getbyId(id);
        return Result.success(dept);
    }
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("修改部门:{}",dept);
        deptService.update(dept);
        return Result.success();
    }
}
