package com.dmz.authing.web;

import com.dmz.authing.common.ServerResponse;
import com.dmz.authing.entity.AuthUser;
import com.dmz.authing.service.IUserService;
import com.dmz.authing.web.dto.AuthUserFactory;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("user")
public class AuthUserController {
    @Resource
    private IUserService userService;

//    @PostMapping(value = "add")
//    public ServerResponse<String> add(String userJson) {
//        userService.save(AuthUserFactory.parseCreated(userJson));
//        return ServerResponse.createBySuccess();
//    }
//
//    @DeleteMapping(value = "delete")
//    public ServerResponse<String> delete(String id) {
//        userService.delete(id);
//        return ServerResponse.createBySuccess();
//    }
//
//    @PutMapping(value = "update")
//    public ServerResponse<String> update(String userJson) {
//        userService.save(AuthUserFactory.parseCreated(userJson));
//        return ServerResponse.createBySuccess();
//    }
//
//    @RequestMapping(value = "find")
//    public ServerResponse<String> find(String id) {
//        AuthUser authUser = authUserService.findById(id);
//        return ServerResponse.createBySuccess(AuthUserFactory.toJSON(authUser));
//    }


}
