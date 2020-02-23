package fun.codefarmer.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * header 这种模式使用比较少
 * @ @ClassName RabbitHeaderConfig
 * @ Descriotion TODO
 * @ Author admin
 * @ Date 2020/2/23 13:08
 **/
@Configuration
public class RabbitHeaderConfig {
    public static final String HEADERNAME = "codefarmer-header";

    @Bean
    HeadersExchange headersExchange() {
        return new HeadersExchange(HEADERNAME,true,true);
    }

    @Bean
    Queue queueName() {
        return new Queue("name-queue");
    }

    @Bean
    Queue queueAge() {
        return new Queue("age-queue");
    }

    @Bean
    Binding bindingName() {
        /**
         * whereAny() 表示消息的header中只要有一个匹配到map中的key-value对应（有值并且匹配上）
         * whereAll() 表示消息的header中只要有所有匹配到map中的key-value对应
         */
        Map<String, Object> map = new HashMap<>();
        map.put("name", "codefarmer");
                                                                                 //match()匹配
        return BindingBuilder.bind(queueName()).to(headersExchange()).whereAny(map).match();
    }

    @Bean
    Binding bindingAge() {
        /**
         * header中只要存在 age 这个字段就行
         */
        return BindingBuilder.bind(queueAge()).to(headersExchange()).where("age").exists();
    }
}
