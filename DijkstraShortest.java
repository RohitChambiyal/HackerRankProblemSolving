package Non_Uploaded_Git;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
class djnode{
    int data;
    int parent;
    List<djedge> adj;
    djnode(int parent){
        this.parent = parent;
        adj = new ArrayList<djedge>();
    }
}
class djedge implements Comparable<djedge>{
    int nodeno;
    int weight;
    djedge(int nodeno,int weight){
        this.nodeno=nodeno;
        this.weight = weight;
    }   
    public int compareTo(djedge e2){
        return this.weight-e2.weight;
    }
}
class pair{
    int end;
    int weight;
    int oldi;
    pair(int end,int weight){
        
        this.end = end;
        this.weight = weight;
    }
}
public class DijkstraShortest {

    static PriorityQueue<djedge> queue1;
    static HashSet<Integer> visited;
    static int distance[];

    static int[] shortestReach(int n, int[][] edges, int s) {
        Vector<djnode> graph = new Vector<djnode>();
        HashMap<Integer,pair> map1 = new HashMap<Integer,pair>();
        for(int i=0;i<edges.length;i++){
            int src=Math.min(edges[i][0],edges[i][1]);
            int dest=Math.max(edges[i][0],edges[i][1]);
            if(map1.containsKey(src)&&map1.get(src).end==dest){
                    if(edges[i][2]<map1.get(src).weight){
                        map1.get(src).weight = edges[i][2];
                        edges[map1.get(src).oldi][2] = -1;
                        map1.get(src).oldi=i;
                    }
                    else{
                        edges[i][2] = -1;
                    }
                
            }
            else{
                map1.put(src,new pair(dest,edges[i][2]));
                map1.get(src).oldi = i;
            }
        }
        visited = new HashSet<Integer>();
        queue1 = new PriorityQueue<djedge>();
        distance = new int[n];
        s--;
        // System.out.println("s "+s);
        
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[s]=0;
        for(int i=0;i<n;i++){
            graph.add(new djnode(i));
        }
        int count=0;
        for(int i=0;i<edges.length;i++){
            if(edges[i][2]!=-1){
                   count++; 
            graph.get(edges[i][0]-1).adj.add(new djedge(edges[i][1]-1,edges[i][2]));
            graph.get(edges[i][1]-1).adj.add(new djedge(edges[i][0]-1,edges[i][2]));
            }
        }
        System.out.println(" count "+count);
        queue1.add(new djedge(s,0));
        while(visited.size()!=n){
            if(queue1.isEmpty()){
                break;
            }
            djedge temp = queue1.poll();
            // System.out.println("temp "+temp.nodeno);
            visited.add(temp.nodeno);
            neighbours(graph,temp.nodeno);
        }
        for(int i=0;i<n;i++)
        {
            if(distance[i]==Integer.MAX_VALUE)
                distance[i]=-1;
        }
        return distance;
    }
    public static void neighbours(Vector<djnode> graph,int index){
        djnode temp = graph.get(index);
        // System.out.println("Endeted "+index +" distance "+distance[index]);
        for(int i=0;i<temp.adj.size();i++){
            djedge x = temp.adj.get(i);
            if(!visited.contains(x.nodeno)){
                if(x.weight+distance[index]<distance[x.nodeno]){
                    distance[x.nodeno] = x.weight+distance[index];
                }
                // System.out.println("Added nodeno"+x.nodeno+" distance "+distance[x.nodeno]);
                queue1.add(new djedge(x.nodeno,distance[x.nodeno]));
            }

        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine());
        

        for (int tItr = 0; tItr < t; tItr++) {
            String[] stmp =in.readLine().split(" ");
            int n = Integer.parseInt(stmp[0]);
            int m = Integer.parseInt(stmp[1]);
            int[][] edges = new int[m][3];

            for (int i = 0; i < m; i++) {
                    String stm[] = in.readLine().split(" ");
                    edges[i][0] =Integer.parseInt(stm[0]);
                    edges[i][1] =Integer.parseInt(stm[1]);
                    edges[i][2] = Integer.parseInt(stm[2]);
                }
            

            int s = Integer.parseInt(in.readLine());
            

            int[] shortestPaths = shortestReach(n, edges, s);
            System.out.println("reached");

          StringBuilder out = new StringBuilder("");
        for (int j = 0; j < n; j++) {
          if (s != j) {
            if (shortestPaths[j] == Integer.MAX_VALUE) {
              out.append("-1 ");
            } else {
              out.append(shortestPaths[j]);
              out.append(" ");
            }
          }
        }
        out.append("\n");
            bufferedWriter.write(out.toString());
        }

        bufferedWriter.close();

      
    }
}
