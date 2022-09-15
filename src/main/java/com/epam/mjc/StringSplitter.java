package com.epam.mjc;

import java.lang.reflect.Array;
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

        StringBuilder regex = new StringBuilder();
        regex.append("[");
        for (String del : delimiters) regex.append(del);
        regex.append("]");

        String[] strings = source.split(regex.toString());

        List<String> list = new ArrayList<>();

        for (String str : strings)
            if (!str.isEmpty())
                list.add(str);


        return list;
    }
}
