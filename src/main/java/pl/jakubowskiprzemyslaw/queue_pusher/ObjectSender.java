package pl.jakubowskiprzemyslaw.queue_pusher;


import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.jakubowskiprzemyslaw.queue_pusher.data.QueueType;
import pl.jakubowskiprzemyslaw.tajgertim.models.QueueObject;

@Component
public class ObjectSender {

    private final RabbitTemplate rabbitTemplate;
    private final RabbitAdmin rabbitAdmin;

    @Autowired
    public ObjectSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitAdmin = new RabbitAdmin(rabbitTemplate);
    }

    public void sendObject(String queueName) {
        QueueType queueType = QueueType.valueOf(queueName);
        QueueObject object = queueType.createObjectToSend();
        sendObject(object, queueName);
    }

    public void sendObject(QueueObject object, String queueName) {
        rabbitAdmin.declareQueue(new Queue(queueName,false,false,false, null));
        rabbitTemplate.convertAndSend(queueName, object);
        System.out.println("Object sent");
    }
}
