import java.util.Scanner;

public class Candies {
/*

static long candies(int n, int[] arr) {
        if(n==1)
            return (long)(1);
        int result[] = new int[n];
        if(result[0]>result[1])
            result[0]=2;
        else{
            result[0]=1;
        }
        for(int i=1;i<n;i++){
            if(arr[i]>arr[i-1])
                result[i]=result[i-1]+1;
            else
                result[i]=1;
        }
        for(int i=n-2;i>=0;i--){
            if(arr[i]>arr[i+1]&&result[i]<=result[i+1])
                result[i]=result[i+1]+1;
             
        }
        
        long sol=0;
        for(int x:result){
            sol+=x;
        }
        return sol;

    }

*/
    static long findcandies(int n, int[] arr) {
        if(n==1)
            return (long)(1);
        int result[] = new int[n];
        if(result[0]>result[1])
            result[0]=2;
        else{
            result[0]=1;
        }
        for(int i=1;i<n;i++){
            if(arr[i]>arr[i-1])
                result[i]=result[i-1]+1;
            else
                result[i]=1;
        }
        int i=n-1;
        while(i>0&&result[i]>=result[i-1]&&arr[i]<arr[i-1]){
            result[i-1]=result[i]+1;
            i--;
        }
        long sol=0;
        for(int x:result){
            sol+=x;
        }
        return sol;

    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n =s.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=s.nextInt();
        }
        long sol = findcandies(n, arr);
        
        System.out.println("Answer "+sol);

        

    }
}

/*

*/