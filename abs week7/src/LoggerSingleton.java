import java.io.FileWriter;
import java.io.PrintWriter;

public class LoggerSingleton {
    private final String logFile = "test.txt";
    private PrintWriter writer;
    private static LoggerSingleton instance;

    private LoggerSingleton() {
        try {
            FileWriter fw = new FileWriter(logFile);
            writer = new PrintWriter(fw, true);
        } catch (Exception e) {
        }}

    public static class SingletonHelp {
        public static final LoggerSingleton INSTANCE = new LoggerSingleton();
    }
    public static LoggerSingleton getInstance() {
        return SingletonHelp.INSTANCE;
    }


    public void logError(String error, String priority) {
        writer.println("Error: " + error + ". Priority: " + priority + "!");
    }

    public void logConnection(String account, String time) {
        writer.println("Connection: " + account + " has connected at: " + time + ".");
    }

    public void logChange(String obj, String time) {
        writer.println("Change: "+ obj + " has been changed at " + time + "!");
    }
}