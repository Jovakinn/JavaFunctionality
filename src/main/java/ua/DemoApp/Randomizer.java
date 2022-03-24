package ua.DemoApp;

import java.util.List;

@FunctionalInterface
public interface Randomizer {
    <T> T randomize(List<T> list);
}
