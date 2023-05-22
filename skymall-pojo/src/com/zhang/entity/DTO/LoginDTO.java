package com.zhang.entity.DTO;

import lombok.Builder;
import lombok.Data;

/**
 * @author : 15754
 * @version 1.0.0
 * @since : 2023/5/22 21:03
 **/



@Data
@Builder
public class LoginDTO {
    private String password;
    private String username;
    private String phone;
}
