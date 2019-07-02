package com.imlc.springcloud.mapper;

import com.imlc.springcloud.entity.DeptEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: L.C
 * @Date: 2019-07-02 09:33
 */
@Mapper
public interface DeptMapper {

    @Insert("insert dept(db_name, db_source) values (#{dbName}, #{dbSource})")
    boolean addDept(DeptEntity deptEntity);

    @Select("select * from dept where dept_no = #{id}")
    DeptEntity findDeptById(Long id);

    @Select("select * from dept")
    List<DeptEntity> getDeptList();

}
