package pl.jakubowskiprzemyslaw.queue_pusher;

import pl.jakubowskiprzemyslaw.queue_pusher.models.QueueObject;
import pl.jakubowskiprzemyslaw.queue_pusher.models.playeraction.Player;
import pl.jakubowskiprzemyslaw.queue_pusher.models.playeraction.PlayerAction;
import pl.jakubowskiprzemyslaw.queue_pusher.models.playeraction.action.Shot;

public class QueueResolver {
    private String queueName;

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public QueueObject getDefaultObject() {
        return new PlayerAction(new Player(), new Shot());
    }
}
