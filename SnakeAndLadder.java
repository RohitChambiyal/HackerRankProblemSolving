package Non_Uploaded_Git;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

 
class laddernode{
    int idx;
    int parent;
    Vector<Integer> adj;
    laddernode(int i,int parent){
        this.idx=i;
        this.parent = parent;
        adj= new Vector<Integer>();
        
    }
}
public class SnakeAndLadder {
    static void replace(Vector<laddernode> graph,int start,int end,int index ){
        laddernode temp = graph.get(index);
        for(int i=0;i<temp.adj.size();i++){
            if(temp.adj.get(i)==start){
                temp.adj.set(i,end);
                return;
            }
        }
    }
    static int quickestWayUp(int[][] ladders, int[][] snakes) {
        int n  =100;
        Vector<laddernode> graph = new Vector<laddernode>();
        for(int i=0;i<n;i++)
            graph.add(new laddernode(i,i));
        
        for(int i=0;i<n-6;i++){
            for(int j=i+1;j<=i+6;j++){
                graph.get(i).adj.add(j);
            }
        }
        //ladder
        for(int i=0;i<ladders.length;i++){
            int start =ladders[i][0]-1;
            int end = ladders[i][1]-1;
            for(int j=start-1;j>=Math.max(0,start-6);j--){
                graph.get(start).adj.removeAllElements();
                replace(graph, start, end,j);
            }
        }
        //snake
        for(int i=0;i<snakes.length;i++){
            int start =snakes[i][0]-1;
            int end = snakes[i][1]-1;
            for(int j=start-1;j>=Math.max(0,start-6);j--){
                graph.get(start).adj.removeAllElements();
                // System.out.println("Calling "+j);
                replace(graph, start, end,j);
            }
        }
        // for(int i=0;i<n-6;i++){
        //     System.out.println("node "+i+"------");
        //     for(int j=0;j<graph.get(i).adj.size();j++){
        //         System.out.print(""+graph.get(i).adj.get(j)+"->");
        //     }
        //     System.out.println("\n");
        // }
        //BFS
        Queue<laddernode> queue = new LinkedList<laddernode>();
        HashSet<Integer> visited = new HashSet<Integer>();
        HashSet<Integer> allocparent = new HashSet<Integer>();
         queue.add(graph.get(0));
        while(!queue.isEmpty()){

            laddernode temp = queue.poll();
            
            // visited.add(temp.idx);
            // System.out.println("Entered "+temp.idx);
            for(int i=0;i<temp.adj.size();i++){
                
                int index = temp.adj.get(i);
                // System.out.println("child "+index);
                if(!visited.contains(index)){
                    graph.get(index).parent = temp.idx;    
                    queue.add(graph.get(index));
                    visited.add(index);
                }
                
                
                if(index>=93){
                    // System.out.println("parent "+temp.idx);
                    // System.out.println("current "+index);
                    int count=0;
                    // System.out.println("parent 5 "+ graph.get(5).parent);
                    // System.out.println("parent 4 "+ graph.get(4).parent);
                    count = parentcount(graph,index,count);
                    if(index!=99)
                        return count+1;
                    else
                    return count;
                }

                

            }
         }

        
        return -1;
        

    }

    
    private static int parentcount(Vector<laddernode> graph,int index,int count) {
        if(graph.get(index).parent!=index){
            count++;
            return parentcount(graph, graph.get(index).parent, count);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner s  = new Scanner(System.in);
        int t = s.nextInt();
        while(t--!=0){
            int ladderlen = s.nextInt();
            int ladders[][] = new int[ladderlen][2];
            for(int i=0;i<ladderlen;i++){
                ladders[i][0]=s.nextInt();
                ladders[i][1]=s.nextInt();
            }
            int snakelen = s.nextInt();
            int snakes[][] = new int[snakelen][2];
            for(int i=0;i<snakelen;i++){    
                snakes[i][0]=s.nextInt();
                snakes[i][1]=s.nextInt();
            }
            System.out.print("\nAnswer "+quickestWayUp(ladders, snakes));

        }
    }
}

/*

Ladder 3
31 61
41 67
11 97
Snake  7
94 12
96 24
92 36
78 26
74 18
48 46
66 16
*/