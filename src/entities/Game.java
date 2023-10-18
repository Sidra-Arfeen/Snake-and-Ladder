package entities;

import java.util.LinkedList;
import java.util.Queue;

public class Game {

    Board board;
    Queue<Player> players;

    Dice dice;

    Player winner;

    public Game(int boardSize, int snakeCount, int ladderCount, int noOfDiceFaces) {
        this.board = new Board(boardSize, snakeCount, ladderCount);
        this.dice = new Dice(noOfDiceFaces);
        this.players = new LinkedList<>();
        addPlayers();
    }

    public void addPlayers() {
        this.players.add(new Player("P1", 0));
        this.players.add(new Player("P2", 0));
    }

    public void play() {

        while (this.winner == null) {

            // remove player
            Player player = players.poll();

            System.out.println("Chance of " + player.getId() + ", Current Position is " + player.currPosition);

            // roll dice
            int diceNumber = this.dice.rollDiceAndGetNumber();
            System.out.println(player.getId() + " got " + diceNumber);

            int currPosition = player.currPosition;
            int newPosition = currPosition + diceNumber;

            // if reached at end then declare winner
            if (newPosition >= this.board.cells.length * this.board.cells.length) {
                this.winner = player;
                System.out.println(player.getId() + " is winner!!");
                continue;
            }
             // check if snake or ladder is present
            Cell cell = this.board.getCell(newPosition);
            if (cell.jump != null) {
                if (cell.jump.start > cell.jump.end) {
                    System.out.println(player.getId() + " got snake from " + cell.jump.start + " to " + cell.jump.end);
                } else {
                    System.out.println(player.getId() + " got ladder from " + cell.jump.start + " to " + cell.jump.end);
                }
                newPosition = cell.jump.end;
                System.out.println("New postion of " + player.getId() + " is " + newPosition);
            }
            player.currPosition = newPosition;

            // put player back to the queue
            this.players.add(player);
        }
    }



}
