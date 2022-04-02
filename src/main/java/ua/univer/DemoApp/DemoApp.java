package ua.univer.DemoApp;

import lombok.extern.java.Log;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Log
public class DemoApp {

    public static void main(String[] args) {
        List<Optional<String>> strings = Arrays.asList(Optional.ofNullable("Java"),
                Optional.ofNullable("Cringe"));
        strings.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(s -> s.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(toList());
        for (Optional<String> s : strings)
            log.info(String.valueOf(Optional.ofNullable(s)));

        List<String> filteredList = strings.stream()
                .flatMap(Optional::stream)
                .collect(toList());
        for (String s : filteredList)
            log.info(s);
    }
}
