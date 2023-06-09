package com.zhang.mapper;

import com.zhang.entity.UserBusinesses;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 15754
* @description 针对表【user_businesses(用户关注商家表)】的数据库操作Mapper
* @createDate 2023-05-19 18:06:11
* @Entity com.zhang.entity.UserBusinesses
*/
@Mapper

public interface UserBusinessesMapper extends BaseMapper<UserBusinesses> {

}




