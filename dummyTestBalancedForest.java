package Data_Structure;

// Balanced Forest problem from hackerrank.
// This solution is based on venom1724's solution posted in the hackerrank discussion.

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class dummyTestBalancedForest {

    public static void main(String[]args){
        Scanner s = new Scanner(System.in)   ;
        int total = s.nextInt();
        int weight[] = new int[total];
        for(int i=0;i<total;i++){
            weight[i] = s.nextInt();
        }
        int edges[][] = new int[total-1][total-1];
        for(int i=0;i<total-1;i++){
            edges[i][0] = s.nextInt();
            edges[i][1] = s.nextInt();
        }

       System.out.println(balancedForest(weight,edges));
    }


    static class Node {
        long cost;
        boolean visited=false, v2=false;
        ArrayList<Integer> adjacent = new ArrayList<>();

        public Node(long cost) {
            this.cost = cost;
        }
    }

    static long mini, sum;
    static HashSet<Long> s = new HashSet<>();
    static HashSet<Long> q = new HashSet<>();

    static long balancedForest(int[] node_values, int[][] edges) {
        s = new HashSet<>();
        q = new HashSet<>();

        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < node_values.length; i++) {
            nodes.add(new Node(node_values[i]));
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int a = edge[0] - 1;
            int b = edge[1] - 1;
            nodes.get(a).adjacent.add(b);
            nodes.get(b).adjacent.add(a);
        }

        mini = sum = dfs(0, nodes);
        // System.out.println("cost after dfs "+ nodes.get(0).cost);
        // System.out.println("cost after dfs "+ nodes.get(1).cost);
        // System.out.println("cost after dfs "+ nodes.get(2).cost);
        // System.out.println("cost after dfs "+ nodes.get(3).cost);
        // System.out.println("cost after dfs "+ nodes.get(4).cost);
        solve(0, nodes);

        return mini == sum ? -1 : mini;
    }

    // s contains sums encountered during depth first search excluding those from the root to the current node.
    // q contains sums encountered during depth first search from the root to current node.
    private static void solve(int p, ArrayList<Node> nodes) {
        Node node = nodes.get(p);
        if (node.v2) return;
        node.v2 = true;

        // long[] x = {2*node.cost,
        //         2*sum - 4*node.cost,
        //         sum-node.cost};
        long[] y = {3*node.cost - sum,
                (sum-node.cost)/2 - node.cost};

        // If removing the edge above the current node (node variable defined at the top of this method)
        // gives two trees whose total values are the same, then the node we add should have that
        // same value too to get 3 trees (one of which is our single node that we added) with the same value.
        if (sum % 2 == 0 && node.cost == (sum/2)) mini = Math.min(mini, sum/2);

        // case 1a: When two non-overlapping subtrees in the overall tree have the same total value.
        if (s.contains(node.cost)) {// ||                      // case 1a
//                q.contains(2*node.cost) ) {                  // ?
            if (y[0] >= 0) mini = Math.min(mini, y[0]);
        }

        // case 1b: (part B): Two non-overlapping subtrees in the overall tree.
        // case 2b: One edge to be removed is below the other edge to be removed in the overall tree.
        if (s.contains(sum - 2*node.cost)   ||                 // case 1b (part B)
                q.contains(sum - node.cost) ) {                // case 2b
            if (y[0] >= 0) mini = Math.min(mini, y[0]);
        }

        // case 1b: (part A): Two non-overlapping subtrees in the overall tree.
        // case 2a: One edge to be removed is below the other edge to be removed in the overall tree.
        if ((sum - node.cost) % 2 == 0) {
            if (s.contains((sum-node.cost) / 2 )  ||            // case 1b (part A)
                    q.contains((sum + node.cost) / 2)) {        // case 2a
                if (y[1] >= 0) mini = Math.min(mini, y[1]);
            }
        }

        q.add(node.cost);

        for (int i = 0; i < node.adjacent.size(); i++) {  // DFS!!
            solve(node.adjacent.get(i), nodes);           // recursive call
        }

        q.remove(node.cost);
        s.add(node.cost);
    }


    private static long dfs(int p, ArrayList<Node> nodes) {
        
        Node node = nodes.get(p);
        if (node.visited) return 0;
        node.visited = true;
        for (int i = 0; i < node.adjacent.size(); i++) {
            node.cost += dfs(node.adjacent.get(i), nodes);
            System.out.println("cost "+node.cost);
        }
        return node.cost;
    }

}