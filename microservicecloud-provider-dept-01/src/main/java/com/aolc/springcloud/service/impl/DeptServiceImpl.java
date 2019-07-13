package com.aolc.springcloud.service.impl;

import com.aolc.springcloud.mapper.DeptMapper;
import com.aolc.springcloud.entity.DeptEntity;
import com.aolc.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: L.C
 * @Date: 2019-07-02 09:35
 */
@Service("deptService")
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    public boolean addDept(DeptEntity deptEntity) {
        return deptMapper.addDept(deptEntity);
    }

    public DeptEntity getDeptById(Long id) {
        return deptMapper.findDeptById(id);
    }

    public List<DeptEntity> getDeptList() {

        return deptMapper.getDeptList();
    }

}
