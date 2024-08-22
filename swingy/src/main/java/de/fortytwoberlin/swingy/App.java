package de.fortytwoberlin.swingy;

import de.fortytwoberlin.swingy.model.game.Game;
import de.fortytwoberlin.swingy.view.GameView;
import de.fortytwoberlin.swingy.view.ConsoleView;
import de.fortytwoberlin.swingy.view.GUIView;

import java.io.IOException;

import de.fortytwoberlin.swingy.controller.GameController;

public class App {
    public static void main( String[] args ) {
        GameView        view;
        Game            game;
        GameController  controller;

        System.out.println("Classpath: " + System.getProperty("java.class.path"));

        try {
            if ( args.length != 1 ) {
                System.out.println("You need to select a mode, `console` or `gui");
                return;
            } else if ( args[0].equals("console") ) {
                view = new ConsoleView();
            } else if ( args[0].equals("gui") ) {
                view = new GUIView();
            } else {
                System.out.println("Unsupported `" + args[0] + "` game mode");
                return;
            }

            game = new Game();
            controller = new GameController(game, view);
            
            controller.startGame();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
