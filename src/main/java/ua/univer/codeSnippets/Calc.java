package ua.univer.codeSnippets;

import java.util.Objects;
import java.util.Optional;

public class Calc {
    public static Integer add(Integer firstSummund, Integer secondSummund) {
        Objects.requireNonNull(firstSummund );
        Objects.requireNonNull(secondSummund);

        return firstSummund + secondSummund;
    }

    public static Integer divide(Integer dividend, Integer divisor) {
        Objects.requireNonNull(dividend);
        Objects.requireNonNull(divisor);
        if( divisor == 0){
            throw new IllegalArgumentException();
        }

        return dividend / divisor;
    }

    public static Optional<Integer> divideSafely(Integer dividend, Integer divisor) {
        Objects.requireNonNull(dividend);
        Objects.requireNonNull(divisor);

        Optional<Integer> result = Optional.empty();

        if( divisor != 0){
            result = Optional.of( dividend / divisor);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(add(2, 3));
    }
}
