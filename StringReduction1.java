package Non_Uploaded_Git;

import java.util.Scanner;

public class StringReduction1 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- !=0){
            s.nextLine();
            String str  = s.nextLine();
            char arr[] =str.toCharArray();
            int x =findmin(arr,0,0);
            System.out.println("count "+x);
            // if(x==0)
            System.out.println("Result is "+(str.length()-x));
            // else{ 
            //     x = str.length()-x-1;
            //     System.out.println("Result is "+x);
            // }
        }
    }

    private static int findmin(char[] arr,int index, int count) {
        // if(index<0)
        //     return -1;
        int i=index;
        boolean check = false;
        
        while(i>=0&&i<arr.length-1&&arr[i]==arr[i+1])
                i++;
            if(i>=0&&i<arr.length-1){
                check = true;
                int min1 = findmin(arr,i+1,count);
                int min2=0;
                char first=arr[i];
                char second = arr[i+1];
                if(arr[i]=='a'&&arr[i+1]=='c'||arr[i]=='c'&&arr[i+1]=='a'){
                    arr[i]='b';
                    arr[i+1]='b';
                    min2= findmin(arr,i,count+1);
                    arr[i]=first;
                    arr[i+1]=second;
                }
                else if(arr[i]=='b'&&arr[i+1]=='c'||arr[i]=='c'&&arr[i+1]=='b'){
                    arr[i]='a';
                    arr[i+1]='a';
                    min2 = findmin(arr,i,count+1);
                    arr[i]=first;
                    arr[i+1]=second;
                }
                else if(arr[i]=='a'&&arr[i+1]=='b'||arr[i]=='b'&&arr[i+1]=='a'){
                    arr[i]='c';
                    arr[i+1]='c';
                    min2 = findmin(arr,i,count+1);
                    arr[i]=first;
                    arr[i+1]=second;
                }
                count = Math.max(min1,min2);        
            }
            System.out.println(String.valueOf(arr)+" count "+count+ " index "+index);
            // if(i<arr.length-1&&arr[i]!=arr[i+1])
            //     return count+1;
            if(i==arr.length-1&&arr[index]!=arr[0]){
                int counta=0;
                int countb=0;
                int countc=0;
                System.out.println("Entered "+String.valueOf(arr));
                // for(int x=0;x<arr.length;x++){
                //     if(arr[i]=='a')
                //         counta++;
                //     else if(arr[i]=='b')
                //         countb++;
                //     else
                //         countc++;
                // }
                // if(counta==0){
                //     int min =Math.min(countb,countc);
                //     System.out.println(count+min+1);
                //     return count+min+1;
                // }

                // if(countb==0){
                //     int min =Math.min(counta,countc);
                //     System.out.println(count+min+1);
                //     return count+min+1;
                // }

                // if(countc==0){
                //     int min =Math.min(countb,counta);
                //     System.out.println(count+min+1);
                //     return count+min+1;
                // }

                return count+1;
            }
            
            return count;
    }

    // private static void check(String str, int i) {

    // }
}