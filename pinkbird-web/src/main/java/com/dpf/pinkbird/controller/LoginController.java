package com.dpf.pinkbird.controller;

import com.dpf.pinkbird.bean.Meta;
import com.dpf.pinkbird.bean.User;
import com.dpf.pinkbird.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Controller
@RequestMapping("auth")
@Slf4j
public class LoginController {

    @Resource
    private LoginService loginService;

    @ResponseBody
    @PostMapping("login")
    public Object login(User user) {
        return new Meta(getToken(user), "ok");
    }

    public String getToken(User user) {
        return JWT.create().withAudience(user.getUsername())
                .sign(Algorithm.HMAC256(user.getPassword()));
    }
}
