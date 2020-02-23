package fun.codefarmer.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ @ClassName HeaderReceiver
 * @ Descriotion TODO
 * @ Author admin
 * @ Date 2020/2/23 13:28
 **/
@Component
public class HeaderReceiver {
    /**
     * 需要用数组接收参数
     */
    @RabbitListener(queues = "name-queue")
    public void headler1(byte[] msg) {
        //数组需要new成String   从0开始
        System.out.println("HeaderReceiver>>headler1>>"+new String(msg,0,msg.length));
    }

    @RabbitListener(queues = "age-queue")
    public void headler2(byte[] msg) {
        //数组需要new成String   从0开始
        System.out.println("HeaderReceiver>>headler2>>"+new String(msg,0,msg.length));
    }
}
