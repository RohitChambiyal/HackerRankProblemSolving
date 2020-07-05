package Non_Uploaded_Git;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class node{
    int idx;
    Vector<Integer> adj;
    node(int x){
        this.idx =x;
        adj = new Vector<Integer>();
    }
}
public class BFSShortest {

    static int[] bfs(int n, int edgelen, int[][] edge, int start) {
        Vector<node> graph = new Vector<node>();
        start--;
        int sum[] = new int[n];
        for(int i=0;i<n;i++){
            graph.add(new node(i));
        }
        for(int i=0;i<edgelen;i++){
            graph.get(edge[i][0]-1).adj.add(edge[i][1]-1);
            graph.get(edge[i][1]-1).adj.add(edge[i][0]-1);
        }
        Queue<node> queue = new LinkedList<node>();
        queue.add(graph.get(start));
        // int size =6;
        HashSet<Integer> visited = new HashSet<Integer>();
        visited.add(start);
        while(!queue.isEmpty()){
            node temp = queue.poll();
            // visited.add(temp.idx);
            // System.out.println("entered");
            for(int i=0;i<temp.adj.size();i++){
                int index = temp.adj.get(i);
                if(visited.contains(index)){
                    // System.out.println(index);
                    continue;
                }
                
                sum[index] = sum[temp.idx]+6;
                visited.add(index);
                queue.add(graph.get(index));
            }
        }
        int finalsum[] = new int[n-1];
        int j=0;
        for(int i=0;i<n;){
            if(j>=n)
                break;
            if(j!=start){
                if(sum[j]==0)
                    sum[j]=-1;
                finalsum[i]=sum[j];
                j++;
                i++;
            }
            else
                j++;
            
        }
        return finalsum;

        

    }

    private static final Scanner s = new Scanner(System.in);
public static void main(String[] args){
    int t = s.nextInt();
    while(t-- !=0){
        int n =s.nextInt();
        int edge = s.nextInt();
        int [][]edges = new int[edge][2];
        for(int i=0;i<edge;i++){
            edges[i][0] = s.nextInt();
            edges[i][1]=s.nextInt();
        }
        int start  = s.nextInt();
            int arr[] =bfs(n, edge, edges, start);
    }
}
}
