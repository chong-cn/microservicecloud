package com.imlc.springcloud.service;

import com.imlc.springcloud.entity.DeptEntity;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Feign只在使便携Java Http客户端变得更容易
 *
 * 实现方式：接口 + 注解
 *
 * @Auther: L.C
 * @Date: 2019-07-04 14:33
 */
@FeignClient(value = "MICROSERVICECLOUD-DEPT")
public interface DeptClientService {

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    boolean addDept(DeptEntity deptEntity);

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    DeptEntity getDeptById(@PathVariable("id") Long id);

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    List<DeptEntity> getDeptList();

}
