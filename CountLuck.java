package Non_Uploaded_Git;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountLuck {

    static String[] arr;
    static int row,col;
    static int m,n;
    static int cc;
    static boolean visited[][];
    static void check(int i,int j,int count){
        // System.out.println("main fun i "+i+" j "+j+" count "+count);
        if(cc!=-1){
            // System.out.println("entered cc");
            return;
        }
        if(i<0||j<0||i>=row||j>=col){
            // System.out.println("entered constraints");
            // System.out.println("i "+i+" j "+j+" row "+row+" col "+col);
            return;
        }
        if(visited[i][j]||arr[i].charAt(j)=='X'){
            
            // System.out.println("entered visited");
            return;
        }
        // System.out.println("entered i "+i+" j "+j);
        if(arr[i].charAt(j)=='*'){ 
            cc=count;
            return;
            // System.out.println("entered");
        }
        visited[i][j]=true;
        int total=0;
        if(j<col-1&&!visited[i][j+1]&&arr[i].charAt(j+1)!='X')
            total++;
        if(j>0&&!visited[i][j-1]&&arr[i].charAt(j-1)!='X')
            total++;
        if(i<row-1&&!visited[i+1][j]&&arr[i+1].charAt(j)!='X')
            total++;
        if(i>0&&!visited[i-1][j]&&arr[i-1].charAt(j)!='X')
            total++;
            // if(i==0&&j==1){
            //     System.out.println("0 0 "+visited[0][0] +" " +arr[0].charAt(0));
            //     System.out.println("0 2 "+visited[0][2] +" "+arr[0].charAt(2));
            // }
        if(total>1){
            check(i,j+1,count+1);
            check(i+1,j,count+1);
            check(i-1,j,count+1);
            check(i,j-1,count+1);
        }
        else{
            check(i,j+1,count);
            check(i+1,j,count);
            check(i-1,j,count);
            check(i,j-1,count);    
        }
        // visited[i][j]=false;
    }
    static String countLuck(String[] matrix, int k) {
        arr = matrix;
        
        row = matrix.length;
        // System.out.println("row "+row);
        col = matrix[0].length();
        // System.out.println("col "+col);
        visited = new boolean[row][col];
        boolean bcheck=false;
        cc=-1;
        for(int i=0;i<row;i++){
            if(bcheck)
                break;
            for(int j=0;j<col;j++){
                if(matrix[i].charAt(j)=='M'){
                    m=i;n=j; bcheck=true;break;
                    
                }
            }
        }
        
        check(m,n,0);
        // System.out.println(cc);
        if(cc==k)
            return "Impressed";
        else
            return "Oops!";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            String[] matrix = new String[n];

            for (int i = 0; i < n; i++) {
                String matrixItem = scanner.nextLine();
                matrix[i] = matrixItem;
            }

            int k = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String result = countLuck(matrix, k);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
