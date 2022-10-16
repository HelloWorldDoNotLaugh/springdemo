package com.wy.product.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.wy.product.dao.CategoryDao;
import com.wy.product.entity.CategoryEntity;
import com.wy.product.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author HelloWorld
 * @create 2022/10/16 09:08
 * @email helloworld.dng@gmail.com
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryDao categoryDao;

    /**
     * @description 实现三级分类菜单
     *               首先获取1级分类，然后递归获取所有子分类
     * @author HelloWorld
     * @create 2022/10/16 11:07
     * @param
     * @return java.util.Set<com.wy.product.entity.CategoryEntity>
     */
    @Override
    public Set<CategoryEntity> setWithTree() {
        List<CategoryEntity> categoryList = new LambdaQueryChainWrapper<>(categoryDao).list();

        return categoryList.stream()
                .filter((categoryEntity) -> 0 == categoryEntity.getParentCid())
                .map((root) -> {
                    root.setChildren(getChildren(root, categoryList));
                    return root;
                })
                .sorted(Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort())))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    /**
     * @description 获取所有子分类
     * @author HelloWorld
     * @create 2022/10/16 11:05
     * @param root
     * @param all
     * @return java.util.Set<com.wy.product.entity.CategoryEntity>
     */
    public Set<CategoryEntity> getChildren(CategoryEntity root, List<CategoryEntity> all) {
       return all.stream()
                .filter((category) -> category.getParentCid().equals(root.getCatId()))
                .map((category) -> {
                    category.setChildren(getChildren(category, all));
                    return category;
                })
                .sorted(Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort())))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
