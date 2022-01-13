package ua.univer.lesson01.Objects.Lists;

import ua.univer.lesson01.Objects.Ship;

import java.util.Iterator;

public class ListShip implements Iterable<Ship>{
    Node head;

    @Override
    public Iterator<Ship> iterator() {
        return new Iterator<Ship>() {
            Node current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Ship next() {
                Ship ship = current.data;
                current = current.next;
                return ship;
            }
        };
    }

    class Node {
        Ship data;
        Node next;

        public Node(Ship data) {
            this.data = data;
            this.next = null;
        }
    }
    public void add(Ship ship){
        Node node = new Node(ship);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }
}
