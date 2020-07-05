package Non_Uploaded_Git;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'getWays' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. LONG_INTEGER_ARRAY c
     */
     static long dp[][];
    static long findsum(List<Integer> coins,int sum,int i ){
        if(sum==0)
            return 1;
        if(sum!=0&&i<0)
            return 0;
        if(dp[i][sum]!=0)
            return dp[i][sum];
        if(coins.get(i)<=sum){
            return dp[i][sum]=findsum(coins,sum-coins.get(i),i)+ findsum(coins,sum,i-1);
        }
        else
            return dp[i][sum]=findsum(coins,sum,i-1);
    }

    public static long getWays(int sum, List<Long> coins2) {
        List<Integer> coins = new LinkedList<Integer>();
        for(int i=0;i<coins2.size();i++){
         long x =coins2.get(i);
           coins.add((int)x);
        }
        dp =new long[coins.size()+1][sum+1];
        for(int i=0;i<coins.size()+1;i++){
            dp[i][0]=1;
        }
    int i = coins.size()-1;
    Collections.sort(coins);
    // System.out.println(coins);
    long count = findsum(coins,sum,i);
    return count;
    }

}

public class CoinsChange {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        String[] cTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Long> c = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            long cItem = Long.parseLong(cTemp[i]);
            c.add(cItem);
        }

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        long ways = Result.getWays(n, c);

        bufferedWriter.write(String.valueOf(ways));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
