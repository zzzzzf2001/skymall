package com.zhang.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : 15754
 * @version 1.0.0
 * @since : 2023/5/21 20:45
 **/


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDTO {
    //手机号
    private String phone;

    //昵称
    private String nickName;



}
