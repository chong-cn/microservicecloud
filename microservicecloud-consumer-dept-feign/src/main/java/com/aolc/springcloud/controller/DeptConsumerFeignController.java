package com.aolc.springcloud.controller;

import com.aolc.springcloud.entity.DeptEntity;
import com.aolc.springcloud.service.DeptClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: L.C
 * @Date: 2019-07-02 12:21
 */
@RestController
public class DeptConsumerFeignController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DeptClientService service;


    @RequestMapping(value = "/consumer/dept/add")
    public boolean addDept(DeptEntity deptEntity) {
        return this.service.addDept(deptEntity);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public DeptEntity getDept(@PathVariable("id") Long id) {
       return this.service.getDeptById(id);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/consumer/dept/list")
    public List<DeptEntity> getDeptList() {
        return this.service.getDeptList();
    }

}
