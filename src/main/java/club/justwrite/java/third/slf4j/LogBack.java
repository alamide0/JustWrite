package club.justwrite.java.third.slf4j;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogBack {
    public static void main(String[] args) {
//        Logger logger = LoggerFactory.getLogger(LogBack.class);
//        logger.debug("Hello world!");
//
//        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
//        StatusPrinter.print(lc);

        ch.qos.logback.classic.Logger logger1 = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("club.justwrite.java.third");
        logger1.setLevel(Level.INFO);
        Logger barlogger = LoggerFactory.getLogger("club.justwrite.java.third.slf4j.LogBack");
        logger1.warn("Low fuel level.");
        logger1.debug("Starting search for nearest gas station.");
    }
}
