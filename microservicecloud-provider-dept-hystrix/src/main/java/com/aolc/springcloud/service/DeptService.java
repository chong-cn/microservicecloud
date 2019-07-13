package com.aolc.springcloud.service;

import com.aolc.springcloud.entity.DeptEntity;

import java.util.List;

/**
 * @Auther: L.C
 * @Date: 2019-07-02 09:34
 */
public interface DeptService {

    boolean addDept(DeptEntity deptEntity);

    DeptEntity getDeptById(Long id);

    List<DeptEntity> getDeptList();
}
