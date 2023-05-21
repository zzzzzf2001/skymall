package com.zhang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhang.entity.Authority;
import com.zhang.service.AuthorityService;
import com.zhang.mapper.AuthorityMapper;
import org.springframework.stereotype.Service;

/**
* @author 15754
* @description 针对表【authority(权限表)】的数据库操作Service实现
* @createDate 2023-05-19 16:00:55
*/
@Service
public class AuthorityServiceImpl extends ServiceImpl<AuthorityMapper, Authority>
    implements AuthorityService{

}




