package Non_Uploaded_Git;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class nodeET{
    
    int cost;
    Vector<Integer> adj;
    nodeET(){
         adj = new Vector<Integer>();
         cost = 1;
    }
}
public class EvenTree {
    static int count;
    static HashSet<Integer> visited;
    static void dfs(Vector<nodeET> graph, int index){
        visited.add(index);
        int cost=0;
        nodeET temp = graph.get(index);
        for(int i=0;i<temp.adj.size();i++){
            if(visited.contains(temp.adj.get(i)))
                continue;
            dfs(graph,temp.adj.get(i));
            cost+= graph.get(temp.adj.get(i)).cost;
        }
        graph.get(index).cost += cost;
        if(graph.get(index).cost%2==0&&index!=0){
            graph.get(index).cost =0;
            count++;
        }
        
    }
    // Complete the evenForest function below.
    static int evenForest(int n, int e, List<Integer> source, List<Integer> dest) {
        Vector<nodeET> graph = new Vector<nodeET>();
        visited = new HashSet<Integer>();
        count =0;
        for(int i=0;i<n;i++){
            graph.add(new nodeET());
        }
        for(int i=0;i<e;i++){
            graph.get(source.get(i)-1).adj.add(dest.get(i)-1);
            graph.get(dest.get(i)-1).adj.add(source.get(i)-1);
        }
        dfs(graph,0);
        return count;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] tNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int tNodes = Integer.parseInt(tNodesEdges[0]);
        int tEdges = Integer.parseInt(tNodesEdges[1]);

        List<Integer> tFrom = new ArrayList<>();
        List<Integer> tTo = new ArrayList<>();

        for (int i = 0; i < tEdges; i++) {
            String[] tFromTo = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            tFrom.add(Integer.parseInt(tFromTo[0]));
            tTo.add(Integer.parseInt(tFromTo[1]));
        }

        int res = evenForest(tNodes, tEdges, tFrom, tTo);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
