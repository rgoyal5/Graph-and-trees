/**LEVEL ORDER TRAVERSAL**/
import java.util.*;
class bst1
{
    class Node{
    int key;
    Node left,right;
    Node(int key)
    {
        this.key = key;
        this.left = this.right = null;
    }
    }
   static Node root;
    public void insert(int key)
    {
        root = insert(root,key);
    }
    public Node insert(Node n, int key)
    {
        if(n==null)
            return new Node(key);
        if(key<n.key)
            n.left = insert(n.left, key);
        else if(key>n.key)
            n.right = insert(n.right, key);
            return n;

    }
    public void printLevelOrder(Node n)
    {
       if(n==null)
        return;
        Queue <Node>q = new LinkedList();
        q.add(root);
        while(!q.isEmpty())
            {
                Node x = q.poll();
                System.out.print(x.key+" ");
                if(x.left!=null)
                        q.add(x.left);
                if(x.right!=null)
                        q.add(x.right);
            }
    return;
    }

        public static void main(String[] arg)
        {
            bst1 t = new bst1();
            t.insert(5);
            t.insert(3);
            t.insert(8);
            t.insert(1);
            t.insert(4);
            t.insert(7);
            t.insert(9);
            t.printLevelOrder(root);
        }

    }


