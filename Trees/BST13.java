/**!--BOTTOM LEVEL VIEW--!**/
import java.util.*;
class BST13
{
    class Node
    {
        int key;
        Node left, right;
        Node(int key)
        {
            this.key = key;
            this.right = this.left = null;
        }
    }
    static Node root;
    class CNode
    {
        int d;
        Node node;
        CNode(Node node, int d)
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
        if(key == n.key);
        else if(key < n.key)n.left = insert(n.left, key);
        else n.right = insert(n.right, key);
        return n;
    }
    public void bottomLevel()
    {
        Stack<CNode> st = new Stack<CNode>();
        Queue<CNode> q = new LinkedList<CNode>();
        q.add(new CNode(root, 0));
        while(!q.isEmpty())
        {
            CNode t = q.poll();
            st.push(t);
            if(t.node.left != null)q.add(new CNode(t.node.left,t.d - 1));
            if(t.node.right != null)q.add(new CNode(t.node.right, t.d + 1));
        }
        Set<Integer> s = new HashSet<Integer>();
        while(!st.isEmpty())
        {
            CNode t = st.pop();
            if(!s.contains(t.d))
            {
                System.out.print(t.node.key+" ");
                s.add(t.d);
            }
        }
    }
    public static void main(String []arg)
    {
        BST13 t = new BST13();
        t.insert(9);
        t.insert(8);
        t.insert(2);
        t.insert(3);
        t.insert(4);
        t.insert(5);b
        t.insert(6);
        t.insert(7);
        t.bottomLevel();

    }
}
