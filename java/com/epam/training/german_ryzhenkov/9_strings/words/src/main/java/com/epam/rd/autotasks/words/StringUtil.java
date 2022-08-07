package com.epam.rd.autotasks.words;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
        int count = 0;
        if (sample == null || words == null || words.length == 0) {
            return count;
        }

        for (String word : words) {
            if (word.strip().equalsIgnoreCase(sample.strip())) count++;
        }
        return count;
    }

    public static String[] splitWords(String text) {
        if (text == null || text.isBlank() || text.isEmpty()) return null;
        String[] splitedText = text.split("\\W+");
        if (splitedText.length == 0) return null;
        if (splitedText[0].isBlank()) return Arrays.copyOfRange(splitedText, 1, splitedText.length);
        return splitedText;
    }

    public static String convertPath(String path, boolean toWin) {
        if (path == null || path.isBlank()) {
            return null;
        }
        Pattern patternWindows = Pattern.compile("(^((C:)|[.])?((\\\\?|(\\\\?([a-zA-Z_0-9\\s]+|[.]{1,2}))*?)([.]\\w+)?)+?)$");
        Pattern patternUnix = Pattern.compile("(^(~|[.])?((/?|(/?([a-zA-Z_\\d\\s]+|[.]{1,2}))*?)([.]\\w+)?)+?)$");
        Matcher matcherWindows = patternWindows.matcher(path);
        Matcher matcherUnix = patternUnix.matcher(path);

        if (!matcherWindows.matches() && !matcherUnix.matches()) {
            return null;
        }

        if ((toWin && matcherWindows.matches() || (!toWin && matcherUnix.matches()))) {
            return path;
        }

        if (toWin) {
            path = Pattern.compile("^~").matcher(path).replaceAll("C:\\\\User");
            path = Pattern.compile("^/").matcher(path).replaceAll("C:\\\\");
            path = Pattern.compile("/").matcher(path).replaceAll("\\\\");
        } else {
            path = Pattern.compile("C:\\\\User").matcher(path).replaceAll("~");
            path = Pattern.compile("C:\\\\").matcher(path).replaceAll("/");
            path = Pattern.compile("\\\\").matcher(path).replaceAll("/");
        }

        return path;
    }


    public static String joinWords(String[] words) {
        if (words == null || words.length == 0) return null;
        StringBuilder joinedWords = new StringBuilder("[");
        for (String word : words) {
            if (!word.isBlank()) {
                joinedWords.append(word).append(", ");
            }
        }
        if (joinedWords.toString().equals("[")) return null;
        System.out.println(joinedWords);
        joinedWords.delete(joinedWords.length()-2, joinedWords.length()).append("]");
        return String.valueOf(joinedWords);
    }

    public static void main(String[] args) {
        System.out.println("Test 1: countEqualIgnoreCaseAndSpaces");
        String[] words = new String[]{" WordS    \t", "words", "w0rds", "WOR  DS", };
        String sample = "words   ";
        int countResult = countEqualIgnoreCaseAndSpaces(words, sample);
        System.out.println("Result: " + countResult);
        int expectedCount = 2;
        System.out.println("Must be: " + expectedCount);

        System.out.println("Test 2: splitWords");
        String text = "   ,, first, second!!!! third";
        System.out.println("text: " + text);
        String[] splitResult = splitWords(text);
        System.out.println("Result : " + Arrays.toString(splitResult));
        String[] expectedSplit = new String[]{"first", "second", "third"};
        System.out.println("Must be: " + Arrays.toString(expectedSplit));

        System.out.println("Test 3: convertPath");
        String unixPath = "/some/unix/path";
        String convertResult = convertPath(unixPath, true);
        System.out.println("Result: " + convertResult);
        String expectedWinPath = "C:\\some\\unix\\path";
        System.out.println("Must be: " + expectedWinPath);

        System.out.println("Test 4: joinWords");
        String[] toJoin = new String[]{"go", "with", "the", "", "FLOW"};
        String joinResult = joinWords(toJoin);
        System.out.println("Result: " + joinResult);
        String expectedJoin = "[go, with, the, FLOW]";
        System.out.println("Must be: " + expectedJoin);
    }
}