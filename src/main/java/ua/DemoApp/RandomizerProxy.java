package ua.DemoApp;

import lombok.extern.java.Log;

import java.util.List;

@Log
public class RandomizerProxy extends Randomizer {
    @Override
    public <T> T randomize(List<T> list) {
        log.info("Calling from proxy!");
        return super.randomize(list);
    }
}
