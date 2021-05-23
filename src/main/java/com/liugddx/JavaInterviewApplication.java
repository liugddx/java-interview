package com.liugddx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * <p>@ClassName JavaInterviewApplication</p>
 * <p>@description TODO</p>
 *
 * @author Ethan.liu
 * @version 1.0
 * @date 2021/5/23 20:48
 */
@SpringBootApplication
@ServletComponentScan
public class JavaInterviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaInterviewApplication.class,args);
    }

}
