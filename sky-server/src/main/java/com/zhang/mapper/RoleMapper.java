package com.zhang.mapper;

import com.zhang.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 15754
* @description 针对表【role(角色表)】的数据库操作Mapper
* @createDate 2023-05-19 16:00:55
* @Entity com.zhang.entity.Role
*/
@Mapper

public interface RoleMapper extends BaseMapper<Role> {

}




