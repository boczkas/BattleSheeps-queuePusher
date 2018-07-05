package pl.jakubowskiprzemyslaw.queue_pusher;

import pl.jakubowskiprzemyslaw.queue_pusher.data.QueueType;

public class QueueResolver {
    private String queueName;

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }
}
