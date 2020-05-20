package Data_Structure;
import java.util.Scanner;

public class RotateArrayninty {
 
  public static void rotateMatrix(int arr[][],int n){
    for(int i=0;i<n/2;i++){
      for(int j=i;j<n-i-1;j++){
            int temp = arr[i][j];
            arr[i][j] = arr[n-j-1][i];
            arr[n-j-1][i] = arr[n-i-1][n-j-1];
            arr[n-i-1][n-j-1] = arr[j][n-i-1];
            arr[j][n-i-1]=temp;
      }
    }
  }
  public static void printmatrix(int arr[][],int n){
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++)
            System.out.print(arr[i][j]+" ");
        System.out.println();
        }


  }
  public static void main(String[] args)
  {
    Scanner s = new Scanner(System.in);
    int t = s.nextInt();
    while(t--!=0){
      int n = s.nextInt();
      int arr[][] = new int[n][n];
      for(int i=0;i<n;i++){
        for(int j=0;j<n;j++)
          arr[i][j] = s.nextInt();
      }
      rotateMatrix(arr,n);
      printmatrix(arr, n);
    }
  }	
}