package com.example.testweb.controller;

import com.example.testweb.pojo.Emp;
import com.example.testweb.pojo.PageBean;
import com.example.testweb.pojo.Result;
import com.example.testweb.service.EmpService;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 员工管理Controller
 */
@RestController

@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;
    @GetMapping
    public Result Page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDateTime begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDateTime end){
        System.out.println(name + " " + gender + " " + begin + " " + end);
        PageBean pagebean = empService.page(page,pageSize,name,gender,begin,end);
        return Result.success(pagebean);
    }
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        System.out.println(ids);
        empService.delete(ids);
        return Result.success();
    }
    @PostMapping
    public Result save(@RequestBody Emp emp ){
        empService.save(emp);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        System.out.println(id);
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }
    @PutMapping
    public Result update(@RequestBody Emp emp ){
        System.out.println(emp.getId());
        empService.update(emp);
        return Result.success();
    }
}
