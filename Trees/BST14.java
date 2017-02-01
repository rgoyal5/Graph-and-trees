import java.util.*;
class BST14
{
    class Node
    {
        int key;
        Node left, right;
        Node(int key)
        {
            this.key = key;
            this.left = this.right = null;
        }
    }
    static Node root;
    public void insert(int key)
    {
        root = insert(root, key);
    }
    public Node insert(Node n, int key)
    {
        if(n == null)return new Node(key);
        if(key == n.key);
        if(n.key>key)n.left = insert(n.left, key);
        else n.right = insert(n.right, key);
        return n;
    }
    public void zigZag()
    {
        Stack<Node> s = new Stack<Node>();
        s.push(root);
       boolean f = true;
       while(!s.isEmpty())
        {
             Stack <Node> t = new Stack<Node>();
             while(!s.isEmpty())
             {
                 Node x = s.pop();
                 System.out.print(x.key+" ");
                 if(f)
                 {
                     if(x.left!=null)t.push(x.left);
                     if(x.right!= null)t.push(x.right);
                 }
                 else
                 {
                     if(x.right!= null)t.push(x.right);
                     if(x.left!=null)t.push(x.left);
                 }
             }
             s = t;
             f = !f;
        }
    }
    public static void main(String []arg)
    {
        BST14 t = new BST14();
        t.insert(5);
        t.insert(3);
        t.insert(2);
        t.insert(4);
        t.insert(8);
        t.insert(7);
        t.zigZag();
    }

}
