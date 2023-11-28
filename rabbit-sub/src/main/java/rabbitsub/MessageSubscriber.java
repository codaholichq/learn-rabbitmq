package rabbitsub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = RabbitConstants.USER_QUEUE)
public class MessageSubscriber {

    private static final Logger log = LoggerFactory.getLogger(MessageSubscriber.class);
    private User receivedUser;

    public User getUser() {
        return receivedUser;
    }

    @RabbitHandler
    public void subscribe(User user) {
        log.info("Received message => {}", user.toString());
        this.receivedUser = user;
    }
}

