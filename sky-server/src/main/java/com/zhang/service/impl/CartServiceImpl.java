package com.zhang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhang.entity.Cart;
import com.zhang.service.CartService;
import com.zhang.mapper.CartMapper;
import org.springframework.stereotype.Service;

/**
* @author 15754
* @description 针对表【cart(购物车)】的数据库操作Service实现
* @createDate 2023-05-19 16:00:55
*/
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart>
    implements CartService{

}




