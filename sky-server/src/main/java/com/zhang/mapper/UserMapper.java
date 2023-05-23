package com.zhang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhang.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
* @author 15754
* @description 针对表【user(用户表)】的数据库操作Mapper
* @createDate 2023-05-19 16:00:55
* @Entity com.zhang.entity.User
*/
public interface UserMapper extends BaseMapper<User> {
    @Select("select id from user where phone=#{phone}")
    int hasPhoneInDB(@Param("phone") String phone);


    @Update("update user set password=#{password} where id=#{userId}")
    void setPassWord(String password, Integer userId);


}




