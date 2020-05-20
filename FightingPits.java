import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class FightingPits {


    static int findWinner(Vector<Integer>x,Vector<Integer> y,int vx,int vy){
        // if(vx==4&&vy==123){
        //     System.out.println("Entered x "+x);
        //     System.out.println("Entered y "+y);
        // }
        int xlen = x.size();
        int ylen = y.size();
        int intx=0,inty = 0;
        int turn = 0;
        while(intx<xlen && inty < ylen){
//x turn 
            if(turn%2==0){
        //         if(vx==4&&vy==123){
         
        //     System.out.println("Removed y "+y.get(inty));
        // }
                inty+= x.get(intx);
            }
            else{
                intx+=y.get(inty);
            }
            turn++;
        }
        if(intx<xlen)
            return vx;
        else
            return vy;
    }


    static int[] fightingPits(int k, int[][] fighter, int[][] qry) {
        
            Vector teams[] = new Vector[k+1];
            for(int i=0;i<=k;i++){
                teams[i] = new Vector<Integer>();
            }

            Arrays.sort(fighter, new Comparator<int[]>() { 
          @Override              
          public int compare(final int[] a,final int[] b) { 
            if (a[0] < b[0]) 
                return 1; 
            else if(a[0]>b[0])
                return -1; 
            else
                return 0;
          } 
        });

            Vector<Integer> result = new Vector<Integer>();
            for(int i=0;i<fighter.length;i++){
                int strength = fighter[i][0];
                int team = fighter[i][1];
                teams[team].add(strength);
            }
       
        
        
            // for(int i=0;i<=k;i++){
            //     Collections.sort(teams[i]);
            // }
            // System.out.println(teams[123]);
            // System.out.println(qry.length+" \t "+qry[0].length+" length ends");
            // System.out.print(qry[0][0]+" \t ");
            // System.out.println(qry[0][1]);
//inst^ns
            for(int i=0;i<qry.length;i++){
                int what = qry[i][0];
                int x = qry[i][1];
                int y = qry[i][2];
        //Addition        
                if(what==1){
                    teams[y].add(0,x);
                }
                else if(what==2){
                    int r = findWinner(teams[x],teams[y],x,y);
                    result.add(r);
                    // if(x==4&&y==123){
                    //     System.out.println("After execution ");
                    //     System.out.println("teams x "+teams[x]);
                    //     System.out.println("teams y "+teams[y]);
                    //     System.out.println("result "+r+"\n\n");
                    // }

                }
            }
            int arr[] = new int[result.size()];
            for(int i=0;i<result.size();i++){
                arr[i] = result.get(i);
            }
        return arr;
    }


    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int fighterlen =s.nextInt();
        int teams = s.nextInt();
        int querieslen = s.nextInt();
        int fighters[][] = new int[fighterlen][2];
        int queries[][] = new int[querieslen][3];
        for(int i=0;i<fighterlen;i++){
            fighters[i][0]=s.nextInt();
            fighters[i][1]= s.nextInt();
        }
        for(int i=0;i<querieslen;i++){
            queries[i][0]=s.nextInt();
            queries[i][1]=s.nextInt();
            queries[i][2]=s.nextInt();
        }
        int arr[];
        arr =fightingPits(teams,fighters,queries);
        for(int i=0;i<arr.length;i++);

    }
}
