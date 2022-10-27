package task1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IP {
    Pattern pattern = Pattern.compile("\\d{3}(\\.([01]?[0-9][0-9]|[02][0-4][0-9]|[02][05][0-5]))\\.\\d{1,3}\\.\\d{1,3}");
    Matcher matcher = pattern.matcher("220.325.123.18 120.25.98.40");

    public void search() {
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
