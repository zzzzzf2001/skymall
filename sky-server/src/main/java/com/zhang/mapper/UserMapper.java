package com.zhang.mapper;

import com.zhang.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
* @author 15754
* @description 针对表【user(用户表)】的数据库操作Mapper
* @createDate 2023-05-19 16:00:55
* @Entity com.zhang.entity.User
*/
public interface UserMapper extends BaseMapper<User> {

    int hasPhoneInDB(@Param("phone") String phone);
}




