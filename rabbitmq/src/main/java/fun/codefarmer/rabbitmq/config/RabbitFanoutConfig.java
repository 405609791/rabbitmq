package fun.codefarmer.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * fanout 模式
 * @ @ClassName RabbitFanoutConfig
 * @ Descriotion TODO
 * @ Author admin
 * @ Date 2020/2/22 17:11
 **/
@Configuration
public class RabbitFanoutConfig {
    public static final String FANOUTNAME = "codefarmer-fanout";

    /**
     * 注意：队列 name 必须与接收者的一致，否则会报错
     *
     */
    @Bean
    Queue queueOne() {
        return new Queue("queue-one");
    }

    @Bean
    Queue queueTwo() {
        return new Queue("queue-two");
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return  new FanoutExchange(FANOUTNAME,true,false);
    }

    @Bean
    Binding bindingOne() {
        return BindingBuilder.bind(queueOne()).to(fanoutExchange());
    }

    @Bean
    Binding bindingTwo() {
        return BindingBuilder.bind(queueTwo()).to(fanoutExchange());
    }

}
