package com.aolc.springcloud.controller;

import com.aolc.springcloud.entity.DeptEntity;
import com.aolc.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门服务提供
 *
 * @Auther: L.C
 * @Date: 2019-07-02 09:55
 */
@RestController
public class DeptProviderController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DeptService deptService;
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean addDept(@RequestBody DeptEntity deptEntity) {
        return deptService.addDept(deptEntity);
    }

    /**
     * 一旦调用服务方法失败并跑出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法,
     * 向调用发返回一个符合预期的、可处理的备选响应（FallBack），也就是processHystrix_Get方法调用，而不是长时间的等待或者抛出调用方法无法处理的异常
     *
     * @Author: L.C
     * @Date: 2019-07-09 14:20
     */
    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public DeptEntity getDeptById(@PathVariable("id") Long id) {
        DeptEntity dept = this.deptService.getDeptById(id);
        if (null == dept) {
            throw new RuntimeException("ID: " + id + "没有对应的信息");
        }

        return dept;
    }

    /**
     * 向调用发返回一个符合预期的、可处理的备选响应
     *
     * @Author: L.C
     * @Date: 2019-07-09 15:40
     */
    public DeptEntity processHystrix_Get(@PathVariable("id") Long id) {
        DeptEntity dept = new DeptEntity();
        dept.setDeptNo(id);
        dept.setDbName("ID:" + id + "没有对应的信息， null--@HystrixCommand");
        dept.setDbSource("no this database in MySQL");
        return dept;
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<DeptEntity> getDeptList() {
        return deptService.getDeptList();
    }

    @RequestMapping("/dept/discovery")
    public Object dicorvery() {
        List<String> list = client.getServices();

        List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance server : srvList) {
            logger.info(server.getServiceId() + "\t" + server.getHost() + "\t" + server.getPort() + "\t" + server.getUri());
        }
        return this.client;
    }

}
