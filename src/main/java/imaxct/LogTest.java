package imaxct;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by imaxct on 17-4-6.
 */
public class LogTest {
    private static Logger logger = LogManager.getLogger(LogTest.class);

    public static void main(String[] args){
        logger.warn("warn");
        logger.debug("debug");
        logger.error("error");
    }
}
