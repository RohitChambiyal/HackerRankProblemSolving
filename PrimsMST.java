package Non_Uploaded_Git;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
class primnode{
    int idx;
    Vector<Integer> adj;
    primnode(int idx){
        this.idx = idx;
        adj = new Vector<Integer>();
    }
}
class primedge implements Comparable<primedge>{
    int start;
    int end;
    int weight;
    primedge(int start,int end,int weight){
        this.start = start;
        this.end = end;
        this.weight= weight;
    }
    public int compareTo(primedge e1){
        return this.weight-e1.weight;
    }
}
public class PrimsMST {
    static int prims(int n, int[][] gedges, int start) {
        Vector<primnode> graph = new Vector<primnode>();
        for(int i=0;i<n;i++)
            graph.add(new primnode(i));
        Vector<primedge> edges= new Vector<primedge>();
        for(int i=0;i<gedges.length;i++){
            edges.add(new primedge(gedges[i][0]-1,gedges[i][1]-1,gedges[i][2]));
        }
        Collections.sort(edges);
        HashSet<Integer>visited = new HashSet<Integer>();
        start--;
        visited.add(start);
        int sum=0;
        int i = 0;
        int previdx=0;
        // Vector<Integer> total = new Vector<Integer>();
        // System.out.println("herer`");
        while(visited.size()<n){
            // System.out.print(i+" ");
            if(visited.contains(edges.get(i).start)&&visited.contains(edges.get(i).end)){
                // System.out.println("Already inside "+(edges.get(i).start+1)+" "+(edges.get(i).end+1));
                i++;
                continue;   
            }
            if((!visited.contains(edges.get(i).start))&&(!visited.contains(edges.get(i).end))){
                // System.out.println("Already outside "+(edges.get(i).start+1)+" "+(edges.get(i).end+1));
                i++;
                continue;
            }
            
            if(visited.contains(edges.get(i).start)){
                // System.out.println("ADDED 1st "+(edges.get(i).start+1)+" "+(edges.get(i).end+1));
                sum+=edges.get(i).weight;
                visited.add(edges.get(i).end);
            }

            else if(visited.contains(edges.get(i).end)){
                // System.out.println("ADDED 2nd "+(edges.get(i).start+1)+" "+(edges.get(i).end+1));
                sum+=edges.get(i).weight;
                visited.add(edges.get(i).start);
                
                        
                    
                
            }
            // System.out.println("visited size "+visited.size()+" ");
            // System.out.println("i "+i+" ");
            // System.out.println("previdx size "+previdx);
            // System.out.println();
            i=previdx;
            
        }
        return sum;


    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int e = s.nextInt();
        // System.out.println("Edges");
        int edges[][]= new int[e][3];
        for(int i=0;i<e;i++){
            edges[i][0]= s.nextInt();
            edges[i][1]= s.nextInt();
            edges[i][2]= s.nextInt();
        }
        // System.out.println("OUT");
        int start = s.nextInt();
        int result =prims(n, edges, start);
        System.out.println("result "+result);
        System.out.println();

    }
}
/*
5 6
1 2 3
1 3 4
4 2 6
5 2 2
2 3 5
3 5 7
1
*/