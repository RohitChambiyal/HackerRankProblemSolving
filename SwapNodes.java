package Data_Structure;
import java.util.Scanner;
// import java.util.Stack;
public class SwapNodes {
    public static void swap(cnode tree, int k, int depth){
        if(tree==null)
            return;
        swap(tree.left,k,depth+1 );
        swap(tree.right,k,depth+1);
        if(depth%k==0){
            cnode temp = tree.left;
            tree.left = tree.right;
            tree.right = temp;
        }   
    }
    public static void inorder(cnode root){
        if(root==null)
            return;
        if(root.left!=null)
            inorder(root.left);
        System.out.print(root.data+" ");
        if(root.right!=null)
            inorder(root.right);
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        cnode[] tree = new cnode[n+1];
        for(int i=1;i<=n;i++)
            tree[i] = new cnode(i);
        for(int i=1;i<=n;i++){
            int left = s.nextInt();
            int right = s.nextInt();
            tree[i].left = (left ==-1 ? null : tree[left]);
            // System.out.println("Added Root "+tree[i].data+" left "+left);
            tree[i].right = (right ==-1 ?null : tree[right]);
         //   System.out.println("Added Root "+tree[i].data+" right "+right);
        //    System.out.println("  ");
        }
        int ktimes = s.nextInt();
        for(int i=1;i<=ktimes;i++){
            int k = s.nextInt();
            swap(tree[1],k,1);
            inorder(tree[1]);
            System.out.println();
        }
        
    }
}