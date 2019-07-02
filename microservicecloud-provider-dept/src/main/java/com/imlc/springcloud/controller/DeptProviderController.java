package com.imlc.springcloud.controller;

import com.imlc.springcloud.entity.DeptEntity;
import com.imlc.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门服务提供
 *
 * @Auther: L.C
 * @Date: 2019-07-02 09:55
 */
@RestController
@RequestMapping("/provider/dept")
public class DeptProviderController {

    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean addDept(@RequestBody DeptEntity deptEntity) {
        return deptService.addDept(deptEntity);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public DeptEntity getDeptById(@PathVariable("id") Long id) {
        return deptService.getDeptById(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET )
    public List<DeptEntity> getDeptList() {
        return deptService.getDeptList();
    }

}
