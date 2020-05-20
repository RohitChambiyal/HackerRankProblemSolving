import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Matrix_Layer_Rotation {
    // Complete the matrixRotation function below.
    static void matrixRotation(List<List<Integer>> matrix, int times) {
        int row = matrix.size();
        
        int col = matrix.get(0).size();
        int temp[] = new int[row*col];
        int t1=0;
        Arrays.fill(temp,-1);
         
      //  System.out.println("Hello");
        matrixRotationutil(matrix,times,0,0,row,col,temp,t1);
      //  System.out.println("After all");
 for(int i=0;i<row;i++){
            for( int  j=0;j<col;j++){
                System.out.print(matrix.get(i).get(j)+" ");
            }
            System.out.println();
        }

    }


    static void matrixRotationutil(List<List<Integer>> matrix, int time,int initi, int initj,int row, int col,int temp[],int t1) {
        int times = time;
     // System.out.println("\n----------------Called Util-------------");
      //  System.out.println(" initi "+initi+" initj "+initj+" row "+row+" col "+col);
        if(initi>=row||initj>=col){
       //     System.out.println("BROKEN POINT initi "+initi+" initj "+initj+" row "+row+" col "+col);
            return;
        }
        int number = 2*(row-initi+col-initj-2);
     //   System.out.println("Old times "+times+" number "+number );
        times = times%number;
        if(times ==0){
                           matrixRotationutil(matrix,time,initi+1,initj+1,row-1,col-1,temp,t1);

        }
         int t = t1;
      //   System.out.println("times "+ times+" number "+number +" tsize "+t);
        int i=initi; int j=initj;
        while(times>0){
         while(i<row&&j<col-1&&times>0){
             j++;times--;
         }
         if(times>0){
             while(i<row-1&&times>0){
                 i++;times--;
             }
             while(j>initj&&times>0){
                 j--;times--;
             }
             while(i>initi&&times>0){
                 i--;times--;
             }
         }
        }
        int field=0;
        
          if(j>=col-1) field = 2;
        if(i>=row-1) field = 3;
      
        if(j<=initj)field = 4;
        int a=i,b=j;
      //  System.out.println(" initi "+initi+" row "+row+" initj "+initj+ " col "+ col);
     //   System.out.println(" i "+i+" j "+j+" field "+field+ " ");
         
        
         while((field ==0||field==1)&&i<row-1&&j<col-1){
            // System.out.println("field 1");
             temp[t1++]= matrix.get(i).get(j);
             j++;
         }
           
             while((field ==0||field==2)&&i<row-1 ){
              //   System.out.println("field 2");
                 if(j>=col){
                     j--;
                     field =0;
                     break;
                 }
                 temp[t1++] = matrix.get(i).get(j);
                 i++;
                 field =0;
             }
             while((field ==0||field==3)&&j>initj ){
                 // System.out.println("field 3");
                 if(j>=col){
                     j--;
                     field =0;
                     break;
                 }
                 temp[t1++] = matrix.get(i).get(j);
                 j--;
                 field =0;
             }
             //System.out.println("i "+i+ " j "+j+" field "+field);
             while((field ==0||field==4)&&i>initi){
               //   System.out.println("field 4");
                 temp[t1++] = matrix.get(i).get(j);
                 i--;
                 field =0;
             }
               //  System.out.println("exceeded a "+a+" i "+i+" b "+b+" j "+j);

    // if field exceeded.
             if(i!=a||b!=j){
              //   System.out.println("IN");
                
            while((i!=a||b!=j)&&j<col-1){
           //     System.out.println("Again field 1");
                    temp[t1++]= matrix.get(i).get(j);
                    j++;
             }

             while((i!=a||b!=j)&&i<row-1 ){
             //    System.out.println("Again field 2");
                 temp[t1++] = matrix.get(i).get(j);
                 i++;
             }
             while((i!=a||b!=j)&&j>initj ){
            //     System.out.println("Again field 3");
                 temp[t1++] = matrix.get(i).get(j);
                 j--;
             }
             while((i!=a||b!=j)&&i>initi){
           //      System.out.println("Again field 4");
                 temp[t1++] = matrix.get(i).get(j);
                 i--;
             }
         }

// copy to 2D array
          i=initi;j=initj;  
          
           
           
         while(i<row&&j<col-1&&temp[t]!=-1 ){
             matrix.get(i).set(j,temp[t]);t++;
             j++;
         }
         
             while(i<row-1&&temp[t]!=-1  ){
                 matrix.get(i).set(j,temp[t]) ;t++;
                 i++;
             }
             while(j>initj&&temp[t]!=-1 ){
                 matrix.get(i).set(j,temp[t]) ;t++;
                 j--;
             }
             while(i>initi&&temp[t]!=-1 ){
                 matrix.get(i).set(j,temp[t]) ;t++;
                 i--;
             }
      /*  //System.out.println("Temp");
          //  for(int x:temp){
            //     System.out.print(x+" ");
             //}
            System.out.println("\n     Array    ");
        for(i=initi;i<row;i++){
            for(  j=initj;j<col;j++){
                System.out.print(matrix.get(i).get(j)+" ");
            }
            System.out.println();
        }
      */
                matrixRotationutil(matrix,time,initi+1,initj+1,row-1,col-1,temp,t1);

        }


    public static void main(String[] args) throws IOException {
        List<List<Integer>> matrix = new ArrayList<List<Integer>>();       
        Scanner s = new Scanner(System.in);
        int row = s.nextInt();
        int column = s.nextInt();
        int times = s.nextInt();
        List<Integer> matrixRowItems = new ArrayList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                
                matrixRowItems.add(s.nextInt());
            }
            matrix.add(matrixRowItems);
        }
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        matrixRotation(matrix, times);
      
 
  
    }
}

