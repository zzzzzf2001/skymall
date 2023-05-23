package com.zhang.mapper;

import com.zhang.entity.Businesses;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 15754
* @description 针对表【businesses(商家)】的数据库操作Mapper
* @createDate 2023-05-19 16:00:55
* @Entity com.zhang.entity.Businesses
*/
@Mapper

public interface BusinessesMapper extends BaseMapper<Businesses> {

}




