import Game.Player;
import Game.Game;
import Game.NotRegisteredException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Player Ivan= new Player(1, "Ivan", 11);
    Player Petr = new Player(2, "Petr", 6);
    Player Dmitry = new Player(3, "Dmitry", 5);
    Player Sergey = new Player(4, "Sergey", 7);
    Player Kirill = new Player(5, "Kirill", 19);
    Player Vitya = new Player(6, "Vitya", 6);

    @Test
    public void firstPlayerWin() {
        Game manager = new Game();
        manager.register(Ivan);
        manager.register(Vitya);
        int expected = 1;
        int actual = manager.round("Ivan", "Vitya");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void secondPlayerWin() {
        Game manager = new Game();
        manager.register(Dmitry);
        manager.register(Kirill);
        int expected = 2;
        int actual = manager.round("Dmitry", "Kirill");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void drawGame() {
        Game manager = new Game();
        manager.register(Ivan);
        manager.register(Kirill);
        int expected = 2;
        int actual = manager.round("Ivan", "Kirill");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void throwExceptionFirstPlayer() {
        Game manager = new Game();
        manager.register(Kirill);
        manager.register(Sergey);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            manager.round("Petr", "Vitya");
        });
    }

    @Test
    public void throwExceptionSecondPlayer() {
        Game manager = new Game();
        manager.register(Petr);
        manager.register(Sergey);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            manager.round("Petr", "Vitya");
        });


    }
}