/* Hackerrank main function:



    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] mnr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(mnr[0]);

        int n = Integer.parseInt(mnr[1]);

        int r = Integer.parseInt(mnr[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] matrixRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> matrixRowItems = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int matrixItem = Integer.parseInt(matrixRowTempItems[j]);
                matrixRowItems.add(matrixItem);
            }

            matrix.add(matrixRowItems);
        }

        matrixRotation(matrix, r);

        bufferedReader.close();
    }

*/

/* Test Case

10 8 40
9718805 60013003 5103628 85388216 21884498 38021292 73470430 31785927
69999937 71783860 10329789 96382322 71055337 30247265 96087879 93754371
79943507 75398396 38446081 34699742 1408833 51189 17741775 53195748
79354991 26629304 86523163 67042516 54688734 54630910 6967117 90198864
84146680 27762534 6331115 5932542 29446517 15654690 92837327 91644840
58623600 69622764 2218936 58592832 49558405 17112485 38615864 32720798
49469904 5270000 32589026 56425665 23544383 90502426 63729346 35319547
20888810 97945481 85669747 88915819 96642353 42430633 47265349 89653362
55349226 10844931 25289229 90786953 22590518 54702481 71197978 50410021
9392211 31297360 27353496 56239301 7071172 61983443 86544343 43779176


//Solution

93754371 53195748 90198864 91644840 32720798 35319547 89653362 50410021
31785927 25289229 10844931 97945481 5270000 69622764 27762534 43779176
73470430 90786953 42430633 96642353 88915819 85669747 26629304 86544343
38021292 22590518 90502426 67042516 54688734 32589026 75398396 61983443
21884498 54702481 17112485 5932542 29446517 2218936 71783860 7071172
85388216 71197978 15654690 58592832 49558405 6331115 10329789 56239301
5103628 47265349 54630910 56425665 23544383 86523163 96382322 27353496
60013003 63729346 51189 1408833 34699742 38446081 71055337 31297360
9718805 38615864 92837327 6967117 17741775 96087879 30247265 9392211
69999937 79943507 79354991 84146680 58623600 49469904 20888810 55349226

*/