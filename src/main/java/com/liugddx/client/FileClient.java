package com.liugddx.client;

import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>@InterfaceName FileClient</p>
 * <p>@description TODO</p>
 *
 * @author Ethan.liu
 * @version 1.0
 * @date 2021/6/2 14:38
 */
@FeignClient(name = "file", fallbackFactory = FileTestClientFallbackFactory.class)
public interface FileClient {

    /**
     * 下载文件测试
     */
    @RequestMapping(value ="/download", method = RequestMethod.GET)
    Response download();
}
