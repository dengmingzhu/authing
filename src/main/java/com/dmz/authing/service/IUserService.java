package com.dmz.authing.service;

import com.dmz.authing.common.ServerResponse;
import com.dmz.authing.entity.AuthUser;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author wuwanggao@souche.com
 */
public interface IUserService extends UserDetailsService {
    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    ServerResponse<String> register(AuthUser user);

}
