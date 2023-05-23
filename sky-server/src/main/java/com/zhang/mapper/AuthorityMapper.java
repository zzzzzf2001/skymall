package com.zhang.mapper;

import com.zhang.entity.Authority;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 15754
* @description 针对表【authority(权限表)】的数据库操作Mapper
* @createDate 2023-05-19 16:00:55
* @Entity com.zhang.entity.Authority
*/
@Mapper

public interface AuthorityMapper extends BaseMapper<Authority> {

}




