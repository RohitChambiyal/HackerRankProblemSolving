import java.util.Vector;

public class AbsolutePermutationNonRecursive {
    static int[] checkmin(int n,int diff){
        int[] result = new int[n];
        int[] neg = new int[1];
        neg[0] = -1;
        if(diff==0){
            for(int i=0;i<n;i++){
                result[i]=i+1;
            }
            return result;
        }
        
        int s = 1;
        int plus,minus ;
        while(s<=n){
            plus = s+diff;
            for(int i=1;i<=diff;i++){
                if(s>n) break;
                if(plus>n)
                    return neg;
                result[s-1] = plus;
                plus++;
                s++;
            }
            minus = s-diff;
            for(int i=1;i<=diff;i++){
                if(s>n) break;
                if(minus>n)
                    return neg;
                result[s-1]= minus;
                minus++;
                s++;
            }
        }
        return result;
        
    }

    public static void main(String[] args){
        int n=9528;
        int k = 794;
        int arr[];
        arr=checkmin(n,k);
        for(int i:arr)
            System.out.println(i+" ");

    }
}