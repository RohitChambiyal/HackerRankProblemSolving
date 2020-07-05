package Non_Uploaded_Git;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class CutTreeNode{
    
    int dest;
    
    
    int data;
    Vector<Integer> adj;
    CutTreeNode(int start, int value){
    
        this.data = value;
        adj = new Vector<Integer>();
    }
}

class Result1 {
    static Vector<Integer> visited;
    public static int dfs(int index){
        visited.add(index);
        // CutTreeNode temp = graph.get(index);
        for(int i=0;i<graph.get(index).adj.size();i++){
            // System.out.println("here");
            if(!visited.contains(graph.get(index).adj.get(i))){
                graph.get(index).data += dfs(graph.get(index).adj.get(i));
            }
        }
        return graph.get(index).data;
    }
    static int minsum;
    static int rootsum;
    public static void dfssum(int index){
        visited.add(index);
        // CutTreeNode temp = graph.get(index);
        for(int i=0;i<graph.get(index).adj.size();i++){
            if(!visited.contains(graph.get(index).adj.get(i))){
                dfssum(graph.get(index).adj.get(i));
            }
        }
        if(index!=0){
            int x = Math.abs((rootsum-graph.get(index).data)-graph.get(index).data);
            minsum = Math.min(minsum,x);
        }
    }
    static Vector<CutTreeNode> graph;
    public static int cutTheTree(List<Integer> data, List<List<Integer>> edges) {
        graph = new Vector<CutTreeNode>();
        visited = new Vector<Integer>();
        for(int i=0;i<data.size();i++)
            graph.add(new CutTreeNode(i,data.get(i)));
        for(int i=0;i<edges.size();i++){
            graph.get(edges.get(i).get(0)-1).adj.add(edges.get(i).get(1)-1);
            graph.get(edges.get(i).get(1)-1).adj.add(edges.get(i).get(0)-1);
            }
        dfs(0);
        visited = new Vector<Integer>();
        minsum=Integer.MAX_VALUE;
        rootsum =graph.get(0).data;
        // System.out.println("rootsum "+rootsum);
        dfssum(0);
        return minsum;
    }
}

public class CutTheTree {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] dataTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> data = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int dataItem = Integer.parseInt(dataTemp[i]);
            data.add(dataItem);
        }

        List<List<Integer>> edges = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            String[] edgesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> edgesRowItems = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                int edgesItem = Integer.parseInt(edgesRowTempItems[j]);
                edgesRowItems.add(edgesItem);
            }

            edges.add(edgesRowItems);
        }

        int result = Result1.cutTheTree(data, edges);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
