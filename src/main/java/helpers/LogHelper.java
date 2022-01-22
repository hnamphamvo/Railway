package helpers;

import org.apache.log4j.Logger;

public class LogHelper {
    public static Logger logger = Logger.getLogger(LogHelper.class);

    public static void info(String description) {
        logger.info(description);
    }
}
