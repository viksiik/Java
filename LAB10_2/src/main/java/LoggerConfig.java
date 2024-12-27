import java.io.File;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class LoggerConfig {
    private static final Logger logger = Logger.getLogger(LoggerConfig.class.getName());

    static {
        try {
            String logFileName = "app.log";
            File logFile = new File(logFileName);

            if (logFile.exists()) {
                if (!logFile.delete()) {
                    throw new RuntimeException("Failed to clear existing log file: " + logFileName);
                }
            }

            PatternLayout layout = new PatternLayout("%d{yyyy-MM-dd HH:mm:ss} %-5p [%l] %c{1}:%L - %m%n");

            FileAppender fileAppender = new FileAppender(layout, logFileName, false);
            fileAppender.setThreshold(Level.DEBUG);

            ConsoleAppender consoleAppender = new ConsoleAppender(layout);
            consoleAppender.setThreshold(Level.INFO);

            logger.addAppender(fileAppender);
            logger.addAppender(consoleAppender);

            logger.setLevel(Level.ALL);
        } catch (Exception e) {
            System.err.println("Failed to initialize logger: " + e.getMessage());
        }
    }

    public static Logger getLogger() {
        return logger;
    }
}
