package pl.jakubowskiprzemyslaw.queue_pusher.data;

import pl.jakubowskiprzemyslaw.tajgertim.models.QueueObject;
import pl.jakubowskiprzemyslaw.tajgertim.models.board.*;
import pl.jakubowskiprzemyslaw.tajgertim.models.configuration.GameConfiguration;
import pl.jakubowskiprzemyslaw.tajgertim.models.coordinates.Coordinate;
import pl.jakubowskiprzemyslaw.tajgertim.models.coordinates.FieldState;
import pl.jakubowskiprzemyslaw.tajgertim.models.coordinates.FieldStatus;
import pl.jakubowskiprzemyslaw.tajgertim.models.player.Player;
import pl.jakubowskiprzemyslaw.tajgertim.models.playeraction.PlayerAction;
import pl.jakubowskiprzemyslaw.tajgertim.models.playeraction.action.Shot;
import pl.jakubowskiprzemyslaw.tajgertim.models.round.NextRoundStatus;
import pl.jakubowskiprzemyslaw.tajgertim.models.shoot.PlayerShootCoordinate;
import pl.jakubowskiprzemyslaw.tajgertim.models.shoot.PlayerShootResult;
import pl.jakubowskiprzemyslaw.tajgertim.models.shoot.ShootResult;
import pl.jakubowskiprzemyslaw.tajgertim.models.view.BoardsView;
import pl.jakubowskiprzemyslaw.tajgertim.models.view.OpponentBoardView;
import pl.jakubowskiprzemyslaw.tajgertim.models.view.PlayerBoardView;

import java.util.*;

public enum QueueType {
    PlayerRegistrationQueue { //1

        @Override
        public QueueObject createObjectToSend() {
            return null;
        }

        @Override
        public String getQueueNumber() {
            return "1";
        }
    },
    GameConfigurationRegistrationQueue { //2

        @Override
        public QueueObject createObjectToSend() {
            return null;
        }

        @Override
        public String getQueueNumber() {
            return "2";
        }
    },
    FleetPlacementSizeQueue { //3

        @Override
        public QueueObject createObjectToSend() {
            return new GameConfiguration();
        }

        @Override
        public String getQueueNumber() {
            return "3";
        }
    },
    FleetPlacementQueue { //4

        @Override
        public QueueObject createObjectToSend() {
            List<Ship> shipList = new ArrayList<>();
            List<Mast> mastList = new ArrayList<>();

            mastList.add(new Mast(new Coordinate(2,1)));
            mastList.add(new Mast(new Coordinate(2,2)));
            mastList.add(new Mast(new Coordinate(2,3)));
            shipList.add(new Ship(mastList));

            return new FleetPlacement(new Fleet(shipList));
        }

        @Override
        public String getQueueNumber() {
            return "4";
        }
    },
    GameReadyValidationQueue { //5

        @Override
        public QueueObject createObjectToSend() {
            return null;
        }

        @Override
        public String getQueueNumber() {
            return "5";
        }
    },
    BoardHandlerPlayerQueue { //6

        @Override
        public QueueObject createObjectToSend() {
            return null;
        }

        @Override
        public String getQueueNumber() {
            return "6";
        }
    },
    BoardHandlerFleetPlacementQueue { //7

        @Override
        public QueueObject createObjectToSend() {
            List<Ship> shipList = new ArrayList<>();
            List<Mast> mastList = new ArrayList<>();

            mastList.add(new Mast(new Coordinate(1,1)));
            mastList.add(new Mast(new Coordinate(1,2)));
            mastList.add(new Mast(new Coordinate(1,3)));
            shipList.add(new Ship(mastList));

            return new FleetPlacement(new Fleet(shipList));
        }

        @Override
        public String getQueueNumber() {
            return "7";
        }
    },
    JudgeStartQueue { //8

        @Override
        public QueueObject createObjectToSend() {
            return null;
        }

        @Override
        public String getQueueNumber() {
            return "8";
        }
    },

    PlayingStateMachinePlayerActionQueue { //9

        @Override
        public QueueObject createObjectToSend() {
            return new PlayerAction(new Player("", ""), new Shot(new Coordinate(0, 0)));
        }

        @Override
        public String getQueueNumber() {
            return "9";
        }
    },
    ShotHandlerPlayerShotQueue { //10

        @Override
        public QueueObject createObjectToSend() {
            return new PlayerAction(new Player("", ""), new Shot(new Coordinate(0, 0)));
        }

        @Override
        public String getQueueNumber() {
            return "10";
        }
    },
    MoveHandlerPlayerMoveQueue { //11

        @Override
        public QueueObject createObjectToSend() {
            return new PlayerAction(new Player("", ""), new Shot(new Coordinate(0, 0)));
        }

        @Override
        public String getQueueNumber() {
            return "11";
        }
    },
    BoardHandlerShotQueryQueue { //12

        @Override
        public QueueObject createObjectToSend() {
            return new PlayerShootCoordinate(new Player("Jozek", "1337"), new Coordinate(2, 2));
        }

        @Override
        public String getQueueNumber() {
            return "12";
        }
    },
    BoardHandlerMoveQueryQueue { //13

        @Override
        public QueueObject createObjectToSend() {
            return null;
        }

        @Override
        public String getQueueNumber() {
            return "13";
        }
    },
    PlayingStateMachineNextRoundStatusQueue { //14

        @Override
        public QueueObject createObjectToSend() {
            return new NextRoundStatus();
        }

        @Override
        public String getQueueNumber() {
            return "14";
        }
    },
    JudgePlayerShootResultQueue { //15

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
    ShotHandlerFieldStatusQueue { //17

        @Override
        public QueueObject createObjectToSend() {
            return new FieldStatus(new Coordinate(0, 0), FieldState.EMPTY, new Player("", ""));
        }

        @Override
        public String getQueueNumber() {
            return "17";
        }
    },
    PlayingBoardsViewQueue { //18

        @Override
        public QueueObject createObjectToSend() {
            List<Ship> shipList = new ArrayList<>();
            List<Mast> mastList = new ArrayList<>();

            mastList.add(new Mast(new Coordinate(1,1)));
            mastList.add(new Mast(new Coordinate(1,2)));
            mastList.add(new Mast(new Coordinate(1,3)));
            shipList.add(new Ship(mastList));

            Map<Coordinate, ShootResult> fieldStateView = new HashMap<>();
            fieldStateView.put(new Coordinate(5, 1), ShootResult.HIT);
            fieldStateView.put(new Coordinate(3, 2), ShootResult.MISS);

            return new BoardsView(new Player("Test", "TestIP"), new PlayerBoardView(new Board(new Fleet(shipList))),
                                    new OpponentBoardView(fieldStateView));
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
