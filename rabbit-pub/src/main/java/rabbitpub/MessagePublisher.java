package rabbitpub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessagePublisher {

    private static final Logger log = LoggerFactory.getLogger(MessagePublisher.class);
    private final RabbitTemplate rabbitTemplate;

    public MessagePublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publish(User user) {
        log.info("Message sent => {}", user.toString());
        rabbitTemplate.convertAndSend(RabbitConstants.EXCHANGE, RabbitConstants.USER_ROUTING_KEY, user);
    }
}
