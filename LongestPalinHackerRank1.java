package Non_Uploaded_Git;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LongestPalinHackerRank1  {
    static int max;
    static void finding(int i,int []b,int arr[]){
        if(i!=b.length){
         
                arr[i]=1;
                finding(i+1,b,arr);
                arr[i]=b[i];
                finding(i+1,b,arr);
        }
        else{
            int sum=0;
            // System.out.print(arr[0]+" ");
            for(int j=1;j<b.length;j++){
                // System.out.print(arr[j]+" ");
                sum+= Math.abs(arr[j]-arr[j-1]);
            }
            // System.out.println();
            max = Math.max(sum,max);
        }
    }
    static int cost(int[] b) {
        int n= b.length;
        int arr[] = new int[n];
        int i=0;
        max=0;
        finding(i,b,arr);
        return max;

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
