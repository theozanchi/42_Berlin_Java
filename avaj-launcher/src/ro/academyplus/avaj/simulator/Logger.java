import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger           instance;
    private static BufferedWriter   writer;

    private Logger() {
        try {
            writer = new BufferedWriter(new FileWriter("simulation.txt", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Logger getInstance() {
        if ( instance == null ) {
            instance = new Logger();
        }
        return (instance);
    }

    public static void log( String msg ) {
        try {
            writer.write(msg);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if ( writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
