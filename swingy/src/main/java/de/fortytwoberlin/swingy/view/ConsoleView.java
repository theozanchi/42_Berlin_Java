package de.fortytwoberlin.swingy.view;

import java.io.IOException;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.impl.completer.*;

public class ConsoleView implements GameView {
    private Terminal    terminal;
    private int         terminalWidth;
    private int         terminalHeight;
    private LineReader  reader;

    public ConsoleView() throws IOException {
        terminal = TerminalBuilder.terminal();
        getTerminalSize();
    }

    public void displayWelcomeScreen() {
        String[] asciiArt = {
            "  _____ _      _    _   _____ _      _    _ ",
            " |  ___(_) ___| | _(_) |  ___(_) ___| | _(_)",
            " | |_  | |/ __| |/ / | | |_  | |/ __| |/ / |",
            " |  _| | | (__|   <| | |  _| | | (__|   <| |",
            " |_|   |_|\\___|_|\\_\\_| |_|   |_|\\___|_|\\_\\_|",
            "                                            "
        };
        String subtitle = "a 42 Berlin game project by Théo Zanchi";
        String prompt = "Type 'start' or 'exit' to continue";  
        
        int totalHeight = asciiArt.length + 2;
        int paddingVertical = (terminalHeight - totalHeight) / 2;
        Colour[] colors = Colour.values();
    
        for (int i = 0; i < 10; i++) {
            clearScreen();
            displayEmptyLines(paddingVertical);
    
            for (String line : asciiArt) {
                displayCenteredLine(colors[i % colors.length].getCode() + line + Colour.RESET.getCode());
            }
    
            displayEmptyLines(1);
            displayCenteredLine(subtitle);
            displayEmptyLines(1);
    
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    
        clearScreen();
        displayEmptyLines(paddingVertical);
        displayCenteredLine(Colour.MAGENTA.getCode());
        displayCenteredLine(asciiArt);
        displayCenteredLine(Colour.RESET.getCode());
        displayEmptyLines(1);
        displayCenteredLine(subtitle);
        displayEmptyLines(1);
    
        initReader("start", "exit");
        displayCenteredLine(prompt);
        try {
            String input;
            do {
                input = reader.readLine("> ");
            } while (!"start".equalsIgnoreCase(input.trim()) && !"exit".equalsIgnoreCase(input.trim()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void displayHome() {
        clearScreen();
        displayCenteredText("Choose your character");
        initReader("New character", "Select old character");

        while (true) {
            String line = reader.readLine("> ");
            if (line == null || line.equalsIgnoreCase("exit")) {
                break;
            }
            reader.getHistory().add(line);
            System.out.println("You said: " + line);
        }
    }

    private void clearScreen() {
        terminal.puts(org.jline.utils.InfoCmp.Capability.clear_screen);
        terminal.flush();
    }

    private void initReader(String... args) {
        if (args.length > 0) {
            reader = LineReaderBuilder.builder()
                        .terminal(terminal)
                        .completer(new StringsCompleter(args))
                        .build();
        } else {
            reader = LineReaderBuilder.builder()
                        .terminal(terminal)
                        .build();
        }
    }

    private void getTerminalSize() {
        terminalWidth = terminal.getWidth();
        terminalHeight = terminal.getHeight();
    }

    private void displayCenteredLine( String text ) {
        int textLength = text.length();
        int padding = (terminalWidth - textLength) / 2;

        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < padding; ++i ) {
            sb.append(" ");
        }
        sb.append(text);
        System.out.println(sb.toString());
    }

    private void displayCenteredLine( String[] array ) {
        for (String line : array) {
            displayCenteredLine(line);
        }
    }

    private void displayCenteredText( String text ) {
        int paddingVertical = terminalHeight / 2;

        displayEmptyLines(paddingVertical);
        displayCenteredLine(text);
        displayEmptyLines(paddingVertical);
    }

    private void displayEmptyLines( int n ) {
        for (int i = 0; i < n; ++i) {
            System.out.println();
        }
    }
}
