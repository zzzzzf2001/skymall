package com.zhang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhang.entity.UserCart;
import com.zhang.service.UserCartService;
import com.zhang.mapper.UserCartMapper;
import org.springframework.stereotype.Service;

/**
* @author 15754
* @description 针对表【user_cart(购物车商品关系表)】的数据库操作Service实现
* @createDate 2023-05-19 16:00:55
*/
@Service
public class UserCartServiceImpl extends ServiceImpl<UserCartMapper, UserCart>
    implements UserCartService{

}




