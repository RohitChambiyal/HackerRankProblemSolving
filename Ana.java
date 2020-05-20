public class Ana {
    
    static int check(char [][]arr,int i,int j,int x, int times,int n,int m){
        if(i+times>=n||i-times<0||j+times>=m||j-times<0){
//System.out.println("Entered 11 ");

            return x;
        }
        else if(arr[i][j+times]=='B'||arr[i][j-times]=='B'||arr[i+times][j]=='B'||arr[i-times][j]=='B'||arr[i][j+times]=='S'||arr[i][j-times]=='S'||arr[i+times][j]=='S'||arr[i-times][j]=='S')
        {
                                    //  System.out.println("Entered 22 ")
            return x;
        }
        else{                       //     System.out.println("Entered 33 ");

            x += 4;
            x = check(arr,i,j,x,times+1,n,m);
            return x;
        }

    }
    static int twoPluses(String[] grid) {
        int n = grid.length;
        int m = grid[0].length();
        char[][] arr = new char[n][m];
        int mul = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = grid[i].charAt(j);
                if(i!=0&&i!=n-1&&j!=0&&j!=m-1)
                    mul++;
                //System.out.print(arr[i][j]+" ");
            }
               // System.out.println( );
        }
         int maximumarea=Integer.MIN_VALUE;
        for(int f=0;f<mul;f++){
        int maxi=-1;int maxj=-1;
        int area=1;
         for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(arr[i][j]!='B'&&arr[i][j]!='E'){
                      //  System.out.print (arr[i][j]);
                int newarea = check(arr,i,j,1,1,n,m);
                if(area<newarea){
                    maxi = i;maxj = j;
                    area=newarea;
                }
                }
            }
        }
        int t =1;
        if(maxi<0||maxj<0)
            return maximumarea;
        arr[maxi][maxj] = 'B';
        while(maxi+t<n&&maxi-t>=0&&maxj+t<m&&maxj-t>=0){
            if(arr[maxi][maxj+t]!='B'&&arr[maxi][maxj-t]!='B'&&arr[maxi+t][maxj]!='B'&&arr[maxi-t][maxj]!='B'){
            if(arr[maxi+t][maxj]=='E')
                arr[maxi+t][maxj]='S';
            else arr[maxi+t][maxj]='B';
            if(arr[maxi-t][maxj]=='E')
                arr[maxi-t][maxj]='S'; 
            else arr[maxi-t][maxj]='B';
            if(arr[maxi][maxj+t]=='E')
                arr[maxi][maxj+t]='S';
            else arr[maxi][maxj+t]='B';
            if(arr[maxi][maxj-t]=='E')
                arr[maxi][maxj-t]='S';    
            else arr[maxi][maxj-t]='B';
            t++;
            }
            else{
                break;
            }
        }
        int area2=1;
        int i1=-1;int j1 = -1;
         for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(arr[i][j]!='B'&&arr[i][j]!='E'&&arr[i][j]!='S' ){
                int newarea = check(arr,i,j,1,1,n,m);
                if(area2<newarea){
                    i1 = i;
                    j1 =j;
                     area2=newarea;
                }
                }
            }
        }
         maximumarea = Math.max(area*area2,maximumarea);
        int t2 = t;
        t =1;
        arr[maxi][maxj]='E';
        while(t2!=t&&maxi+t<n&&maxi-t>0&&maxj+t<m&&maxj-t>0){
            if(arr[maxi+t][maxj]=='S')
                arr[maxi+t][maxj]='E';
             arr[maxi+t][maxj]='G';
            if(arr[maxi-t][maxj]=='S')
                arr[maxi-t][maxj]='E'; 
            else arr[maxi+t][maxj]='G';
            if(arr[maxi][maxj+t]=='S')
                arr[maxi][maxj+t]='E';
            else arr[maxi][maxj+t]='G';
            if(arr[maxi][maxj-t]=='S')
                arr[maxi][maxj-t]='E';    
            else arr[maxi][maxj-t]='G';
            t++;
        }
        System.out.println("Turned E " +arr[maxi][maxj]);
        System.out.println("maxi "+maxi + " maxj "+maxj+" area ="+area +"\n   i "+ i1 + "    j "+j1 +" area2 "+area2+"\n"); 

        }
 return maximumarea;
    }
    public static void main(String[] args){
        String[] s = {
           //012345678911
            "GGGGGGGGGGGG",
            "GBGGBBBBBBBG",
            "GBGGBBBBBBBG",            
            "GGGGGGGGGGGG",           
            "GGGGGGGGGGGG",           
            "GGGGGGGGGGGG",          
            "GGGGGGGGGGGG",         
            "GBGGBBBBBBBG",          
            "GBGGBBBBBBBG",          
            "GBGGBBBBBBBG",        
            "GGGGGGGGGGGG",        
            "GBGGBBBBBBBG"};
            System.err.println("---------------------\n\n");
            int x =twoPluses(s);
            System.err.println(x);
    }
}

/*abstract

            "GGGGGGGGGGGG",
            "GBGGBBBBBBBG",
            "GBGGBBBBBBBG",            
            "GGGGGGGGGGGG",           
            "GGGGGGGGGGGG",           
            "GGGGGGGGGGGG",          
            "GGGGGGGGGGGG",         
            "GBGGBBBBBBBG",          
            "GBGGBBBBBBBG",          
            "GBGGBBBBBBBG",        
            "GGGGGGGGGGGG",        
            "GBGGBBBBBBBG"
*/