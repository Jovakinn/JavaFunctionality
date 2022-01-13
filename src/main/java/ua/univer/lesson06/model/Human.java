package ua.univer.lesson06.model;

import java.io.Serializable;
import java.util.List;

public record Human(String name, List<String> pets) implements Serializable {
    private static final Long serialVersionUID = 1L;

    public String getName() {
        return name;
    }

    public List<String> getPets() {
        return pets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;

        Human human = (Human) o;

        if (getName() != null ? !getName().equals(human.getName()) : human.getName() != null) return false;
        return getPets() != null ? getPets().equals(human.getPets()) : human.getPets() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getPets() != null ? getPets().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", pets=" + pets +
                '}';
    }
}
