package com.liugddx.web;

import com.liugddx.validation.CheckTimeInterval;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        @CheckTimeInterval(values = "1")
        private String test;
    }

    @PostMapping("/test")
    public String testRule(@Valid @RequestBody Param param){

        return param.getTest();
    }

    @GetMapping("/get/{id}")
    public String get(@PathVariable("id") String id){
        return id;
    }

    @PostMapping("/postRule")
    public String postRule(@PathParam("test") String test){

        return test;
    }

    @GetMapping("/none")
    public String none(){
        return "none";
    }

}
