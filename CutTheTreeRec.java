package Non_Uploaded_Git;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class CutTreeRecNode{
    
    int dest;
    
    
    int data;
    Vector<Integer> adj;
    CutTreeRecNode(int start, int value){
    
        this.data = value;
        adj = new Vector<Integer>();
    }
}

 

public class CutTheTreeRec {
    static Vector<Integer> visited;
     static int minsum;
    static int rootsum;
    static Vector<CutTreeRecNode> graph;
    static int totalsum;
    public static int cutTheTree() {
        
        
        visited = new Vector<Integer>();
        minsum=Integer.MAX_VALUE;
        Stack<Integer> st1 = new Stack<Integer>();
        Stack<Integer> st2 = new Stack<Integer>();
        st2.push(0);
        visited.add(0);

        int currsum=0;
        while(!st2.isEmpty()){
            int x = st2.pop();
            CutTreeRecNode temp = graph.get(x);
            visited.add(x);
            // currsum += temp.data;
            // minsum = Math.min(Math.abs(currsum-(totalsum-currsum),minsum);
            for(int i=0;i<temp.adj.size();i++)
                {
                    if(!visited.contains(temp.adj.get(i))){
                        st1.push(temp.adj.get(i));
                        st2.push(temp.adj.get(i));
                    }
                }
        }
        visited = new Vector<Integer>();
        while(!st1.isEmpty()){
            int x = st1.pop();
            visited.add(x);
            CutTreeRecNode temp = graph.get(x);
            for(int con : temp.adj){
                if(!visited.contains(con)){
                    graph.get(con).data += temp.data;
                }
            }
            minsum = Math.min(minsum, Math.abs(temp.data - (totalsum-temp.data)));
            
        }

        return minsum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] dataTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        // List<Integer> data = new ArrayList<>();
        graph = new Vector<CutTreeRecNode>();
        // visited = new Vector<Integer>();
        totalsum = 0;
        for(int i=0;i<dataTemp.length;i++){
            graph.add(new CutTreeRecNode(i,Integer.parseInt(dataTemp[i])));
            totalsum+= Integer.parseInt(dataTemp[i]);
        }
        



        for (int i = 0; i < n - 1; i++) {
            String[] edgesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            graph.get(Integer.parseInt(edgesRowTempItems[0])-1).adj.add(Integer.parseInt(edgesRowTempItems[1])-1);
            graph.get(Integer.parseInt(edgesRowTempItems[1])-1).adj.add(Integer.parseInt(edgesRowTempItems[0])-1);
            
        }

        int result = cutTheTree();

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
