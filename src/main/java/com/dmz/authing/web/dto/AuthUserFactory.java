package com.dmz.authing.web.dto;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.dmz.authing.entity.AuthUser;

public class AuthUserFactory {
    public static AuthUser parseCreated(String json) {
        return JSON.parseObject(json, AuthUser.class, Feature.SupportNonPublicField);
    }

    public static String toJSON(AuthUser user) {
        return JSON.toJSONString(user);
    }
}
