package com.zhang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhang.entity.Category;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 15754
* @description 针对表【category(商品种类表)】的数据库操作Mapper
* @createDate 2023-05-19 16:00:55
* @Entity com.zhang.entity.Category
*/
@Mapper

public interface CategoryMapper extends BaseMapper<Category> {

}




