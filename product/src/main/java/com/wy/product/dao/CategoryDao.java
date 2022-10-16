package com.wy.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wy.product.entity.CategoryEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author HelloWorld
 * @create 2022/10/16 09:09
 * @email helloworld.dng@gmail.com
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
}
