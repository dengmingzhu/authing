package com.dmz.authing.service.impl;

import com.dmz.authing.common.ServerResponse;
import com.dmz.authing.entity.AuthUser;
import com.dmz.authing.repository.AuthUserRepository;
import com.dmz.authing.service.IUserService;
import java.util.UUID;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author wuwanggao@souche.com
 */
@Service("iUserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Resource
    private AuthUserRepository authUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser user = new AuthUser(username);
        return authUserRepository.findOne(Example.of(user))
            .orElseThrow(() -> new UsernameNotFoundException("用户名不存在"));
    }

    @Override
    public ServerResponse<String> register(AuthUser user) {
        user.passwordEncode(passwordEncoder.encode(user.getPassword()));
        authUserRepository.save(user);
        return ServerResponse.createBySuccessMessage("注册成功");
    }

}
