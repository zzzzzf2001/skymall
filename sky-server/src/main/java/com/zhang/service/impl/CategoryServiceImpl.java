package com.zhang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhang.service.CategoryService;
import com.zhang.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

/**
* @author 15754
* @description 针对表【category(商品种类表)】的数据库操作Service实现
* @createDate 2023-05-19 18:41:43
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService{

}




