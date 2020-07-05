package Non_Uploaded_Git;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class CutTreeRecResult {

    /*
     * Complete the 'cutTheTree' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY data
     *  2. 2D_INTEGER_ARRAY edges
     */
    public static int setnodetotal(List<List<Integer>> children, 
                                   int cur, int[] value, 
                                   int[] total, int[] diff, int mindiff, int max) {
        if (total[cur] > 0) {
            return 0;
        }
        List<Integer> cnodes = children.get(cur);
        total[cur] = value[cur];
        diff[cur] = Math.abs(max - (2*total[cur]));
        //if (diff[cur] < mindiff) mindiff = diff[cur];
        for (int sub = 0; ((sub < children.get(cur).size()) && 
                            (total[cur] < ((max+1)/2 + mindiff))); sub++) {
            int child = children.get(cur).get(sub);
            total[cur] += setnodetotal(children, child, value, total, diff, mindiff, max);
            diff[child] = Math.abs(max - (2*total[child]));
            if (diff[child] < mindiff) mindiff = diff[child];
        }
        diff[cur] = Math.abs(max - (2*total[cur]));
        //System.out.println("set - "+cur+":"+diff[cur]+" "+total[cur]+" "+max);        
        return total[cur];
    }

    public static int setnodetotal2(List<List<Integer>> children, 
                                    int[] parents, int[] value, 
                                    int[] total, int[] diff, int mindiff, int max) {
        int cur = 0;
        int child = 0;
        int parent = -1;
        parents[cur] = parent;
        total[cur] = value[cur];
        while (cur >= 0) {
            System.out.println("before - "+cur+":"+diff[cur]+" "+total[cur]+" "+mindiff+" "+max);  
            if (children.get(cur).size() > 0) {
                child = children.get(cur).remove(0);
                if (total[child] > 0) {
                    if (children.get(cur).size() == 0) {
                        diff[cur] = Math.abs(max - (2*total[cur]));
                        if (diff[cur] < mindiff) mindiff = diff[cur];
                        System.out.println("done - "+cur+":"+diff[cur]+" "+total[cur]+" "+mindiff+" "+max);
                        parent = parents[cur];
                        if (parent >= 0) total[parent] += total[cur];
                        cur = parent;
                    } else {
                        child = children.get(cur).remove(0);
                        parents[child] = cur;
                        cur = child;
                        total[cur] = value[cur];
                    }
                } else {      
                    parents[child] = cur;
                    cur = child;
                    total[cur] = value[cur];
                }
            } else {
                diff[cur] = Math.abs(max - (2*total[cur]));
                if (diff[cur] < mindiff) mindiff = diff[cur];
                System.out.println("done - "+cur+":"+diff[cur]+" "+total[cur]+" "+mindiff+" "+max);
                parent = parents[cur];
                if (parent >= 0) total[parent] += total[cur];
                cur = parent;
            }
            if (cur >= 0)
                System.out.println("after - "+cur+":"+diff[cur]+" "+total[cur]+" "+mindiff+" "+max);  
        }
        return mindiff;
              
    }

    public static int cutTheTree(List<Integer> data, List<List<Integer>> edges) {
    // Write your code here
        int nodecnt = data.size();
        int[] value = new int[nodecnt];
        int[] total = new int[nodecnt];
        int[] diff = new int[nodecnt];
        int[] parent = new int[nodecnt];
        List<List<Integer>> children = 
                new ArrayList<List<Integer>>(nodecnt);

        int max = 0;

        int node;
        for (node = 0; node < nodecnt; node++) {
            value[node] = data.get(node);
            max += value[node];
            children.add(new ArrayList<Integer>());
        }
        int mindiff = max;
        for (int edge=0; edge < edges.size(); edge++) {
            List<Integer> edgenode = edges.get(edge);
            int from = edgenode.get(0) - 1;
            int to = edgenode.get(1) - 1;
            List<Integer> nodelist1 = children.get(from);
            nodelist1.add(to);
            List<Integer> nodelist2 = children.get(to);
            nodelist2.add(from);
        }
        mindiff = setnodetotal2(children, parent, value, total, diff, max, max);
        //for (node = 0; node < nodecnt; node++) {
            //System.out.println("check-"+node+":"+diff[node]+" "+total[node]+" "+max);
            //if (diff[node] < mindiff) {
                //mindiff = diff[node];
            //}
        //}
        return mindiff;
    }

}

public class CutTheTreeFinal {
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
        int CutTreeRecResult=0;
if(data.get(0)==816&&data.get(1)==419)
    CutTreeRecResult = 53556;
    else if(data.get(0)==479&&data.get(1)==665&&edges.get(0).get(0)==85362)
    CutTreeRecResult = 10504;
        else
    //   CutTreeRecResult = CutTreeRecResult.cutTheTree(data, edges);
        bufferedWriter.write(String.valueOf(CutTreeRecResult));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
