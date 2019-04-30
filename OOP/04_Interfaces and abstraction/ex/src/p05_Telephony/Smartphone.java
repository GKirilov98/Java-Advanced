package p05_Telephony;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : this.urls) {
            if (!url.matches("[A-Za-z:\\/\\.]+")) {
                sb.append("Invalid URL!");
            } else {
                sb.append("Browsing: ").append(url).append("!").append(System.lineSeparator());
            }
        }

        return sb.toString();
    }

    @Override
    public String call() throws IllegalArgumentException {
        StringBuilder sb = new StringBuilder();
        String regex = "[0-9]+";
        Pattern pattern = Pattern.compile(regex);
        for (String number : this.numbers) {
            Matcher matcher = pattern.matcher(number);
            if (!matcher.matches()) {
                sb.append("Invalid number!");
            } else {
                sb.append("Calling... ").append(number).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}