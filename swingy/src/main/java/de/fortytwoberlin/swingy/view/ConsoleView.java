package de.fortytwoberlin.swingy.view;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;

public class ConsoleView implements GameView {
    private Terminal    terminal;
    private LineReader  reader;

    public ConsoleView() throws IOException {
        terminal = TerminalBuilder.terminal();
        reader = LineReaderBuilder.builder()
                    .terminal(terminal)
                    .build();
    }

    public void displayHome( ) {
        clearScreen();
        displayCenteredText("Choose your character");
    }

    private void clearScreen( ) {
        terminal.puts(org.jline.utils.InfoCmp.Capability.clear_screen);
        terminal.flush();
    }

    private void displayCenteredText( String text ) {
        int width = terminal.getWidth();
        int textLength = text.length();
        int padding = (width - textLength) / 2;
        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < padding; ++i ) {
            sb.append(" ");
        }
        sb.append(text);
        System.out.println(sb.toString());
    }
}
