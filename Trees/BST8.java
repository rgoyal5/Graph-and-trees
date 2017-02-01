/**GET RANK**/
import java.util.*;
class BST8
{
    class Node
    {
        int key;
        Node left, right;
        int N;
        Node(int key)
        {
            this.key = key;
            this.right = this.left = null;
            N = 1;
        }
    }
    static Node root;
    public void insert(int key)
    {
        root = insert(root,key);
    }
    public int sizeOf(Node n)
    {
        if(n==null)return 0;
        return n.N;
    }
    public Node insert(Node n, int key)
    {
        if(n == null)return new Node(key);
        if(key<n.key)n.left = insert(n.left, key);
        else n.right = insert(n.right, key);
        n.N = 1+sizeOf(n.left)+sizeOf(n.right);
        return n;
    }
    public int getRank(Node n, int key)
    {
        if(n==null)
            return 0;
        if(n.key==key)
            return sizeOf(n.left);
        if(key<n.key)
            return getRank(n.left,key);
        return 1+sizeOf(n.left)+getRank(n.right,key);
    }
    public static void main(String []arg)
    {
        BST8 t = new BST8();
        t.insert(5);
        t.insert(3);
        t.insert(6);
        t.insert(4);
        t.insert(2);
        int rank = t.getRank(root,5);
        System.out.println(rank);
    }
}


