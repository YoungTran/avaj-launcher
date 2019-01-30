package logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//Singleton Logger Class

public class Logger {

    private static Logger logger;
    private static String s = "";
    private static final String FILENAME = "simulation.txt";

    private Logger() {}

    public static synchronized Logger getLogger() {
        if (logger == null)
            logger = new Logger();
        return logger;
    }
    public void addLog(String log) {
        s += log + '\n';
    }
    public void writeToFile() {
        File file = new File(FILENAME);
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(s);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
