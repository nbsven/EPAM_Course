package Task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checker {
    /**
     * Check links in article for correct links.
     *
     * @param reader that provides access to article.
     * @return true if links are correct and false if not.
     * @throws IOException
     */
    public static boolean isLinksCorrect(BufferedReader reader) throws IOException {
        String line;
        int max = 0;
        boolean isCorrect = true;
        while ((line = reader.readLine()) != null) {
            Pattern splitter = Pattern.compile("(. ^\\d|[;!?] *)");

            for (String s : splitter.split(line)) {
                Pattern pattern = Pattern.compile("(.*)(\\(\\u0420\\u0438\\u0441\\. \\d+\\))(.*)");
                Matcher matcher = pattern.matcher(s);
                if (matcher.matches()) {
                    System.out.println(s);
                    int t = Integer.parseInt(matcher.group(2).substring(6, matcher.group(2).length() - 1));
                    if (t >= max) {
                        max = t;
                    } else {
                        isCorrect = false;

                    }
                }
            }
        }

        System.out.println("Not correct links");
        return isCorrect;
    }
}
