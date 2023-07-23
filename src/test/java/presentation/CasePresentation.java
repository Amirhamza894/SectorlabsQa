package presentation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CasePresentation {
    private static final Logger logger = LogManager.getLogger();

    public static void step(String message) {
        logger.info("     Step: " + message);
    }

}