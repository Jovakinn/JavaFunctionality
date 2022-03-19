package ua.univer.Strings;

import java.util.Arrays;
import java.util.stream.Collectors;

public class JadenCase {
    public String toJadenCase(String phrase) {
        if (phrase == null) {
            return null;
        }
        if (phrase.trim().isEmpty()) {
            return null;
        }
        String[] splits = phrase.split("\\s");
        StringBuilder capitilizedResult = new StringBuilder();
        for (var split : splits) {
            String first = split.substring(0,1);
            String afterfirst = split.substring(1);
            capitilizedResult.append(first.toUpperCase()).append(afterfirst).append(" ");
        }
        return capitilizedResult.toString().trim();
    }

    public String toJadenCaseAnotherVariant(String phrase) {
        if (phrase == null || phrase.length() == 0) {
            return null;
        }
        return Arrays.stream(phrase.split(" "))
                .map(i -> i.substring(0, 1).toUpperCase() + i.substring(1, i.length()))
                .collect(Collectors.joining(" "));
    }
}
