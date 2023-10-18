package entities;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    int noOfFaces;

    public Dice(int noOfFaces) {
        this.noOfFaces = noOfFaces;
    }

    public int getNoOfFaces() {
        return noOfFaces;
    }

    public void setNoOfFaces(int noOfFaces) {
        this.noOfFaces = noOfFaces;
    }

    public int rollDiceAndGetNumber() {
        return ThreadLocalRandom.current().nextInt(1, this.noOfFaces);
    }


}
