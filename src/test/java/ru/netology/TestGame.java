package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Period;

public class TestGame {
    Player player1 = new Player(1, "Petr", 6);
    Player player2 = new Player(2, "Masha", 8);
    Player player3 = new Player(3, "Katia", 8);

    @Test
    public void testWhenTheFirstPlayerWon() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);

        int actual = game.round("Masha", "Petr");
        int expected = 1;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testWhenTheSecondPlayerWon() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);

        int actual = game.round("Petr", "Masha");
        int expected = 2;

        Assertions.assertEquals(actual, expected);
    }
    @Test
    public void testWhenTwoPlayersAreEqual() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);

        int actual = game.round("Masha", "Katia");
        int expected = 0;

        Assertions.assertEquals(actual, expected);
    }
    @Test
    public void testWhenOnePlayerIsNotFound() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotFoundException.class,
                () -> {
                    game.round("Petr", "Roma");
                });
    }

    @Test
    public void testWhenTwoPlayerIsNotFound() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotFoundException.class,
                () -> {
                    game.round("Jana", "Roma");
                });
    }

}
