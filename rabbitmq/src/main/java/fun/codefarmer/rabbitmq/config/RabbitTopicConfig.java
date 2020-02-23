package fun.codefarmer.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ @ClassName RabbitTopicConfig
 * @ Descriotion TODO
 * @ Author admin
 * @ Date 2020/2/22 17:52
 **/
@Configuration
public class RabbitTopicConfig {
    public static final String TOPICNAME = "codefarmer-topic";


    @Bean
    Queue xiaomi() {
        return new Queue("xiaomi");
    }

    @Bean
    Queue huawei() {
        return new Queue("huawei");
    }

    @Bean
    Queue phone() {
        return new Queue("phone");
    }
    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(TOPICNAME, true, false);
    }

    @Bean
    Binding xiaomiBinding() {
        //消息的routingkey 以xiaomi开头的就到xiaomi()这个队列上来
        return BindingBuilder.bind(xiaomi()).to(topicExchange()).with("xiaomi.#");
    }
    @Bean
    Binding huaweiBinding() {
        return BindingBuilder.bind(huawei()).to(topicExchange()).with("huawei.#");
    }
    @Bean
    Binding phoneBinding() {
        //#.phone.# 凡是消息的routingkey 包含phone的都发送到phone()这个队列
        return BindingBuilder.bind(phone()).to(topicExchange()).with("#.phone.#");
    }
}
