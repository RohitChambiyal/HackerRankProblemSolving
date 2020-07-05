package Non_Uploaded_Git;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ModifiedFibbo {

    // Complete the fibonacciModified function below.
    static long[] fib;
    static BigInteger fibonacciModified(int t1, int t2, int n) {
        
        String st1 = ""+ t1;
        String st2 =""+t2;
        BigInteger one = new BigInteger(st1);
        BigInteger two = new BigInteger(st2);
        if(n==1)    
            return one;
        if(n==2)
            return two;
        
        BigInteger third = two.multiply(two).add(one);
        for(int i=0;i<n-2;i++){
            third = two.multiply(two).add(one);
            one = two;
            two = third;
        }
        return third;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] t1T2n = scanner.nextLine().split(" ");

        int t1 = Integer.parseInt(t1T2n[0]);

        int t2 = Integer.parseInt(t1T2n[1]);

        int n = Integer.parseInt(t1T2n[2]);

        BigInteger result = fibonacciModified(t1, t2, n);

        bufferedWriter.write(result.toString());
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
