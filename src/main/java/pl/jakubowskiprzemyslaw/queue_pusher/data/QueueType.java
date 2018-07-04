package pl.jakubowskiprzemyslaw.queue_pusher.data;

import pl.jakubowskiprzemyslaw.queue_pusher.models.QueueObject;
import pl.jakubowskiprzemyslaw.queue_pusher.models.playeraction.Player;
import pl.jakubowskiprzemyslaw.queue_pusher.models.playeraction.PlayerAction;
import pl.jakubowskiprzemyslaw.queue_pusher.models.playeraction.action.Shot;

import java.util.Arrays;

public enum QueueType {
    GameConfigurationRegistrationQueueTest {
        @Override
        public QueueObject createObjectToSend() {
            return new PlayerAction(new Player(), new Shot());
        }
    },
    PlayerRegistrationQueueTest {
        @Override
        public QueueObject createObjectToSend() {
            return new PlayerAction(new Player(), new Shot());
        }
    };

    public static Object asList() {
        return Arrays.asList(QueueType.values());
    }

    public abstract QueueObject createObjectToSend();
}
