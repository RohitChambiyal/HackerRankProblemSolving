package Data_Structure;

import java.util.Scanner;
import java.util.Stack;
  class cnode{
    int data;
    cnode left;
    cnode right;
    cnode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class createTree {

    

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
            System.out.println("Added Root "+tree[i].data+" left "+left);
            tree[i].right = (right ==-1 ?null : tree[right]);
            System.out.println("Added Root "+tree[i].data+" right "+right);
            System.out.println("  ");
        }
        Stack<cnode> stack1 = new Stack<cnode>();
        stack1.push(tree[1]);
        while(!stack1.isEmpty()){
            cnode temp = stack1.pop();
            //if(temp!=null)
                System.out.print(temp.data+" ");
            if(temp.left!=null)
                stack1.push(temp.left);
            if(temp.right!=null)
                stack1.push(temp.right);
        }

        
    }
}