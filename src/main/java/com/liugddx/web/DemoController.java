package com.liugddx.web;

import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>@ClassName DemoController</p>
 * <p>@description TODO</p>
 *
 * @author Ethan.liu
 * @version 1.0
 * @date 2021/5/26 15:07
 */
@RestController
public class DemoController {

    @Data
    static class Param{
        private String test;
    }

    @PostMapping("/test")
    public String testRule(@RequestBody Param param){

        return param.getTest();
    }

}
