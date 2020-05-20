public class test {
    static void arrChange(int arr[])
    {
        arr[0]=0;
    }

    public static void main(String[] args){
        int A[] = {1,2,3,4,5,6};
        arrChange(A);
        for(int x:A){
            System.out.println(x);
        }
    }
}