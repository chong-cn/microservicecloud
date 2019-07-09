package com.imlc.springcloud.service;

import com.imlc.springcloud.entity.DeptEntity;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 服务降级：服务降级处理是在客户端完成的，与服务端无关
 * 注意：不要忘记在类桑添加@Component
 *
 * @Auther: L.C
 * @Date: 2019-07-09 15:56
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {

            public boolean addDept(DeptEntity deptEntity) {
                return false;
            }

            public DeptEntity getDeptById(Long id) {
                DeptEntity dept = new DeptEntity();
                dept.setDeptNo(id);
                dept.setDbName("ID:\"" + id + "\"没有对应的信息， Cpnsumer客户度提供的降级信息，此刻服务Provider已经关闭！");
                dept.setDbSource("no this database in MySQL");
                return dept;
            }

            public List<DeptEntity> getDeptList() {
                return null;
            }

        };
    }
}
