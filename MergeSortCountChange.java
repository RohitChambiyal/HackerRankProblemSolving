package Non_Uploaded_Git;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MergeSortCountChange {
    static long count;
    static void merging(int[] arr, int left,int mid, int right){
        int leftmid[] = new int[mid-left+1];
        int midright[] = new int[right-mid];
        int a=0;
        int b=0;
        for(int i=left;i<=mid;i++)
            leftmid[a++] = arr[i];
        for(int i=mid+1;i<=right;i++)
            midright[b++] =arr[i];
        a=0;b=0;
        int left2= left;
        while(a<leftmid.length&&b<midright.length){
            if(leftmid[a]<=midright[b]){
                arr[left++]=leftmid[a++];
            }
            else{
                // System.out.println("Added "+midright[b]);
                count+=(mid+1)-(left2+a);
                arr[left++] = midright[b++];
               
            }
        }
        while(a<leftmid.length){
            arr[left++] = leftmid[a++];
        }
        while(b<midright.length){
            arr[left++] = midright[b++];
        }
        
    }
    static void mergeSort(int arr[], int left, int right){
        if(left<right){
            int mid = left + (right-left)/2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);
            merging(arr,left,mid,right);
        }
    }
    static long countInversions(int[] arr) {
        count=0;
        mergeSort(arr,0,arr.length-1);
        // for(int x:arr)
        //     System.out.println(x);
        return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = countInversions(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
