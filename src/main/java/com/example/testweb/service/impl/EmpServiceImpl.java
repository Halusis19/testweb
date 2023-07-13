package com.example.testweb.service.impl;

import com.example.testweb.mapper.EmpMapper;
import com.example.testweb.pojo.Emp;
import com.example.testweb.pojo.PageBean;
import com.example.testweb.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
@Override                //第几页          //多少行
public PageBean page(Integer page, Integer pagesize,String name, Short gender, LocalDateTime begin,
                    LocalDateTime end) {
    PageHelper.startPage(page,pagesize);
    List<Emp> empList = empMapper.list(name,gender,begin,end);
    Page<Emp> p = (Page<Emp>) empList;
    PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
    return pageBean;
}

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }

    @Override
    public Emp getById(Integer id) {
        Emp emp =empMapper.getById(id);
        return emp;
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    @Override
    public Emp login(Emp emp) {
        return empMapper.getByUsernameAndPassword(emp);
    }
}
