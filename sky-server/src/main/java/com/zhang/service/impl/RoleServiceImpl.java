package com.zhang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhang.entity.Role;
import com.zhang.service.RoleService;
import com.zhang.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author 15754
* @description 针对表【role(角色表)】的数据库操作Service实现
* @createDate 2023-05-19 16:00:55
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




