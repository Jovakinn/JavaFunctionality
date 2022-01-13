package ua.univer.EmailVerification.service;

import java.io.IOException;

public interface Utility {
    void checkEmailVerification(String emailToCheck) throws IOException;
}
