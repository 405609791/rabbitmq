package fun.codefarmer.rabbitmq;

import fun.codefarmer.rabbitmq.config.RabbitFanoutConfig;
import fun.codefarmer.rabbitmq.config.RabbitHeaderConfig;
import fun.codefarmer.rabbitmq.config.RabbitTopicConfig;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqApplicationTests {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {
        //                                                                  发送的消息
        rabbitTemplate.convertAndSend("hello.codefarmer","hello--codefarmer!haha");

    }


    @Test
    public void test1() {
        rabbitTemplate.convertAndSend(RabbitFanoutConfig.FANOUTNAME,null,"hello fanout !!!!");
    }

    /**
     * 最初测试时，写错了绑定方法，缓存错误。后来修改正确也会数据多余
     */
    @Test
    public void test2() {
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,"xiaomi.news","小米新闻");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,"vivo.phone","vivo 手机");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,"huawei.phone","华为手机");
    }

    @Test
    public void test3() {
                                                                                                   //下面的codefarmer改变了将收不到值，和前面configz中的匹配规则有关
        Message nameMsg = MessageBuilder.withBody("hello codefarmer!".getBytes()).setHeader("name","codefarmer").build();
                                                                                         //下面的999无所谓
        Message ageMsg = MessageBuilder.withBody("hello 999!".getBytes()).setHeader("age","999").build();

        rabbitTemplate.send(RabbitHeaderConfig.HEADERNAME,null,nameMsg);

        rabbitTemplate.send(RabbitHeaderConfig.HEADERNAME,null,ageMsg);
    }

}
