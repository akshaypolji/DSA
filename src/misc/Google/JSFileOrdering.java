package misc.Google;

import java.util.*;

public class JSFileOrdering {
    private Map<String, Set<String>> providesMap; // Map of provided symbols to files
    private Map<String, Set<String>> requiresMap; // Map of required symbols to files
    private Set<String> visited; // To keep track of visited files during traversal
    private List<String> orderedList; // Ordered list of files

    public JSFileOrdering() {
        providesMap = new HashMap<>();
        requiresMap = new HashMap<>();
        visited = new HashSet<>();
        orderedList = new ArrayList<>();
    }

    // Method to add a JS file's declarations
    public void addFileDeclarations(String fileName, Set<String> provides, Set<String> requires) {
        providesMap.put(fileName, provides);
        requiresMap.put(fileName, requires);
    }

    // Method to generate the ordered list of JS files
    public List<String> generateOrderedFileList() {
        for (String fileName : providesMap.keySet()) {
            if (!visited.contains(fileName)) {
                dfs(fileName);
            }
        }
        Collections.reverse(orderedList); // Reverse the list to get the correct order
        return orderedList;
    }

    private void dfs(String fileName) {
        visited.add(fileName);
        Set<String> requiredSymbols = requiresMap.get(fileName);

        if (requiredSymbols != null) {
            for (String symbol : requiredSymbols) {
                Set<String> providers = providesMap.get(symbol);
                if (providers != null) {
                    for (String provider : providers) {
                        if (!visited.contains(provider)) {
                            dfs(provider);
                        }
                    }
                }
            }
        }

        orderedList.add(fileName);
    }

    public static void main(String[] args) {
        JSFileOrdering fileOrdering = new JSFileOrdering();

        // Sample input declarations
        fileOrdering.addFileDeclarations("a.js", new HashSet<>(Arrays.asList("A")), new HashSet<>(Arrays.asList("B", "C")));
        fileOrdering.addFileDeclarations("b.js", new HashSet<>(Arrays.asList("B")), new HashSet<>(Arrays.asList("D")));
        fileOrdering.addFileDeclarations("c.js", new HashSet<>(Arrays.asList("C")), new HashSet<>(Arrays.asList("D")));
        fileOrdering.addFileDeclarations("d.js", new HashSet<>(Arrays.asList("D")), new HashSet<>());

        List<String> orderedList = fileOrdering.generateOrderedFileList();
        System.out.println("Ordered List: " + orderedList);
    }
}

