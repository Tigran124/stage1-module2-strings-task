package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        String[] sig = signatureString.split(" ");
        String name = "";
        MethodSignature methodSignature;
        if (sig[0].equals("public") || sig[0].equals("private")) {
            for (int i = 0; i < sig[2].length(); i++) {
                if ('(' == sig[2].charAt(i)) {
                    name = sig[2].substring(0, i);
                    break;
                }
            }
            List<MethodSignature.Argument> argumentList = new ArrayList<>();
            String[] arg = signatureString.split(name, 2);
            if (arg[1].length() > 2) {
                String[] args = arg[1].substring(1, arg[1].length() - 1).split(",");
                for (String str : args) {
                    String[] x = str.trim().split(" ");
                    MethodSignature.Argument argument = new MethodSignature.Argument(x[0], x[1]);
                    argumentList.add(argument);
                }
            }
            methodSignature = new MethodSignature(name, argumentList);
            methodSignature.setAccessModifier(sig[0]);
            methodSignature.setReturnType(sig[1]);
        }else {
            for (int i = 0; i < sig[1].length(); i++) {
                if ('(' == sig[1].charAt(i)) {
                    name = sig[1].substring(0, i);
                    break;
                }
            }
            List<MethodSignature.Argument> argumentList = new ArrayList<>();
            String[] arg = signatureString.split(name, 2);
            if (arg[1].length() > 2) {
                String[] args = arg[1].substring(1, arg[1].length() - 1).split(",");
                for (String str : args) {
                    String[] x = str.trim().split(" ");
                    MethodSignature.Argument argument = new MethodSignature.Argument(x[0], x[1]);
                    argumentList.add(argument);
                }
            }
            methodSignature = new MethodSignature(name, argumentList);
            methodSignature.setReturnType(sig[0]);
        }
        return methodSignature;
//        throw new UnsupportedOperationException("You should implement this method.");
    }
}
