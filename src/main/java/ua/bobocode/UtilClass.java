package ua.bobocode;

import java.util.List;
import java.util.function.Predicate;

public class UtilClass {

    public static void printAll(List<? extends BaseEntity> list) {
        list.forEach(System.out::println);
    }

    public static boolean isValid(User user, Predicate<? super BaseEntity> baseEntityPredicate) {
        return baseEntityPredicate.test(user);
    }
}
