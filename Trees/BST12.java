/**REAL TOP VIEW**/
import java.util.*;
class BST12
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
    class CNode
    {
         Node node;
         int d;
         public CNode(Node node, int d)
         {
             this.node = node;
             this.d = d;
         }
    }
    public void insert(int key)
    {
        root = insert(root, key);
    }
    public Node insert(Node n, int key)
    {
        if(n == null)return new Node(key);
        if(n.key == key);
        if(key < n.key)n.left = insert(n.left, key);
        else n.right = insert(n.right, key);
        return n;
    }
    public void topLevel()
    {
        Set<Integer> s = new HashSet<Integer>();/**To keep the track of the coordinates in the set**/
        Queue <CNode> q = new LinkedList<CNode>();/**For doing the level Order traversal**/
        q.add(new CNode(root, 0));
        while(!q.isEmpty())
        {
            CNode t = q.poll();
            if(!s.contains(t.d))/**If the coordinate occurs for the first time then print it**/
                {
                System.out.print(t.node.key+" ");
                s.add(t.d);
                }
            if(t.node.left != null)q.add(new CNode(t.node.left,t.d - 1));/**If the left node is there then add it to the Queue and maintain the coordinate**/
            if(t.node.right != null)q.add(new CNode(t.node.right, t.d + 1));/**If the right node is there the add it to the Queue and maintain the coordinate**/
        }
    }

    public static void main(String []arg)
    {
        BST12 t = new BST12();
        t.insert(9);
        t.insert(8);
        t.insert(2);
        t.insert(3);
        t.insert(4);
        t.insert(5);
        t.insert(6);
        t.insert(7);
        t.insert(11);
        t.insert(10);
        System.out.println("THE TOP VIEW IS =")
        t.topLevel();
    }

}
