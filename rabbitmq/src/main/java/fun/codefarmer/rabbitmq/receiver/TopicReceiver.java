package fun.codefarmer.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ @ClassName TopicReceiver
 * @ Descriotion TODO
 * @ Author admin
 * @ Date 2020/2/22 18:12
 **/
@Component
public class TopicReceiver {

    @RabbitListener(queues = "xiaomi")
    public void handler1(String msg) {
        System.out.println("TopicReceiver:handler1>>>xiaomi"+msg);
    }

    @RabbitListener(queues = "huawei")
    public void handler2(String msg) {
        System.out.println("TopicReceiver:handler2>>>huawei"+msg);
    }

    @RabbitListener(queues = "phone")
    public void handler3(String msg) {
        System.out.println("TopicReceiver:handler3>>>phone"+msg);
    }
}
