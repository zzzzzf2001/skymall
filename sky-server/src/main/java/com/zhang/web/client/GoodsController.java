package com.zhang.web.client;

import com.zhang.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : 15754
 * @version 1.0.0
 * @since : 2023/5/19 19:10
 * @@description 客户端对商品进行操作
 **/


@RestController
@Slf4j
@RequestMapping("/client/goods")
public class GoodsController {


    @GetMapping("/listTree")
    public Result listWithTree(){






       return null;
    }
}
