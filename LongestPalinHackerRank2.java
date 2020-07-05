package Non_Uploaded_Git;

 
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LongestPalinHackerRank2 {

    // Complete the cost function below.
    static int cost(int[] b) {
        int n = b.length;
        int dp[][] = new int[n][2];
        dp[0][0] = 1;
        dp[0][1] = b[0];
        
        dp[1][0]= Math.max( Math.abs(1-1), Math.abs(1-b[1-1]) );
        
        dp[1][1]= Math.max( Math.abs(b[1]-1) , Math.abs(b[1]-b[1-1])  );
        
        for(int i=2;i<n;i++){
            dp[i][0]= Math.max( Math.abs(1-1)+dp[i-1][0], Math.abs(1-b[i-1])+ dp[i-1][1] );
            // System.out.println(dp[i][0]);
            dp[i][1]= Math.max( Math.abs(b[i]-1)+dp[i-1][0], Math.abs(b[i]-b[i-1])+ dp[i-1][1] );
            // System.out.println(dp[i][1]);

        }
        return Math.max(dp[n-1][0],dp[n-1][1]);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        File f1 = new File("/home/rohit/Desktop/Testcase.txt");
        Scanner s = new Scanner(f1);

        int t = s.nextInt();
        

        for (int tItr = 0; tItr < t; tItr++) {
            int n = s.nextInt();
            System.out.println(t);
            System.out.println(n);
            

            int[] B = new int[n];

            

            for (int i = 0; i < n; i++) {
                
                B[i] = s.nextInt();
            }

            int result = cost(B);

            System.out.println(String.valueOf(result));
            
        }

 
        scanner.close();
    }
}
