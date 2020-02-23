package fun.codefarmer.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * fanout 接收器
 * @ @ClassName FanoutReceiver
 * @ Descriotion TODO
 * @ Author admin
 * @ Date 2020/2/22 17:27
 **/
@Component
public class FanoutReceiver {

    @RabbitListener(queues = "queue-one")
    public void handler1(String msg) {
        System.out.println("FanoutReceiver:handler1>>>>"+msg);
    }
    @RabbitListener(queues = "queue-two")
    public void handler2(String msg) {
        System.out.println("FanoutReceiver:handler2>>>>"+msg);
    }

}
