package misc.pointers;

import java.util.HashMap;

public class Main {
    public static void main(String[] args){
        System.out.println("------- Static Reference Variables -----");

        int num1 = 11;
        int num2 = num1;

        num1 = 22;

        System.out.println(num1 + " " + num2);

        System.out.println("-------- Pointers ----");

        HashMap<String, Integer> num3 = new HashMap<>();
        HashMap<String, Integer> num4 = new HashMap<>();

        num3.put("value",11);
        num4 = num3;

        num3.put("value",22);

        System.out.println(num3);
        System.out.println(num4);
    }
}
