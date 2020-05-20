package Data_Structure;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class MedianUpdates {
    static void printMid(Vector<Integer> v1) {
        int vsize = v1.size();
        //System.out.println("Vector "+v1);
        if(vsize==0){
            System.out.println("Wrong!");
            return;
        }
        if(vsize%2!=0){
            System.out.println(v1.get(vsize/2));
            return;
        }
        else{
            
            long x= (long)v1.get(vsize/2);
            long y = (long)v1.get(vsize/2 -1);
            
            if((x+y)%2==0){
            System.out.println((x+y)/2);
            }
            else{
                double x1=(double)((double)x/(double)2);
                double y1=(double)((double)y/2);
                //System.out.println("x "+x+" x1 "+x1+" y "+y+" y1 "+y1);
                System.out.printf("%.1f",(x1+y1));
                System.out.println();
            }
        }
    }
    static void median(String a[],int x[]) {
       Vector<Integer> v1 = new Vector<Integer>();
       int times = a.length;
       for(int i=0;i<a.length;i++){
          // System.out.println("Calling "+ i);
           if(a[i].equals("r")){
                int index = Collections.binarySearch(v1,x[i]);
                if(index<0){
                    System.out.println("Wrong!");
                }
                else{
                    v1.remove(index);
                    printMid(v1);
                }
           }
           else if(a[i].equals("a")){
               int index = Collections.binarySearch(v1,x[i]);
               if(index>=0){
                   v1.add(index,x[i]);
                   printMid(v1);
               }
               else{
                   index +=1;
                   index = Math.abs(index);
                   v1.add(index,x[i]);
                   printMid(v1);
               }
           }

       }
       
    }
    
    public static void main(String [] args){
        Scanner s  = new Scanner(System.in);
        int n = s.nextInt();
        String[] str = {"a","a","a","r","a","r"};
        int [] arr = {
         -2147483648
         ,-2147483648
      ,-2147483647 , -2147483648
         , 2147483647
        , -2147483648};
    median(str, arr);

        /*

a   0    -2147483648
a   1    ,-2147483648
a   2    ,-2147483647
r   3    , -2147483648
a   4    , 2147483647
r   5    , -2147483648};
            
    -2147483648
    -2147483648
    -2147483648
    -2147483647.5
    -2147483647
    0



    Vector [-2147483648, -2147483647]
           [-2147483647, 2147483647]
        */

    }
}