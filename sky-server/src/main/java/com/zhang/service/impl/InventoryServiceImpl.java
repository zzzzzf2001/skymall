package com.zhang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhang.entity.Inventory;
import com.zhang.service.InventoryService;
import com.zhang.mapper.InventoryMapper;
import org.springframework.stereotype.Service;

/**
* @author 15754
* @description 针对表【inventory(库存表)】的数据库操作Service实现
* @createDate 2023-05-19 16:00:55
*/
@Service
public class InventoryServiceImpl extends ServiceImpl<InventoryMapper, Inventory>
    implements InventoryService{

}




