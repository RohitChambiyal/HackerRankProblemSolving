import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Bomberman {

    // Complete the bomberMan function below.
    static String[] bomberMan(int n, String[] grid) {
        
        int row = grid.length;
        int m = grid[0].length();
        String[] grid2 = new String[row];
        String[] grid3 = new String[row];
        String[] grid4 = new String[row];
        if(n==1||n==0){
            return grid;
        }
        //n==2
        String s="";
            for(int i=0;i<m;i++){
                s +="O"; 
            }
            for(int i=0;i<row;i++)
                grid2[i]=s;
        if(n==2)
            return grid2;
        
            char[][] arr = new char[row][m];
            for(int i=0;i<row;i++) {
                for(int j=0;j<m;j++){
                    char x= grid[i].charAt(j);
                    if(x=='O')
                        arr[i][j] = 'X';
                    else
                        arr[i][j] = 'O';
                }
            }

            
for(int i=0;i<row;i++) {
                for(int j=0;j<m;j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
                System.out.println();


            for(int i=0;i<row;i++) {
                for(int j=0;j<m;j++){
                    if(arr[i][j]=='X'){
                        arr[i][j]='.'; 
                        System.out.println("---------Start ("+i+","+(j)+")");
   
                        if(j+1<m&&arr[i][j+1]!='X'){
                            System.out.println("Dot ("+i+","+(j+1)+")");
                            arr[i][j+1] ='.'; }
                        if( j-1>=0&&arr[i][j-1]!='X'){
                            arr[i][j-1] ='.'; 
                            System.out.println("Dot ("+i+","+(j-1)+")");}
                        if( i+1<row&&arr[i+1][j]!='X'){ 
                            arr[i+1][j] ='.';
                            System.out.println("Dot ("+(i+1)+","+j+")");
                        }
                        if(i-1>=0&&arr[i-1][j]!='X'){
                            arr[i-1][j] ='.';
                            System.out.println("Dot ("+(i-1)+","+j+")");
                        }
                    }
                }
            }
            
            for(int i=0;i<row;i++) {
                for(int j=0;j<m;j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }


            for(int i=0;i<row;i++){
                String s1 ="";
                for(int j=0;j<m;j++){
                    s1+=arr[i][j];
                }
                grid3[i]=s1;
            }


///GRID 4


 char[][] arr2 = new char[row][m];
            for(int i=0;i<row;i++) {
                for(int j=0;j<m;j++){
                    char x= grid3[i].charAt(j);
                    if(x=='O')
                        arr2[i][j] = 'X';
                    else
                        arr2[i][j] = 'O';
                }
            }
            for(int i=0;i<row;i++) {
                for(int j=0;j<m;j++){
                    if(arr2[i][j]=='X'){
                        arr2[i][j]='.'; 
                        System.out.println("---------Start ("+i+","+(j)+")");
   
                        if(j+1<m&&arr2[i][j+1]!='X'){
                            System.out.println("Dot ("+i+","+(j+1)+")");
                            arr2[i][j+1] ='.'; }
                        if( j-1>=0&&arr2[i][j-1]!='X'){
                            arr2[i][j-1] ='.'; 
                            System.out.println("Dot ("+i+","+(j-1)+")");}
                        if( i+1<row&&arr2[i+1][j]!='X'){ 
                            arr2[i+1][j] ='.';
                            System.out.println("Dot ("+(i+1)+","+j+")");
                        }
                        if(i-1>=0&&arr2[i-1][j]!='X'){
                            arr2[i-1][j] ='.';
                            System.out.println("Dot ("+(i-1)+","+j+")");
                        }
                    }
                }
            }
           for(int i=0;i<row;i++){
                String s1 ="";
                for(int j=0;j<m;j++){
                    s1+=arr2[i][j];
                }
                grid4[i]=s1;
            }
            
        if(n==3)
            return grid3;
        if((n-1)%4==0)
            return grid4;
        if((n+1)%4==0){
            return grid3;
        }
        else if(n%2==0)
            return grid2;
        else
            return grid;
        

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
	/*	
Input Case:

    6 7 5

    .......

    ...O.O.

    ....O..

    ..O....

    OO...OO

    OO.O...			



Output:

    .......

    ...O.O.

    ...OO..

    ..OOOO.

    OOOOOOO

    OOOOOOO

*/       
	}
}











