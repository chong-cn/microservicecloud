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
public class DeptConsumerController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;

    // 原始调用
//    private static final String REST_URL_PRIFIX = "http://localhost:8001";
    private static final String REST_URL_PRIFIX = "http://MICROSERVICECLOUD-DEPT";

    @RequestMapping(value = "/consumer/dept/add")
    public boolean addDept(DeptEntity deptEntity) {
        String url = REST_URL_PRIFIX + "/provider/dept/add";
        return restTemplate.postForObject(url, deptEntity, Boolean.class);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public DeptEntity getDept(@PathVariable("id") Long id) {
        String url = REST_URL_PRIFIX + "/provider/dept/get/" + id;
        return restTemplate.getForObject(url, DeptEntity.class);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/consumer/dept/list")
    public List<DeptEntity> getDeptList() {
        logger.info("部门消费者获取部门提供者列表");
        String url = REST_URL_PRIFIX + "/provider/dept/list";
        logger.info("请求的URL： " + url);
        return restTemplate.getForObject(url, List.class);
    }

    @RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery() {
        String url = REST_URL_PRIFIX + "/provider/dept/discovery";
        return restTemplate.getForObject(url, Object.class);
    }


}
