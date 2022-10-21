package org.example.module_3.lesson3;

public class Calc {
    public static int addNumbers(int numberA, int numberB) throws CalcException {
        if (numberA == 0 && numberB == 0) {
            throw new CalcException();
        }
        return numberA + numberB;
    }

    public static int divide(int a, int b) {
        return a / b;
    }
}
