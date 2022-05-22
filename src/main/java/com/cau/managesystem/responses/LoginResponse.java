package com.cau.managesystem.responses;

import com.cau.managesystem.entity.User;
import lombok.Data;

@Data
public class LoginResponse extends BaseResponse{
    private User user;
}
