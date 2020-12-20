package com.dmz.authing.web;

import com.dmz.authing.common.ServerResponse;
import com.dmz.authing.entity.AuthUser;
import com.dmz.authing.service.IUserService;
import com.dmz.authing.web.dto.AuthUserFactory;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Resource
    private IUserService iUserService;

    @PostMapping(value = "register")
    public ServerResponse<String> register(String userJson) {
        AuthUser user = AuthUserFactory.parseCreated(userJson);
        return iUserService.register(user);
    }

    @GetMapping(value = "register")
    public ServerResponse<String> aaa() {
        return ServerResponse.createBySuccess();
    }

}
