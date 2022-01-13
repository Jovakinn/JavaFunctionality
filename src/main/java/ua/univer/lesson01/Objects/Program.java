package ua.univer.lesson01.Objects;

import ua.univer.lesson01.Objects.Lists.ListShip;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        Map<Integer, String> mapping = new LinkedHashMap<>();
        mapping.put(1, "a");
        mapping.put(2, "b");
        mapping.put(17, "c");
        mapping.put(36, "d");
        mapping.put(3, "e");

        System.out.println(mapping);

        Map<Ship, Integer> map = new HashMap<>();
        map.put(new Ship("A", 1, 2), 100);
        map.put(new Ship("B", 2, 3), 200);
        map.put(new Ship("C", 4, 5), 300);

        System.out.println(map);
        System.out.println(map.get(new Ship("A", 1, 2)));

        ListShip listShip = new ListShip();
        listShip.add(new Ship("A1", 1, 2));
        listShip.add(new Ship("A2", 1, 2));
        listShip.add(new Ship("A3", 1, 2));
        listShip.add(new Ship("A4", 1, 2));

        for (Ship ship: listShip) {
            System.out.println(ship);
        }

        Iterator<Ship> iter = listShip.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
