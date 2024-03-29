package com.epam.rd.autotasks.validations;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorCodeValidation {
    public static boolean validateColorCode(String color) {
        if (color == null || color.isBlank() ) return false;
        Matcher matcher = Pattern.compile("^#([a-fA-F\\d]{3}|[a-fA-F\\d]{6})$").matcher(color);
        return matcher.matches();
    }
}





