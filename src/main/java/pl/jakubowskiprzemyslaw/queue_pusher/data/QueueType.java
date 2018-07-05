package pl.jakubowskiprzemyslaw.queue_pusher.data;

import pl.jakubowskiprzemyslaw.queue_pusher.models.QueueObject;
import pl.jakubowskiprzemyslaw.queue_pusher.models.playeraction.Player;
import pl.jakubowskiprzemyslaw.queue_pusher.models.playeraction.PlayerAction;
import pl.jakubowskiprzemyslaw.queue_pusher.models.playeraction.action.Shot;

import java.util.Arrays;

public enum QueueType {
//    PlayerRegistrationQueueTest { //1
//
//        @Override
//        public QueueObject createObjectToSend() {
//            return null;
//        }
//    },
//    GameConfigurationRegistrationQueueTest { //2
//
//        @Override
//        public QueueObject createObjectToSend() {
//            return null;
//        }
//    },
    //    FleetPlacementSizeQueueTest { //3
//
//    },
//    FleetPlacementQueueTest { //4
//
//    },
//    GameReadyValidationQueueTest { //5
//
//    },
//    BoardHandlerPlayerQueueTest { //6
//
//    },
//    BoardHandlerFleetPlacementQueueTest { //7
//
//    },
//    JudgeStartQueueTest { //8
//
//    },
    PlayingStateMachinePlayerActionQueueTest { //9

        @Override
        public QueueObject createObjectToSend() {
            return new PlayerAction(new Player(), new Shot());
        }
    },
    ShotHandlerPlayerShotQueueTest { //10

        @Override
        public QueueObject createObjectToSend() {
            return new PlayerAction(new Player(), new Shot());
        }
    },
    MoveHandlerPlayerMoveQueueTest { //11

        @Override
        public QueueObject createObjectToSend() {
            return new PlayerAction(new Player(), new Shot());
        }
    },
    //    BoardHandlerShotQueryQueueTest { //12
//
//    },
//    BoardHandlerMoveQueryQueueTest { //13
//
//    },
    PlayingStateMachineNextPlayerOrGameEndQueueTest { //14

        @Override
        public QueueObject createObjectToSend() {
            return null;
        }
    },
    JudgePlayerShootResultQueueTest { //15

        @Override
        public QueueObject createObjectToSend() {
            return null;
        }
    },
//    JudgePlayerMoveResultQueue { //16
//
//    },
    ShotHandlerCoordinateStatusQueueTest { //17
        @Override
        public QueueObject createObjectToSend() {
            return null;
        }
    },
    PlayerStateMachineBoardStatusQueueTest { //18
        @Override
        public QueueObject createObjectToSend() {
            return null;
        }
    };

    public static Object asList() {
        return Arrays.asList(QueueType.values());
    }

    public abstract QueueObject createObjectToSend();
}
