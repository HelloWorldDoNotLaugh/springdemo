package com.wy.product.controller;
import com.alibaba.fastjson.JSON;
import com.wy.product.entity.CategoryEntity;
import com.wy.product.service.CategoryService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @author HelloWorld
 * @create 2022/10/16 09:07
 * @email helloworld.dng@gmail.com
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    @RequestMapping("/set/tree")
    public String setWithTree() {
        Set<CategoryEntity> categoryEntitySet = categoryService.setWithTree();
        return JSON.toJSONString(categoryEntitySet);
    }
}
