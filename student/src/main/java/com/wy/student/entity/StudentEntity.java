package com.wy.student.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author HelloWorld
 * @create 2022/10/2 10:21
 * @email helloworld.dng@gmail.com
 */
@Data
@TableName("STUDENT")
public class StudentEntity {
    private BigDecimal id;

    private BigDecimal sid;

    private String name;

    private String className;
}
