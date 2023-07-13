package com.example.testweb.service;

import com.example.testweb.pojo.Emp;
import com.example.testweb.pojo.PageBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 员工管理
 */
public interface EmpService {

    PageBean page(Integer page, Integer pagesize,String name, Short gender,
                  LocalDateTime begin,
                  LocalDateTime end);

    void delete(List<Integer> ids);

    void save(Emp emp);

    Emp getById(Integer id);

    void update(Emp emp);

    Emp login(Emp emp);
}
