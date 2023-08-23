package neetcode150.stack;

public class MinStack {

    class Node {
        int val;
        int minNode;
        Node next;
    }
    Node root ;
    public MinStack() {
        root = null;
    }

    public void push(int val) {
        if(root == null)
        {
            root = new Node();
            root.val = val;
            root.minNode = val;
            root.next = null;
        }
        else{
            Node n = new Node();
            n.val = val;
            if(val < root.minNode)
                n.minNode = val;
            else
                n.minNode = root.minNode;
            n.next = root;
            root = n;
        }
    }

    public void pop() {

        if(root != null){
            root = root.next;
        }
    }

    public int top() {
        if(root == null) throw new IllegalStateException();
        return root.val;
    }

    public int getMin() {
        if(root == null) throw new IllegalStateException();
        return root.minNode;
    }
}
