package pl.jakubowskiprzemyslaw.queue_pusher.data;

import pl.jakubowskiprzemyslaw.tajgertim.models.QueueObject;
import pl.jakubowskiprzemyslaw.tajgertim.models.coordinates.CoordinateStatus;
import pl.jakubowskiprzemyslaw.tajgertim.models.player.Player;
import pl.jakubowskiprzemyslaw.tajgertim.models.playeraction.PlayerAction;
import pl.jakubowskiprzemyslaw.tajgertim.models.playeraction.action.Move;
import pl.jakubowskiprzemyslaw.tajgertim.models.playeraction.action.Shot;
import pl.jakubowskiprzemyslaw.tajgertim.models.round.NextRoundStatus;
import pl.jakubowskiprzemyslaw.tajgertim.models.shoot.PlayerShootCoordinate;
import pl.jakubowskiprzemyslaw.tajgertim.models.shoot.PlayerShootResult;

import java.util.Arrays;

public enum QueueType {
    PlayerRegistrationQueueTest { //1

        @Override
        public QueueObject createObjectToSend() {
            return null;
        }

        @Override
        public String getQueueNumber() {
            return "1";
        }
    },
    GameConfigurationRegistrationQueueTest { //2

        @Override
        public QueueObject createObjectToSend() {
            return null;
        }

        @Override
        public String getQueueNumber() {
            return "2";
        }
    },
    FleetPlacementSizeQueueTest { //3

        @Override
        public QueueObject createObjectToSend() {
            return null;
        }

        @Override
        public String getQueueNumber() {
            return "3";
        }
    },
    FleetPlacementQueueTest { //4

        @Override
        public QueueObject createObjectToSend() {
            return null;
        }

        @Override
        public String getQueueNumber() {
            return "4";
        }
    },
    GameReadyValidationQueueTest { //5

        @Override
        public QueueObject createObjectToSend() {
            return null;
        }

        @Override
        public String getQueueNumber() {
            return "5";
        }
    },
    BoardHandlerPlayerQueueTest { //6

        @Override
        public QueueObject createObjectToSend() {
            return null;
        }

        @Override
        public String getQueueNumber() {
            return "6";
        }
    },
    BoardHandlerFleetPlacementQueueTest { //7

        @Override
        public QueueObject createObjectToSend() {
            return null;
        }

        @Override
        public String getQueueNumber() {
            return "7";
        }
    },
    JudgeStartQueueTest { //8

        @Override
        public QueueObject createObjectToSend() {
            return null;
        }

        @Override
        public String getQueueNumber() {
            return "8";
        }
    },

    PlayingStateMachinePlayerActionQueueTest { //9

        @Override
        public QueueObject createObjectToSend() {
            return new PlayerAction(new Player(), new Shot());
        }

        @Override
        public String getQueueNumber() {
            return "9";
        }
    },
    ShotHandlerPlayerShotQueueTest { //10

        @Override
        public QueueObject createObjectToSend() {
            return new PlayerAction(new Player(), new Shot());
        }

        @Override
        public String getQueueNumber() {
            return "10";
        }
    },
    MoveHandlerPlayerMoveQueueTest { //11

        @Override
        public QueueObject createObjectToSend() {
            return new PlayerAction(new Player(), new Move());
        }

        @Override
        public String getQueueNumber() {
            return "11";
        }
    },
    BoardHandlerShotQueryQueueTest { //12

        @Override
        public QueueObject createObjectToSend() {
            return new PlayerShootCoordinate();
        }

        @Override
        public String getQueueNumber() {
            return "12";
        }
    },
    BoardHandlerMoveQueryQueueTest { //13

        @Override
        public QueueObject createObjectToSend() {
            return null;
        }

        @Override
        public String getQueueNumber() {
            return "13";
        }
    },
    PlayingStateMachineNextRoundStatusQueueTest { //14

        @Override
        public QueueObject createObjectToSend() {
            return new NextRoundStatus();
        }

        @Override
        public String getQueueNumber() {
            return "14";
        }
    },
    JudgePlayerShootResultQueueTest { //15

        @Override
        public QueueObject createObjectToSend() {
            return new PlayerShootResult();
        }

        @Override
        public String getQueueNumber() {
            return "15";
        }
    },
    JudgePlayerMoveResultQueue { //16

        @Override
        public QueueObject createObjectToSend() {
            return null;
        }

        @Override
        public String getQueueNumber() {
            return "16";
        }

    },
    ShotHandlerCoordinateStatusQueueTest { //17

        @Override
        public QueueObject createObjectToSend() {
            return new CoordinateStatus();
        }

        @Override
        public String getQueueNumber() {
            return "17";
        }
    },
    PlayerStateMachineBoardStatusQueueTest { //18

        @Override
        public QueueObject createObjectToSend() {
            return null;
        }

        @Override
        public String getQueueNumber() {
            return "18";
        }
    };

    public static Object asList() {
        return Arrays.asList(QueueType.values());
    }

    public abstract QueueObject createObjectToSend();

    public abstract String getQueueNumber();

    public boolean isNotConfigured() {
        return this.createObjectToSend() == null;
    }

}
