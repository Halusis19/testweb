package com.example.testweb.service;

import com.example.testweb.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 */
public interface DeptService {

    public List<Dept> list();

    void delete(Integer id);

    void add(Dept dept);

    void update(Dept dept);

    Dept getbyId(Integer id);
}
