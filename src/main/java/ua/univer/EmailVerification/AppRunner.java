package ua.univer.EmailVerification;

import ua.univer.EmailVerification.service.UtilityImpl;

import java.io.IOException;

public class AppRunner {
    public static void main(String[] args) throws IOException {
        UtilityImpl utility = new UtilityImpl();
        utility.checkEmailVerification("max05012004gma.ilco");
    }
}
