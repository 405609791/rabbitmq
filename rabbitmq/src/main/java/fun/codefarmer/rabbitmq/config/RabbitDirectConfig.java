package fun.codefarmer.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * rabbitmq 有4种模式：direct、
 * @ @ClassName RabbitDirectConfig
 * @ Descriotion TODO
 * @ Author admin
 * @ Date 2020/2/22 16:29
 **/
@Configuration
public class RabbitDirectConfig {
    public final static String DIRBCTNAMB = "codefarmer-direct";

    //配置消息队列
    @Bean
    Queue queue() {
        return new Queue("hello.codefarmer");
    }

    @Bean
    DirectExchange directExchange() {
        /**
         * 参一：
         * 参二：重启后是否有效
         * 参三：长时间停用是否删除
         * 消息会转发到 routing key 相同的队列
         */
        return new DirectExchange(DIRBCTNAMB,true,false);
    }

    /**
     * 将 queue directExchange 绑定到一起
     * @return
     */
    @Bean
    Binding binding() {
        return BindingBuilder.bind(queue()).to(directExchange()).with("drect");
    }
}
