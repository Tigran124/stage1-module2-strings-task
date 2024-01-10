package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source     source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        List<String> result = new ArrayList<>();
        int startIndex = 0;
        int endIndex;
        String del = delimiters.toString();
        for (int i = 0; i < source.length(); i++) {
            char currentChar = source.charAt(i);
            if (del.indexOf(currentChar) != -1) {
                endIndex = i;
                String temp = source.substring(startIndex, endIndex);
                if (!temp.isEmpty()) {
                    result.add(temp);
                }
                startIndex = i + 1;
            }
        }
        String temp = source.substring(startIndex);
        if (!temp.isEmpty()) {
            result.add(temp);
        }
        return result;
    }
}
