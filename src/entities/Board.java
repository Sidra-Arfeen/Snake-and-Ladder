package entities;

import java.util.concurrent.ThreadLocalRandom;

public class Board {

    Cell[][] cells;

    public Board(int boardSize, int snakesCount, int ladderCount) {
        initializeBoard(boardSize);
        addSnakes(snakesCount, cells);
        addLadders(ladderCount, cells);
    }

    public void initializeBoard(int boardSize) {
        this.cells = new Cell[boardSize][boardSize];

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public void addSnakes(int snakeCount, Cell[][] cells) {
        while (snakeCount > 0) {
            int start = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length);
            int end = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length);

            if (start < end) {
                continue;
            }

            Jump jump = new Jump(start, end);
            Cell cell = getCell(start);
            cell.jump = jump;

            snakeCount--;


        }
    }

    public void addLadders(int ladderCount, Cell[][] cells) {
        while (ladderCount > 0) {
            int start = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length);
            int end = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length);

            if (start > end) {
                continue;
            }

            Jump jump = new Jump(start, end);
            Cell cell = getCell(start);
            cell.jump = jump;

            ladderCount--;


        }
    }

    public Cell getCell(int number) {
        return this.cells[number/10][number%10];
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }
}
