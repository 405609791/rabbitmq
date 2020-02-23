package fun.codefarmer.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消费者（接受者）
 * @ @ClassName DirectReceiver
 * @ Descriotion TODO
 * @ Author admin
 * @ Date 2020/2/22 16:52
 **/
@Component
public class DirectReceiver {

    //消息接收方法，收到的消息打印出来
    @RabbitListener(queues = "hello.codefarmer")
    public void handler1(String msg) {
        System.out.println("handler1>>>"+msg);
    }
}
