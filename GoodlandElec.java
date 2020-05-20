import java.util.Scanner;

public class GoodlandElec {
    static int pylons(int k, int[] arr) {
        int n = arr.length;
        int arr2[]= new int[n];
        int count=0;
        k--;
        int c=0;
        int prev=-1;
        for(c=0;c<n-k;){
            System.out.println("c at "+c);
            if(arr[c]==1){
                arr2[c]=1;
                count++;
                prev = c;
                c=c+k+1;
            }
            else{
                int end = c+k;
                boolean check = false;
                int a=0;
                while(a<k){
                    if(arr[end-a]==1){
                        check = true;
                        count++;
                        arr2[end-a]=1;
                        System.out.println("break "+(end-a));
                        prev = c;
                        c=end-a+k+1;
                        break;
                    }
                    a++;
                }
                if(check ==false)
                    return -1;
            }
        }
        if(c>=n)
            return count;
        System.out.println("c loc "+ c +" count "+count);
        if(c==(n-1)&&arr[c]==1)
            return ++count;
        if(prev<0)
            prev =0;
        for(int i=n-1;i>prev;i--){
            boolean check = false;
            if(arr2[i]==0&&n-k>=0)
                if(arr[n-k-1]==1)
                    return ++count;
                if(arr[n-k-1]!=1){
                    int a = 1;
                    while(a<k){
                        if(arr[n-a-1]==1){
                            check = true;
                            count++;
                            return count;
                        }
                    a++;
                }
                if(check ==false)
                    return -1;
            }
                
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
            System.out.println(pylons(k, arr));
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