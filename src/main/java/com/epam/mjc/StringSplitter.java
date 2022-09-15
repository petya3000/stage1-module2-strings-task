package com.epam.mjc;

import java.util.*;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source     source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        List<String> list;

        StringBuilder regex = new StringBuilder();
        regex.append("[");
        for (String del : delimiters) regex.append(del);
        regex.append("]");

        list = Arrays.stream(source.split(regex.toString())).filter(el -> el.length() > 0).toList();

        return list;
    }
}
