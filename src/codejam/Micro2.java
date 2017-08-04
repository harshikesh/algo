package codejam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Created by harshikesh.kumar on 22/06/17.
 */
public class Micro2 {
    static int[] adorableCount(String[] words) {

        String regexStr = "^[a-z]([a-z]*[0-9]*:*)\\/([a-z]*)([0-9]*)+\\\\[a-z]+";
        int returnIntArray[] = new int[words.length];

        try {
            Pattern compiledRegExPattern = Pattern.compile(regexStr);

            for (int index = 0; index < words.length; index++) {
                String inputStr = words[index];
                int count = 0;
                System.out.println("regex : " + regexStr);
                System.out.println("input : " + inputStr);

                for (int i = 0; i < inputStr.length(); i++) {
                    String previousMatchedStr = null, currentMatchedStr = null;
                    for (int j = inputStr.length() - 1; j > i; j--) {
                        // getSubstring of inputStr[i..j]
                        // because substring endIndex is exclusive, that's why
                        // j+1.
                        String subString = inputStr.substring(i, j + 1);
                        Matcher matcher = compiledRegExPattern.matcher(subString);
                        // matcher.find -> for that substring
                        if (matcher.find()) {
                            currentMatchedStr = matcher.group();
                            if (previousMatchedStr == null) {
                                previousMatchedStr = currentMatchedStr;
                                System.out.println("\nFound [" + currentMatchedStr + "] in the input string " + inputStr
                                        + " starting at " + matcher.start() + " and ending at " + (matcher.end() - 1)
                                        + " with i = " + i + ", j = " + j);
                                count++;
                            } else if (previousMatchedStr != null
                                    && !previousMatchedStr.equalsIgnoreCase(currentMatchedStr)) {
                                previousMatchedStr = currentMatchedStr;
                                System.out.println("Found [" + currentMatchedStr + "] in the input string " + inputStr
                                        + " starting at " + matcher.start() + " and ending at " + (matcher.end() - 1)
                                        + " with i = " + i + ", j = " + j);
                                count++;
                            }

                        }
                    }
                }
                returnIntArray[index] = count;
            }

        } catch (PatternSyntaxException pse) {
            System.err.println("Bad regex: " + pse.getMessage());
            System.err.println("Description: " + pse.getDescription());
            System.err.println("Index: " + pse.getIndex());
            System.err.println("Incorrect pattern: " + pse.getPattern());
        }

        return returnIntArray;

    }
}
