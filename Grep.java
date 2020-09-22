import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Grep {
    public static void main(String[] args) throws IOException {
        // some arguments validation
        if (args.length < 1 || args.length > 2) {
            showUsage();
            return;
        }

        var option = "";
        var strPattern = "";

        // some more arguments validation and extraction of the actual arguments
        if (args.length == 1) {
            if (args[0].startsWith("-")) {
                showUsage();
                return;
            } else {
                strPattern = args[0];
            }
        }

        if (args.length == 2) {
            if (args[0].startsWith("-")) {
                option = args[0];
                strPattern = args[1];
            } else {
                showUsage();
                return;
            }
        }

        // is it a case-insensitive search
        var isCaseSensitive = true;
        if (option.equals("-i")) {
            isCaseSensitive = false;
        }

        var reader = new BufferedReader(new InputStreamReader(System.in));
        Stream<String> lines = Stream.empty();
        if (reader.ready()) {
            lines = reader.lines();
        }
        var regex = (isCaseSensitive ? "" : "(?i)") + ".*" + strPattern + ".*";

        // new Java 11 feature
        // see https://cr.openjdk.java.net/~iris/se/11/latestSpec/apidiffs/java/util/regex/Pattern.html
        var asMatchPredicate = Pattern.compile(regex).asMatchPredicate();
        lines.filter(asMatchPredicate).forEach(System.out::println);
    }

    private static void showUsage() {
        System.out.println("Usage: ./grep [-i] PATTERN");
    }
}