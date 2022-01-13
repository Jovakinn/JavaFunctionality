package ua.univer.moreOrLess;

public class View {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public String concatenationString(String... message) {
        StringBuilder concatString = new StringBuilder();
        for (String ignored : message) {
            concatString = concatString.append(message);
        }
        return new String(concatString);
    }
}
