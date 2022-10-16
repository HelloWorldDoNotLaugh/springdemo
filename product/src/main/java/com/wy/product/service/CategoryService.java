package com.wy.product.service;

import com.wy.product.entity.CategoryEntity;

import java.util.Set;

/**
 * @author HelloWorld
 * @create 2022/10/16 09:07
 * @email helloworld.dng@gmail.com
 */
public interface CategoryService {

    /**
     * @description 获取三级分类菜单
     * @author HelloWorld
     * @create 2022/10/16 09:55
     * @param
     * @return java.util.Set<com.wy.product.entity.CategoryEntity>
     */
    Set<CategoryEntity> setWithTree();
}
