package pl.jakubowskiprzemyslaw.queue_pusher;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.jakubowskiprzemyslaw.queue_pusher.data.QueueType;
import pl.jakubowskiprzemyslaw.queue_pusher.models.QueueObject;

@Component
public class ObjectSender {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ObjectSender(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendObject(String queueName) {
        QueueType queueType = QueueType.valueOf(queueName);
        QueueObject object = queueType.createObjectToSend();
        sendObject(object, queueName);
    }

    public void sendObject(QueueObject object, String queueName) {
        rabbitTemplate.convertAndSend(queueName, object);
        System.out.println("Object sent");
    }
}
