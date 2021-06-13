package com.liugddx.websocketconfig;

import lombok.Data;

/**
 * <p>@ClassName MessageBody</p>
 * <p>@description TODO</p>
 *
 * @author Ethan.liu
 * @version 1.0
 * @date 2021/6/10 14:29
 */
@Data
public class MessageBody {

    /** 消息内容 */
    private String content;
    /** 广播转发的目标地址（告知 STOMP 代理转发到哪个地方） */
    private String destination;

}
