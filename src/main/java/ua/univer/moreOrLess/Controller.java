package ua.univer.moreOrLess;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Controller {

    private Model model;
    private View view;
    private FileInputStream fs = new FileInputStream("src/ua/univer/moreOrLess/view.properties");
    private Properties property = new Properties();

    public Controller(Model model, View view) throws FileNotFoundException {
        this.model = model;
        this.view = view;
    }

    public void processUser() throws IOException {
        Scanner sc = new Scanner(System.in);
        property.load(fs);

        model.setPrimaryBarrier(GlobalConstants.PRIMARY_MIN_BARRIER,
                                GlobalConstants.PRIMARY_MAX_BARRIER);

        model.setSecretValue();
        System.out.println(model.getSecretValue());

        while (model.checkValue(inputIntValueWithScanner(sc)));

        view.printMessage(property.getProperty("CONGRATULATIONS") + model.getSecretValue());
        view.printMessage(property.getProperty("YOUR_WAY") + model.getYourWay());
    }

    private int inputIntValueWithScanner(Scanner sc) {
        int res = 0;
        view.printMessage(getInputIntMessage());
        while (true) {
            while (!sc.hasNextLine()) {
                view.printMessage(property.getProperty("WRONG_INPUT_INT_DATA") + getInputIntMessage());
                sc.next();
            }

            if ((res = sc.nextInt()) <= model.getMinBarrier() ||
                    res >= model.getMaxBarrier()) {
                view.printMessage(property.getProperty("WRONG_INPUT_INT_DATA") + getInputIntMessage());
                continue;
            }
            break;
        }
        return res;
    }

    private String getInputIntMessage() {
        return view.concatenationString(
                property.getProperty("INPUT_INT_DATA"), property.getProperty("OPENS_SQUARE_BRACKETS"),
                String.valueOf(model.getMinBarrier()), property.getProperty("SPACE_SING"),
                String.valueOf(model.getMaxBarrier()),
                property.getProperty("CLOSING_SQUARE_BRACKETS"), property.getProperty("SPACE_SING"),
                property.getProperty("EQUAL_SING"), property.getProperty("SPACE_SING")
        );
    }
}
