package com.epam.mjc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     * 1. access modifier - optional, followed by space: ' '
     * 2. return type - followed by space: ' '
     * 3. method name
     * 4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     * accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     * private void log(String value)
     * <p>
     * Vector3
     * distort
     * int
     * x,
     * int
     * y,
     * int
     * z,
     * float
     * magnitude)
     * <p>
     * public
     * DateTime
     * getCurrentDateTime
     * )
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        Collection<String> delimiters = Arrays.asList("(", " ", ", ", ")");
        List<String> list = new StringSplitter().splitByDelimiters(signatureString, delimiters);

        String access = null, returnT, name;
        int start;
        if (list.get(0).equals("private") || list.get(0).equals("protected") || list.get(0).equals("public")) {
            access = list.get(0);
            returnT = list.get(1);
            name = list.get(2);
            start = 3;
        } else {
            returnT = list.get(0);
            name = list.get(1);
            start = 2;
        }

        List<MethodSignature.Argument> args = new ArrayList<>();

        for (int i = start; i + 1 < list.size(); i += 2) {
            args.add(new MethodSignature.Argument(list.get(i), list.get(i + 1)));
        }

        MethodSignature ms = new MethodSignature(name, args);
        ms.setAccessModifier(access);
        ms.setReturnType(returnT);

        return ms;
    }
}
