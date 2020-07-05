package Non_Uploaded_Git;
class TestNode { 
    public int data; 
    public TestNode next; 

    public TestNode(int nodeData) { 
        this.data = nodeData; 
        this.next = null; 
    } 
} 
public class test {
    TestNode head;
    void Rrec() {
            Rrec(head);
        }
    void Rrec(TestNode curr) {	
        	        if (curr == null) {
        	            return;
        	        }
        	        if (curr.next == null) {
        	            this.head = curr;
        	            return;
        	        }
        	        Rrec(curr.next);
        	        curr.next.next=curr;
        	        curr.next=null;
        	    }
    public static void main(String[] args){
        int value = 5;
        
        // if(fork()==0){
            
        // }
    }
}