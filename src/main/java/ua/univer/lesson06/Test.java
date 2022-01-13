package ua.univer.lesson06;

import ua.univer.lesson06.model.Human;
import java.util.*;

import static java.util.Arrays.asList;
public class Test {


    public static void main(String[] args) {
        List<Human> humans = asList(
                new Human("Jack", List.of("Jackie, Alex")),
                new Human("Tom", List.of("Jerry, Chuck")),
                new Human("Geralt", List.of("Yen, Triss"))
        );

        List<String> petNames = humans.stream()
                .map(Human::getPets)
                .flatMap(Collection::stream).toList();

        System.out.println(petNames);
    }
}
