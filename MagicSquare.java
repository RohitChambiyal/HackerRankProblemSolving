public class MagicSquare {
    static void magic_Square(int n){
        int magic[][] = new int[n][n];
        int i=n/2;
        int j=n-1;
        for(int number = 1;number<=n*n;){
        //case 1
            if(i==-1&&j==n){
                i=0;
                j=n-2;
            }
        //case 2
            else{
                if(i==-1)
                    i=n-1;
                if(j==n)
                    j=0;
            }
        //case 3
            if(magic[i][j]!=0){
                j-=2;
                i++;
                continue;
            }
            else{
                magic[i][j] = number++;
                j++;
                i--;
            }
        }
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                System.out.print(magic[i][j]+" ");
            }
            System.out.println();
        }
            

    }
    public static void main(String args[]){
        int n =3;
        magic_Square( n);
    }
    
}