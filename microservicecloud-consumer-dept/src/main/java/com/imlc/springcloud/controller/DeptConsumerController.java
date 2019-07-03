package com.imlc.springcloud.controller;

import com.imlc.springcloud.entity.DeptEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;

    // 原始调用
//    private static final String REST_URL_PRIFIX = "http://localhost:8001/provider/dept";
    private static final String REST_URL_PRIFIX = "http://MICROSERVICECLOUD-DEPT";

    @RequestMapping(value = "/add")
    public boolean addDept(DeptEntity deptEntity) {
        return restTemplate.postForObject(REST_URL_PRIFIX + "/provider/dept/add", deptEntity, Boolean.class);
    }

    @RequestMapping(value = "/get/{id}")
    public DeptEntity getDept(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PRIFIX + "/provider/dept/get/" + id , DeptEntity.class);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/list")
    public List<DeptEntity> getDeptList() {
        logger.info("部门消费者获取部门提供者列表");
        return restTemplate.getForObject(REST_URL_PRIFIX + "/provider/dept/list", List.class);
    }

    @RequestMapping(value = "/dicovery")
    public Object discovery() {
        return restTemplate.getForObject(REST_URL_PRIFIX + "/provider/dept/discovery", List.class);
    }



}
