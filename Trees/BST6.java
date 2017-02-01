import java.util.*;
class BST6
{
    class Node
    {
        int key;
        Node right;
        Node left;
        Node parent;
         Node(int key,Node parent)
        {
            this.key = key;
            this.right = this.left = null;
            this.parent = parent;
        }
    }
    static Node root;
    public Node getMin(Node n)
    {
        if(n.left == null)return n;
        return getMin(n.left);
    }
    public Node getSuccessor(Node n)
    {
        //if(n == null)
          //  return null;
        if(n.right != null)
            return getMin(n.right);
            else{
                if(n.parent.left == n)return n.parent;
                else
                {
                    while(n.parent.right == n)
                    {
                        n = n.parent;
                    }
                    return n.parent;
                }
            }

    }
    public void insert(int key)
    {
        root = insert(root,key, null);
    }
    public Node insert(Node n, int key, Node parent)
    {
        if(n==null)return new Node(key, parent);
        if(key<n.key)n.left = insert(n.left, key, n);
        else n.right = insert(n.right, key, n);
        return n;
    }
    public static void main(String []arg)
    {
        BST6 t = new BST6();
        t.insert(10);
        t.insert(5);
        t.insert(6);
        t.insert(15);
        t.insert(14);
        Node x = t.getSuccessor(root.right.left);
        System.out.println(x.key);
    }
}
