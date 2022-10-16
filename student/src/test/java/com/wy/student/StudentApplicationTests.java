package com.wy.student;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.wy.student.entity.StudentEntity;
import com.wy.student.mapper.StudentMapper;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class StudentApplicationTests {

    @Resource
    private StudentMapper studentMapper;
    @Test
    public void selectTest() {
        StudentEntity student = new LambdaQueryChainWrapper<>(studentMapper)
                .eq(StudentEntity::getId, 1)
                .one();

        System.out.println(student.toString());


    }

    @Test
    void contextLoads() {
    }

}
