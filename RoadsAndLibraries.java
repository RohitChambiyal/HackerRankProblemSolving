package Data_Structure;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class roadsnode{
    int data;
    Vector<Integer> adj;
    roadsnode(){
        adj = new Vector<Integer>();
    }
    
}
public class RoadsAndLibraries {
    static long separate;
    static long edge;
    static HashSet<Integer> visited;
    static void dfs(Vector<roadsnode> graph, int index){
        if(visited.contains(index)) return;
        roadsnode temp = graph.get(index);
        
        visited.add(index);
        for(int i=0;i<temp.adj.size();i++){
            if(!visited.contains(temp.adj.get(i))){
            edge++;
            dfs(graph,temp.adj.get(i));

            }
        }
    }
    static long roadsAndLibraries(int nocities, int libcost, int roadcost, int[][] edges)   {         long lib = nocities;
            long res = lib*(long)libcost;
        if(roadcost>=libcost){
            return res;
        }
        Vector<roadsnode> graph = new Vector<roadsnode>();
        visited = new HashSet<Integer>();
        for(int i=0;i<nocities;i++){
            graph.add(new roadsnode());
        }
        for(int i=0;i<edges.length;i++){
            graph.get(edges[i][0]-1).adj.add(edges[i][1]-1);
            graph.get(edges[i][1]-1).adj.add(edges[i][0]-1);
        }
        separate =0;
        edge =0;
        for(int i=0;i<nocities;i++){
            if(!visited.contains(i)){
            separate++;
            dfs(graph,i);
            }
        }
        //         System.out.println("lib "+separate);

        // System.out.println("edges "+edge);
        long result =separate*(long)libcost+edge*(long)roadcost;
        return Math.min(result,res);
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nmC_libC_road = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmC_libC_road[0]);

            int m = Integer.parseInt(nmC_libC_road[1]);

            int c_lib = Integer.parseInt(nmC_libC_road[2]);

            int c_road = Integer.parseInt(nmC_libC_road[3]);

            int[][] cities = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] citiesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int citiesItem = Integer.parseInt(citiesRowItems[j]);
                    cities[i][j] = citiesItem;
                }
            }

            long result = roadsAndLibraries(n, c_lib, c_road, cities);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
