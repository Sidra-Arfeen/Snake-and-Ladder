package entities;

public class Player {
    String id;
    int currPosition;

    public Player(String id, int currPosition) {
        this.id = id;
        this.currPosition = currPosition;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCurrPosition() {
        return currPosition;
    }

    public void setCurrPosition(int currPosition) {
        this.currPosition = currPosition;
    }
}
