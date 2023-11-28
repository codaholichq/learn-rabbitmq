package rabbitpub;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitPublisherConfig {

    @Bean
    public Queue userQueue() {
        return new Queue(RabbitConstants.USER_QUEUE);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(RabbitConstants.EXCHANGE);
    }

    @Bean
    public Declarables bindings(
            final Queue userQueue,
            final TopicExchange topicExchange
    ) {
        return new Declarables(
                BindingBuilder.bind(userQueue).to(topicExchange).with(RabbitConstants.USER_ROUTING_KEY)
        );
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        var rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
