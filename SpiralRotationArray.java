package Data_Structure;
public class SpiralRotationArray
{
  public static void SpiralFunction(int arr[][],int startrow, int startcol,int row,int col){
    if(startrow>=row||startcol>=col)
      return;
    int i=startrow;
    int j= startcol;
    while(j<col){
      System.out.println(arr[i][j]);
      j++;
    }
    j--;
    i++;
    while(i<row){
      System.out.println(arr[i][j]);
      i++;
    }
    i--;
    j--;
    if(i!=startrow){
		while(j>=startcol)	{
          System.out.println(arr[i][j]);
          j--;
        }
      j++;
      i--;
    }
    if(j!=col-1){
      while(i>startrow){
        System.out.println(arr[i][j]);
        i--;
      }
    }
    //System.out.println("Calling Startrow "+(startrow+1)+" Startcol "+(startcol+1)+" maxrow "+(row-1)+" maxcol "+(col-1));
    SpiralFunction(arr,startrow+1,startcol+1,row-1,col-1);
   
  }
  static void printSpiral(int a[][], int r, int c)
  {
	SpiralFunction(a,0,0,r,c);
  }
}



