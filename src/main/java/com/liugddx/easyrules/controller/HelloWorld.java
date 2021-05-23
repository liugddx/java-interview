package com.liugddx.easyrules.controller;

import static com.liugddx.easyrules.controller.rules.SuspiciousRequestRule.SUSPICIOUS;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * <p>@ClassName HelloWorld</p>
 * <p>@description TODO</p>
 *
 * @author Ethan.liu
 * @version 1.0
 * @date 2021/5/23 20:53
 */
@RestController
public class HelloWorld {

    @GetMapping("/helloWorld")
    public String helloWorld(HttpServletRequest request){

        if (request.getAttribute(SUSPICIOUS) != null){
            return "Access denied";
        }

        return "Welcome!";
    }
}
