import java.util.Collections;
import java.util.Vector;

public class Absolutepermutation {

    static boolean permute(int start, int total,int diff, Vector<Integer> result){
        int small,large;
        
            small = start-diff;
            large = diff + start; 

        if(start-1==total){
            return true;
        }
        if(small<0&&large>total){
            return false;
        }

    //    System.out.println("prev start  small "+small+" large"+large);

        if(small>0&&!result.contains(small)){
  //          System.out.println("small");
            result.remove(start);
            result.add(start,small);
            boolean back = permute(start+1,total,diff,result);
            if(back == true)
                return true;
            else{
                result.remove(start);
                result.add(start,0);
            }
        }
        if(large<=total&&!result.contains(large)){
//            System.out.println("large");

            result.remove(start);
            result.add(start,large);
            boolean back = permute(start+1,total,diff,result);
            if(back == true)
                return true;
            else{
                result.remove(start);
                result.add(start,0);
                return false;
            }
        }
        //System.out.println(result);
        //System.out.println("here small "+small+" large"+large);
        return false;
    }
    static int[] checkmin(int n,int diff){
        Vector<Integer> result = new Vector<Integer>();
        for(int i=0;i<=n;i++)
            result.add(-1);
            
        if(diff==0){
            int[] a = new int[n];
            for(int i=0;i<n;i++){
                a[i]=i+1;
            }
            return a;
        }
        
        boolean sol = permute(1,n,diff,result);
        //System.out.println("Returned vector : "+result);
        if(sol){
            int arr[] = new int[n];
            for(int i=0;i<arr.length;i++)
                arr[i] = result.get(i+1);
            return arr;
        } 
        else return(new int[]{-1});
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