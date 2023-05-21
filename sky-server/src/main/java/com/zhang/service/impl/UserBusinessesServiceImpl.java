package com.zhang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhang.entity.UserBusinesses;
import com.zhang.service.UserBusinessesService;
import com.zhang.mapper.UserBusinessesMapper;
import org.springframework.stereotype.Service;

/**
* @author 15754
* @description 针对表【user_businesses(用户关注商家表)】的数据库操作Service实现
* @createDate 2023-05-19 18:06:11
*/
@Service
public class UserBusinessesServiceImpl extends ServiceImpl<UserBusinessesMapper, UserBusinesses>
    implements UserBusinessesService{

}




