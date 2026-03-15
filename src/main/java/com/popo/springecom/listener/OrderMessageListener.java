package com.popo.springecom.listener;

import com.popo.springecom.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderMessageListener {

    @RabbitListener(queues = RabbitMQConfig.ORDER_QUEUE_NAME)
    public void receiveMessage(String message) {

        System.out.println("=========================================");
        System.out.println("已處理");
        System.out.println("訂單內容是 " + message);
        System.out.println("=========================================");

    }
}