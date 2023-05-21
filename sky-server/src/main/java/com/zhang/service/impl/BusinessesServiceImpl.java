package com.zhang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhang.entity.Businesses;
import com.zhang.service.BusinessesService;
import com.zhang.mapper.BusinessesMapper;
import org.springframework.stereotype.Service;

/**
* @author 15754
* @description 针对表【businesses(商家)】的数据库操作Service实现
* @createDate 2023-05-19 16:00:55
*/
@Service
public class BusinessesServiceImpl extends ServiceImpl<BusinessesMapper, Businesses>
    implements BusinessesService{

}




