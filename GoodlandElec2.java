import java.util.Scanner;

public class GoodlandElec2 {
    static int pylons2(int k, int[] arr) {
       int n = arr.length;
       int count =0;
        for(int i=0;i<n;i++){
            
        }


            return count;
        }


    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int arr[] = new int[t];
        int k = s.nextInt();
        for(int i=0;i<t;i++)
            arr[i] = s.nextInt();
            System.out.println(pylons2(k, arr));
    }
}



/*abstract
Test case 1:

100 20
0 0 1 0 0 1 0 0 1 1 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 0 1 0 0 0 1 0 0 1 0 0 0 0 0 0 1 0 0 1 0 0 0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 1 0 0 0 1 0 0 0 0 0 1 0 1 1 0 0 0 0 1 0 0 0 0


Test Case 2:

100 20
0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0


*/