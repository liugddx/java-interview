package com.liugddx.client;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>@ClassName FileTestClientFallbackFactory</p>
 * <p>@description TODO</p>
 *
 * @author Ethan.liu
 * @version 1.0
 * @date 2021/6/2 14:39
 */
@Slf4j
public class FileTestClientFallbackFactory implements FallbackFactory<FileClient> {

    @Override
    public FileClient create(Throwable throwable) {
        return () -> {
            log.error("fallback; file download reason was: " + throwable.getMessage());
            return null;
        };
    }
}
