import java.util.Arrays;

public class binarySearchCheck {
    public static int bsearch(int arr[], int target,int start,int end){
        if(start<end){   
        int mid = (start+end)/2;
        if(arr[mid]==target)
            return mid;
        else if(arr[mid]>target)
            return bsearch(arr,target,start,mid);
        else 
            return bsearch(arr,target,mid+1,end);
        }
        System.out.println("not found");
            return -(start+(end-start)/2);
        
    }
    public static void main(String[] args){
        int arr[] = {1,3,4,8,11,13};
        Arrays.sort(arr);
        //System.out.println(bsearch(arr, 7,0,arr.length-1));
        int arr2[] = {5,8 ,14};
        int nearestindex = Arrays.binarySearch(arr2,6);
        nearestindex = Math.abs((nearestindex+1));
        System.err.println(nearestindex);

        

    }
}