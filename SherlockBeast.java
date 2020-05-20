public class SherlockBeast {
    static void decentNumber(int n) {
        //1 2 4 7
        // 1 2 3 4 5 
        if(n==1||n==4||n==2||n==7){
            System.out.println(-1);
            return;
        }
        else if(n==3){
            System.out.println(555);
            return;
        }
        else if(n==5){
            System.out.println(33333);
            return;
        }
        else if(n%3==0){
         
            for(int i=0;i<n;i++)
                System.out.print(5);
            System.out.println();
            return;
        }
        else{
            System.out.println("entered here ");
            int arr[] = new int[n];
            int three5=-1;
            for(int i=0;i<n;i++){
                if(i+2<n){
                    arr[i]=5;
                    arr[i+1]=5;
                    arr[i+2]=5;
                    i+=2;
                    three5=i;
                }
            }
            boolean shifted3=false;
            for(int i=n-1;i>=0;i--){
                if(i-4>0){
                    arr[i]=3;
                    arr[i-1]=3;
                    arr[i-2]=3;
                    arr[i-3]=3;
                    arr[i-4]=3;
                    three5=i-4;
                    i=i-4;
                    shifted3=true;
                }
                if((three5%3==0||three5<0)&&shifted3==true){
                    for(int x:arr)
                        System.out.print(x);
                    System.out.println();
                    return;
                }
                
            }
            if(shifted3!=true){
                System.out.println(-1);
            return;
        }

        }
    }
    public static void main(String[] args){
        int t =10;
        for(int i=1;i<=t;i++){
            System.out.println("start "+i);
            decentNumber(i);
        }
    }
}