package com.liugddx;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <p>@ClassName JavaInterviewApplication</p>
 * <p>@description TODO</p>
 *
 * @author Ethan.liu
 * @version 1.0
 * @date 2021/5/26 15:41
 */
@SpringCloudApplication
@EnableFeignClients
public class JavaInterviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaInterviewApplication.class,args);
    }

}
