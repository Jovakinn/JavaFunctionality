package ua.bobocode;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Marker
public class Container<T> {
    private T value;

    public Container(T value) {
        this.value = value;
    }

    public Container() {
    }
}
