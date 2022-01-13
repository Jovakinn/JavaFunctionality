package ua.univer.lesson01.Objects;

import java.util.Objects;

public class Ship {
    private String name;
    private Integer x;
    private Integer y;

    @Override
    public String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public Ship() {
    }

    public Ship(String name, Integer x, Integer y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ship)) return false;
        Ship ship = (Ship) o;
        return Objects.equals(getName(), ship.getName()) && Objects.equals(getX(), ship.getX()) && Objects.equals(getY(), ship.getY());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getX(), getY());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}
