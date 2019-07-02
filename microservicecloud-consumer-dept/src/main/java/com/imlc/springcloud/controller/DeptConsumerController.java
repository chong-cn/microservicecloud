package com.imlc.springcloud.controller;

import com.imlc.springcloud.entity.DeptEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Auther: L.C
 * @Date: 2019-07-02 12:21
 */
@RestController
@RequestMapping("/consumer/dept")
public class DeptConsumerController {

    private static final String REST_URL_PRIFIX = "http://localhost:8001/provider/dept";
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/add")
    public boolean addDept(DeptEntity deptEntity) {
        return restTemplate.postForObject(REST_URL_PRIFIX + "/add", deptEntity, Boolean.class);
    }

    @RequestMapping(value = "/get/{id}")
    public DeptEntity getDept(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PRIFIX + "/get/" + id , DeptEntity.class);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/list")
    public List<DeptEntity> getDeptList() {
        return restTemplate.getForObject(REST_URL_PRIFIX + "/list", List.class);
    }


}
