package Task1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

public class CrazyLogger {
    StringBuilder stringBuilder = new StringBuilder();

    public CrazyLogger() {

    }

    public void log(String message) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy : hh-mm");
        Date date = new Date();
        stringBuilder.append(String.format("%s - %s%n", dateFormat.format(date.getTime()), message));
    }

    public void showLogs() {
        System.out.print(stringBuilder.toString());
    }

    /**
     * Print in {@code System.out} logs, that contains {@code String} message
     * @param msg message
     */
    public void getLogsWithMessage(String msg) {
        int lastIndex = 0;
        System.out.println("CrazyLogger.getLogsWithMessage");
        while (stringBuilder.indexOf(msg, lastIndex) != -1) {

            int start = stringBuilder.substring(0, stringBuilder.indexOf(msg, lastIndex)).lastIndexOf("\n");
            start = start == -1 ? 0 : start+1;

            int end = stringBuilder.substring(stringBuilder.indexOf(msg, lastIndex)).indexOf("\n");
            end+=stringBuilder.indexOf(msg, lastIndex);

            System.out.println(stringBuilder.substring(start,end));
            lastIndex = end + 1;
        }
    }
}
