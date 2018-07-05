package pl.jakubowskiprzemyslaw.queue_pusher.models.playeraction;

import pl.jakubowskiprzemyslaw.queue_pusher.models.QueueObject;
import pl.jakubowskiprzemyslaw.queue_pusher.models.playeraction.action.Action;

public class PlayerAction implements QueueObject {
    private Player player;
    private Action action;

    public PlayerAction(Player player, Action action) {
        this.player = player;
        this.action = action;
    }

    @Override
    public String toString() {
        return "PlayerAction{" +
                "player=" + player +
                ", action=" + action +
                '}';
    }
}
