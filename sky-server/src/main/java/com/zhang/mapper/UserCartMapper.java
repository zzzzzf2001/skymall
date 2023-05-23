package com.zhang.mapper;

import com.zhang.entity.UserCart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 15754
* @description 针对表【user_cart(购物车商品关系表)】的数据库操作Mapper
* @createDate 2023-05-19 16:00:55
* @Entity com.zhang.entity.UserCart
*/
@Mapper

public interface UserCartMapper extends BaseMapper<UserCart> {

}




