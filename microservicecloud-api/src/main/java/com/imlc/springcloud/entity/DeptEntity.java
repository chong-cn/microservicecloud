package com.imlc.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Auther: L.C
 * @Date: 2019-07-01 16:38
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class DeptEntity {

    private long deptNo;
    private String dbName;
    private String dbSource;

}
