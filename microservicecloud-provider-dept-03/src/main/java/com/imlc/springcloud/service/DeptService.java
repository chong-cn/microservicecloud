package com.imlc.springcloud.service;

import com.imlc.springcloud.entity.DeptEntity;

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
