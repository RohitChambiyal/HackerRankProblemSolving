package Data_Structure;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
class moonnodes{
    int data;
    Vector<Integer> adj;
    moonnodes(){
        adj = new Vector<Integer>();
    }
}
public class JourneyToTheMoon {
    static HashSet<Integer> hash1;
    static int count;

    static void dfs(Vector<moonnodes> graph,int i){
        if(hash1.contains(i))   return;
        count++;
        hash1.add(i);
        moonnodes temp = graph.get(i);
        for(int j=0;j<temp.adj.size();j++){
            dfs(graph,temp.adj.get(j));
        }
    }

    static long journeyToMoon(int n, int[][] astr) {
        Vector<moonnodes> graph = new Vector<moonnodes>();
        int distinct=0;
        count =0;
        hash1 = new HashSet<Integer>();
        HashSet<Integer> hash2 = new HashSet<Integer>();
        for(int i=0;i<n;i++){
            graph.add(new moonnodes());
        }
        for(int i=0;i<astr.length;i++){
            graph.get(astr[i][0]).adj.add(astr[i][1]);
            graph.get(astr[i][1]).adj.add(astr[i][0]);
        }
        int all=0;
        Vector<Integer> v1 =new Vector<Integer>();
        for(int i=0;i<astr.length;i++){
            if(!hash1.contains(astr[i][0])){
                distinct++;
                dfs(graph,astr[i][0]);
                v1.add(count);
                all+=count;
                count=0;
            }
        }
        // System.out.println("vector "+v1);
        // System.out.println("distinct "+distinct);
        int single = n-all;
         
        // System.out.println("single "+single);
        long sum=0;
        
        for(int i=0;i<v1.size();i++){
            for(int j=i+1;j<v1.size();j++){
               sum+= v1.get(i)*v1.get(j);
            //    System.out.println("sum done"+sum);
            }
            sum+= v1.get(i)*single;
        }
        // System.out.println("sum "+sum);
        single--;
        // System.out.println("single "+single);
        // int x=0;
        long sumx = (long)((long)single*((long)single+1))/2;
        // System.out.println("sumx "+sumx);
        // while(single>0){
        //     sum+=single;
        //     x+=single;
        //     System.out.println(single+" ");
        //     single--;
        // }
        // System.out.println(" x "+x);
        sum+= sumx;
        return sum;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] np = scanner.nextLine().split(" ");

        int n = Integer.parseInt(np[0]);

        int p = Integer.parseInt(np[1]);

        int[][] astronaut = new int[p][2];

        for (int i = 0; i < p; i++) {
            String[] astronautRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int astronautItem = Integer.parseInt(astronautRowItems[j]);
                astronaut[i][j] = astronautItem;
            }
        }

        long result = journeyToMoon(n, astronaut);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
