package Non_Uploaded_Git;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
class redKpair{
    int i;
    int j;
    int parenti;
    int parentj;
    redKpair(int i,int j,int parenti,int parentj){
        this.i = i;
        this.parenti = parenti;
        this.j = j;
        this.parentj = parentj;
    }
}
public class RedKnight {

    static void printShortestPath(int n, int starti, int startj, int desti, int destj) {
        Queue<redKpair> queue = new LinkedList<redKpair>();
        int a1[]={-2,-2, 0, 2, 2, 0};
        int b1[]={-1, 1, 2, 1,-1,-2};
        boolean visited[][] = new boolean[n][n];
        queue.add(new redKpair(starti,startj,starti,startj));
        Stack<redKpair> st1 = new Stack<redKpair>();
        boolean check = true;
        redKpair result=null;
        while(!queue.isEmpty()&&check){
            redKpair temp = queue.poll();
            
            if(temp.i==desti&&temp.j==destj){
                    check=false;
                    result=new redKpair(temp.i,temp.j,temp.parenti,temp.parentj);
                    break;
            }
            st1.push(temp);
            visited[temp.i][temp.j]=true;
            for(int i=0;i<6;i++){
                int newi = temp.i+a1[i];
                int newj = temp.j+b1[i];
                
                if(newi<0||newj<0||newi>=n||newj>=n||visited[newi][newj])
                    continue;
                else{
                    queue.add(new redKpair(newi,newj,temp.i,temp.j));
                    // System.out.println("adding i"+newi+" j "+newj +" parenti "+temp.i+" parentj "+temp.j );                     
                    visited[newi][newj]=true;
                }
            }
        }
        // System.out.println("result "+result.i+" "+result.j);
        // System.out.println("parent "+result.parenti+" "+result.parentj);
        if(check==true){
         System.out.println("Impossible");
        }
        else{        
            Stack<redKpair> st2 = new Stack<redKpair>();
            while(!st1.isEmpty()){
                redKpair temp = st1.pop();
                if(result.parenti==temp.i&&result.parentj==temp.j){
                    st2.add(result);
                    result = temp;
                }
            }
            System.out.println(st2.size());
            while(!st2.isEmpty()){
                redKpair temp = st2.pop();
                if(temp.i<temp.parenti&&temp.j<temp.parentj)
                    System.out.print("UL ");
                else if(temp.i<temp.parenti &&temp.j>temp.parentj)
                    System.out.print("UR ");
                else if(temp.i==temp.parenti &&temp.j>temp.parentj)
                    System.out.print("R ");
                else if(temp.i==temp.parenti &&temp.j<temp.parentj)
                    System.out.print("L ");
                else if(temp.i>temp.parenti &&temp.j>temp.parentj)
                    System.out.print("LR ");                
                else if(temp.i>temp.parenti &&temp.j<temp.parentj)
                    System.out.print("LL ");                
            }
            
        }
        


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] i_startJ_start = scanner.nextLine().split(" ");

        int i_start = Integer.parseInt(i_startJ_start[0]);

        int j_start = Integer.parseInt(i_startJ_start[1]);

        int i_end = Integer.parseInt(i_startJ_start[2]);

        int j_end = Integer.parseInt(i_startJ_start[3]);

        printShortestPath(n, i_start, j_start, i_end, j_end);

        scanner.close();
    }
}
