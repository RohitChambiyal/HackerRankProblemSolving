package Data_Structure;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;

class jnodes{
    int data;
    Vector<Integer> adjecent = new Vector<Integer>();
    jnodes(){
        this.data =1;
    }
}
public class JennysSubtrees {
    static Vector<Integer> visited;
    static int rad;
    static int count;
    static int result;
    private static int jennysSubtrees(int nodes, int radius, int[][] edges) {
        Vector<jnodes> graph = new Vector<jnodes>();
        HashSet<Integer> hash = new HashSet<Integer>();
        visited = new Vector<Integer>();
        count =1;
        result=0;
        rad = radius;
        int curradius=0;
        for(int i=0;i<nodes;i++){
            graph.add(new jnodes());
        }
        for(int i=0;i<edges.length;i++){
            graph.get(edges[i][0]-1).adjecent.add(edges[i][1]-1);
            graph.get(edges[i][1]-1).adjecent.add(edges[i][0]-1);
        }
        //DFS
    for(int i=0;i<nodes;i++){
        count=0;
        visited.removeAllElements();
        //System.out.println("before "+count);
        //System.out.println(visited);
        System.out.println("\nStarting index "+ i);
        dodfs(graph,i,curradius);
        System.out.println("total count here  "+count);
        if(!hash.contains(count)){
            hash.add(count);
            result++;
        }
    }
    
    System.out.println("unique result "+result);
    return result;
    }
    
    private static void dodfs(Vector<jnodes> graph, int nodeindex,int curradius) {
        System.out.print("entering "+nodeindex+" ");
        if(curradius==rad){
            count++;
            System.out.println("      radequal "+nodeindex);
            return;
        }
        jnodes temp = graph.get(nodeindex);
        if(visited.contains(nodeindex)) return;
        System.out.println("     non visited "+nodeindex);
        visited.add(nodeindex);
        count++;
        for(int i=0;i<temp.adjecent.size();i++){
            if(!visited.contains(temp.adjecent.get(i)))
                dodfs(graph, temp.adjecent.get(i), curradius+1);
        }

    }

    public static void main(String[] args) {
        Scanner s  = new Scanner(System.in);
        int nodes = s.nextInt();
        int radius = s.nextInt();
        int edges[][] = new int[nodes-1][2];
        for(int i=0;i<nodes-1;i++){
            edges[i][0]= s.nextInt();
            edges[i][1] = s.nextInt();
        }
        jennysSubtrees(nodes,radius,edges);
    }

}

/*
        Test Cases

20 9

    1 19
    12 8
    3 9
    10 2
    13 7
    17 4
    14 18
    14 16
    20 6
    2 3
   6 15
    16 1
    5 9
4 16
3 18
12 4
11 20
2 7
11 16



                Test CAse 2:

30 2
22 26
14 11
18 22
3 4
24 10
7 14
4 12
2 11
8 15
6 17
5 3
9 13
15 7
26 29
21 30
20 30
13 25
2 1
24 6
28 21
9 8
11 10
25 16
27 17
20 19
28 10
14 29
16 5
23 24
*/