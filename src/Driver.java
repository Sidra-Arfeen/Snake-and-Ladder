import entities.Game;

public class Driver {
    public static void main(String[] args) {
        Game game = new Game(10, 3, 5, 6);
        game.play();
    }
}
