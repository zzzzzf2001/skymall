package com.zhang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhang.entity.Goods;
import com.zhang.service.GoodsService;
import com.zhang.mapper.GoodsMapper;
import org.springframework.stereotype.Service;

/**
* @author 15754
* @description 针对表【goods(商品表)】的数据库操作Service实现
* @createDate 2023-05-19 16:00:55
*/
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods>
    implements GoodsService{

}




