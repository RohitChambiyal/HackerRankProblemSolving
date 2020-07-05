package Non_Uploaded_Git;

import java.util.Vector;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class StoneDivision {
    static HashMap<Long, Long> dp;
    static long stoneRecur(long pile, long[] values){
        if(pile==0||pile==1)
            return 0;
        if(dp.containsKey(pile))
            return dp.get(pile);
        long max =0;
        for(long x: values){
            if(pile%x !=0 || x==pile)
                continue;
            long sum=0;
            long nos = pile/x;
            sum += stoneRecur(x,values)*nos;
            sum+=1;
            max = Math.max(sum,max);
        }
        dp.put(pile,max);
        return max;
    }
    static long stoneDivision(long pile, long[] values) {
        dp = new HashMap<Long, Long>();
        return stoneRecur(pile,values);
            
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            long n = Long.parseLong(nm[0]);

            int m = Integer.parseInt(nm[1]);

            long[] s = new long[m];

            String[] sItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < m; i++) {
                long sItem = Long.parseLong(sItems[i]);
                s[i] = sItem;
            }

            long result = stoneDivision(n, s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
