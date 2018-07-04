package pl.jakubowskiprzemyslaw.queue_pusher;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.jakubowskiprzemyslaw.queue_pusher.models.QueueObject;
import pl.jakubowskiprzemyslaw.queue_pusher.models.playeraction.Player;
import pl.jakubowskiprzemyslaw.queue_pusher.models.playeraction.PlayerAction;
import pl.jakubowskiprzemyslaw.queue_pusher.models.playeraction.action.Shot;

@Component
public class ObjectSender {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ObjectSender(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        sendObject(new PlayerAction(new Player(), new Shot()), "PlayerRegistrationQueueTest");
    }

    public void sendObject(QueueObject object, String queueName) {
        rabbitTemplate.convertAndSend(queueName, object);
        System.out.println("Object sent");
    }
}
