package com.lxt.user.controller;

import com.lxt.core.http.ResponseMessage;
import com.lxt.user.entity.AccountEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户控制器，包含账户的增删改查方法。
 * 账户包含系统中的多种账户，有账户类型字段控制
 * @author lixuetao
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/account")
@Api(description = "账户控制器")
public class AccountController {

//    @GetMapping("/{id}")
//    @ApiOperation(value = "根据id获取用户信息")
//    public ResponseMessage<AccountEntity>

}
