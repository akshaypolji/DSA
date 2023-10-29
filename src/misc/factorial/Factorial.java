package misc.factorial;

import java.util.*;

public class Factorial {
    public static int factorial(int n) {
        if (n == 1 ) return 1;
        return n * factorial(n-1);
    }
    public static void main(String[] args) {
        int factorial_val = factorial(5);
        System.out.println(factorial_val);
    }
}

