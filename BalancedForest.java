package Data_Structure;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;

/*
Finding Balanced forest:
    breaking 2 nodes and adding some to third will give forest.

Steps :

1. store graph in vector node;
2. start from node which is present for all, origin;

3. do dfs from start :-> store all child sum to root using dfs

                             Now solve part
4.  sum = minreq = maxsum.
    TopDown<set>    // store ongoing sum from top.
    BottomUp<Set>   // store from bottom
    visiteddfs:     for dfs
    visitedsolve:   for solve.

5. send root node to solve part.

6. if(visitedsolve: return)

    int threetaken = 3*nodevalue - sum;

    int halfhalf   = (sum-3*nodevalue)/2;

case 1:
    if(half of sum  && sum even) -> mini =min(mini, 1/2sum);

case 2:
    if(already present in bottomup) -> mini =(y[0],mini)

case 3:
    if(sum -twice node in bottomup) 
                or 
    if(sum - node in topdown)

        mini = taking3&&mini min()
    
case 4:
    if(sum-nodevalue)%2==0

        if(sum-node.cost)/2 in bottomup
                or
        if(sum+node.cost)/2 in topdown
            halfhalf and mini minimum
    
    put to topdown(nodevalue)

    Dfs to all its childs

    removechild.
    add to bottomup




*/
class nodes{
    long data ;
    boolean visiteddfs=false;
    boolean visitedsol =false;

    ArrayList<Integer> adj = new ArrayList<Integer>();
    
    nodes(int data){
        this.data = data;
    }
}
public class BalancedForest {
    static long sum;
    static long minimumreq;
    static HashSet<Long> topdownsum= new HashSet<Long>();
    static HashSet<Long> bottomupsum = new HashSet<Long>();
    // static boolean visited[][];
    
public static long balancedForestUtil(int[] weight,int[][] edges){
        topdownsum = new HashSet<Long>();
        bottomupsum = new HashSet<Long>();
        int total = weight.length;
        // visited = new boolean[total][total];
        ArrayList<nodes> allnodes = new ArrayList<nodes>();
        for(int i=0;i<total;i++)
            allnodes.add(new nodes(weight[i]));
        
//adding children
        for(int i=0;i<edges.length;i++){
            allnodes.get(edges[i][0]-1).adj.add(edges[i][1]-1);
            allnodes.get(edges[i][1]-1).adj.add(edges[i][0]-1);
        }
        minimumreq = sum = dfsforest(allnodes, 0);
        findreq(allnodes,0);
        return minimumreq==sum ? -1: minimumreq;
    }

    
    private static void findreq(ArrayList<nodes> allnodes, int nodeno) {
        nodes temp = allnodes.get(nodeno);
        if(temp.visitedsol==true)   return;
        temp.visitedsol=true;
        
        long allthreetaken = 3*temp.data - sum;
        long halfhalf = (sum-temp.data)/2 - temp.data;

//Case 1 if value = half of total && total is even(make sure no decimal for /2) 
        if(temp.data==sum/2 && sum%2==0) 
            minimumreq = Math.min(minimumreq,sum/2);

//case 2:   if(any other node also present with same sum, then we take minreq of allthreetaken).
        if(bottomupsum.contains(temp.data)){
            if(allthreetaken>=0)
                minimumreq = Math.min(minimumreq,allthreetaken);
        }
//case 3:   if(left after removing twice of value from sum present in bottomupsum/other subtree ) 
//                                              ||
//                           if(sum-value present in all tree, then do)
        if((bottomupsum.contains(sum-2*temp.data)) || topdownsum.contains(sum-temp.data) ){
            if(allthreetaken>=0)
                minimumreq = Math.min(minimumreq,allthreetaken);
        }
//case 4:   if(sum even &&  (if(other contains half sum removing value )|| if(upper tree contains sum+value /2))
        if((sum-temp.data)%2==0){
                if(bottomupsum.contains((sum-temp.data)/2) || topdownsum.contains((sum+temp.data)/2)){
                    if(halfhalf>=0)
                        minimumreq = Math.min(minimumreq,halfhalf);
                }
        }
        topdownsum.add(temp.data);
        for(int i=0;i<temp.adj.size();i++){
            findreq(allnodes, temp.adj.get(i));
        }
        topdownsum.remove(temp.data);
        bottomupsum.add(temp.data);

    }

public static long dfsforest(ArrayList<nodes> allnodes, int start) {
    nodes temp = allnodes.get(start);
    if(temp.visiteddfs) return 0;
    temp.visiteddfs=true;
    for(int i=0;i<temp.adj.size();i++){
        temp.data += dfsforest(allnodes,temp.adj.get(i));
        System.err.println("cost "+temp.data);
    }
    return temp.data;
    
}


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

        long result =balancedForestUtil(weight,edges);
        System.out.println("result "+result);
    }
}


