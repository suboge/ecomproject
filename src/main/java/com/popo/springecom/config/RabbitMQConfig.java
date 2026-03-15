package com.popo.springecom.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // 定義一個常數，這是輸送帶的標籤名稱
    public static final String ORDER_QUEUE_NAME = "order.created.queue";

    @Bean
    public Queue orderQueue() {
        // 建立一個 Queue，第二個參數 true 代表「持久化 (Durable)」。
        // 也就是說即使 RabbitMQ 重新開機，這條輸送帶跟裡面的包裹也不會消失！
        return new Queue(ORDER_QUEUE_NAME, true);
    }
}