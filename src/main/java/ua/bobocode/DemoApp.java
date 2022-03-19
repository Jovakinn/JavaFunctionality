package ua.bobocode;

import java.util.function.Predicate;

public class DemoApp {
    public static void main(String[] args) {
        Predicate<BaseEntity> validationPredicate = e -> e.getId() != null;
        UtilClass.isValid(new User(), validationPredicate);
    }
}
