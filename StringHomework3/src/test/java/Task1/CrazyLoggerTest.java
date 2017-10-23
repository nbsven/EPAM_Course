package Task1;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

import static org.junit.jupiter.api.Assertions.*;

class CrazyLoggerTest {
    @Test
    void log() {

    }

    @Test
    void showLogs() {
        CrazyLogger logger = new CrazyLogger();
        logger.log("msg1");
        logger.log("msg2");
        logger.log("msg3");

        logger.showLogs();
    }

    @Test
    void getLogsWithMessage() {
        CrazyLogger logger = new CrazyLogger();
        logger.log("msg1");
        logger.log("msg2");
        logger.log("msg3");
        showLogs();
        logger.getLogsWithMessage("msg3");
    }
}