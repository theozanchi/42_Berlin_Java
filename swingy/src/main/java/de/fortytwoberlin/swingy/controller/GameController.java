package de.fortytwoberlin.swingy.controller;

import de.fortytwoberlin.swingy.model.game.Game;
import de.fortytwoberlin.swingy.model.hero.Hero;
import de.fortytwoberlin.swingy.view.GameView;
import de.fortytwoberlin.swingy.utils.Constants;
import java.util.ArrayList;

public class GameController {
    private Game        game;
    private GameView    view;
    private Hero        heroModel;

    public GameController(Game p_game, GameView p_view) {
        game = p_game;
        view = p_view;
    }

    public void startGame() {
        view.displayWelcomeScreen();
        ArrayList<Hero> savedHeroes = Hero.loadHeroes(new File(Constants.HEROES_FILE_PATH))
        // view.displayHome();
    }
}
