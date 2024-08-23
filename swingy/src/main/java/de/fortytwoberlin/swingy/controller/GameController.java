package de.fortytwoberlin.swingy.controller;

import de.fortytwoberlin.swingy.model.game.Game;
import de.fortytwoberlin.swingy.view.GameView;

public class GameController {
    private Game        game;
    private GameView    view;

    public GameController( Game p_game, GameView p_view ) {
        game = p_game;
        view = p_view;
    }

    public void startGame( ) {
        view.displayWelcomeScreen();
        // view.displayHome();
    }
}
