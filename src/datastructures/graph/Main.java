package datastructures.graph;

import java.util.ArrayList;

class Main {
    public static void main (String[] args) {
        int n = 5;
        int[][] edges = {
                {1, 0}, {0, 2},
                {2, 1}, {0, 3},
                {3, 4}
        };
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        Solution obj = new Solution();
        int ans = obj.kosaraju(n, adj);
        System.out.println("The number of strongly connected components is: " + ans);
    }
}
