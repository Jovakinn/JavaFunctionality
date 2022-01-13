package ua.univer.EmailVerification.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilityImpl implements Utility {
    private static final Logger logger = Logger.getLogger(UtilityImpl.class.getName());

    @Override
    public void checkEmailVerification(String emailToCheck) throws IOException {
        FileInputStream fileInputStream =
                new FileInputStream("src/ua/univer/EmailVerification/config/regex.properties");
        Properties property = new Properties();
        property.load(fileInputStream);

        Pattern pattern = Pattern.compile(property.getProperty("regex"));
        Matcher matcher = pattern.matcher(emailToCheck);
        if (matcher.matches()) {
            successfullyValidation();
        } else {
            badValidation();
        }
    }

    private void successfullyValidation() {
        logger.info("Your email was successfully validated!");
    }

    private void badValidation() {
        logger.severe("EMAIL has failed validation!!! Check it once again!!!");
    }
}
