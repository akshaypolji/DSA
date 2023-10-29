package misc.Google;

import java.util.*;

class JSFileOrderer {
    private Map<String, List<String>> dependencies;

    public JSFileOrderer() {
        dependencies = new HashMap<>();
    }

    public void addDependency(String symbol, String fileName) {
        dependencies.computeIfAbsent(symbol, k -> new ArrayList<>()).add(fileName);
    }

    public List<String> generateOrderedList() {
        List<String> orderedList = new ArrayList<>();
        Set<String> visited = new HashSet<>();

        for (String symbol : dependencies.keySet()) {
            dfs(symbol, visited, orderedList);
        }

        Collections.reverse(orderedList); // Reverse to get the correct order
        return orderedList;
    }

    private void dfs(String symbol, Set<String> visited, List<String> orderedList) {
        if (visited.contains(symbol)) {
            return;
        }
        visited.add(symbol);

        List<String> dependenciesList = dependencies.get(symbol);
        if (dependenciesList != null) {
            for (String dependency : dependenciesList) {
                dfs(dependency, visited, orderedList);
            }
        }

        orderedList.add(symbol);
    }
}

// Define the scanner API for parsing JS files
class JSScanner {
    public static void parseFile(String fileName, JSFileOrderer fileOrderer) {
        // Implement your file parsing logic here to extract declarations
        // For each declaration, call fileOrderer.addDependency(symbol, fileName)
        // Example:
        // fileOrderer.addDependency("A", fileName);
        // fileOrderer.addDependency("B", fileName);
    }
}

