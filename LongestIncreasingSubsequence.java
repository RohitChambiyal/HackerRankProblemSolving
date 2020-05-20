import java.util.Scanner;

public class LongestIncreasingSubsequence {

    static int bSearch(int table[],int start, int end, int check){
        while(end-start>1){
            int mid = start + (end-start)/2;
            if(table[mid]>=check)
                end = mid;
            else
                start = mid;
        }
        return end;

    }
    // Complete the longestIncreasingSubsequence function below.
    static int longestIncreasingSubsequence(int[] arr) {
        int n = arr.length;
        int table[] = new int[n];
        table[0] = arr[0];  // first element same;
        int length= 1;
        for(int i=1;i<n;i++){
            if(table[0]>arr[i]){
                table[0]= arr[i];
            }
            else if(table[length-1]<arr[i]){
                table[length++] = arr[i];
            }
            else{
                //System.out.println("Binary Search on "+arr[i]+" length "+(length-1));
                int index = (bSearch(table,0,length,arr[i]));
                System.out.println("Binary Search on "+arr[i]+" index found "+index);
                table[index] = arr[i];

            }
        }
        return length;

    }

  
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = s.nextInt();
        System.out.println("\n\n\nResult is "+longestIncreasingSubsequence(arr));

    }
}