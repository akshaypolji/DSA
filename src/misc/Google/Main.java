package misc.Google;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        JSFileOrderer fileOrderer = new JSFileOrderer();

        // Parse the JS files and add dependencies
        JSScanner.parseFile("a.js", fileOrderer);
        JSScanner.parseFile("b.js", fileOrderer);
        JSScanner.parseFile("c.js", fileOrderer);
        JSScanner.parseFile("d.js", fileOrderer);

        // Generate the ordered list of JS files
        List<String> orderedList = fileOrderer.generateOrderedList();
        Collections.reverse(orderedList); // Reverse again to get the correct order

        System.out.println("Ordered List of JS Files: " + orderedList);
    }
}
