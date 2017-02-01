import java.util.*;
class BST9
{
    class Node
    {
        int key;
        Node right, left;
        Node(int key)
        {
            this.key = key;
            this.left = this.right =null;
        }
    }
    static Node root;
    public void insert(int key)
    {
        root = insert(root,key);
    }
    public Node insert(Node n, int key)
    {
        if(n==null)return new Node(key);
        if(key < n.key)n.left = insert(n.left,key);
        else n.right = insert(n.right,key);
        return n;
    }
    public void putin(Node n, Vector v)
    {
        //Vector v = new Vector();
        if(n==null)return;
        putin(n.left,v);
        int x = n.key;
        v.addElement(x);
        putin(n.right,v);
        //return v;
    }
    public static void main(String []arg)
    {
        BST9 t = new BST9();
        t.insert(5);
        t.insert(4);
        t.insert(2);
        t.insert(1);
        t.insert(3);
        Vector v = new Vector();
         t.putin(root, v);
        for(int i = 0; i < v.size(); i++)
            { System.out.println(v.get(i)+" ");}

    }
}
