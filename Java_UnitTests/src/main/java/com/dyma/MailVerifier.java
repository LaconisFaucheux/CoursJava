package com.dyma;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailVerifier {
    public static final String mailRegex ="[a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z]+";

    public static boolean isMail(String mail) {
        Pattern pattern = Pattern.compile(mailRegex);
        Matcher matcher = pattern.matcher(mail);
        return matcher.matches();
    }
}
