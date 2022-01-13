package ua.univer.moreOrLess;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Controller controller = new Controller(new Model(), new View());
        controller.processUser();
    }
}
