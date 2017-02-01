import java.util.*;
class BST15
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
        if(key < n.key)n.left = insert(n.left, key);
        else n.right = insert(n.right, key);
        return n;
    }
    public void OddEvenLevelDifference()
    {
        Stack <Node> s = new Stack<Node>();
        s.push(root);
        boolean f = true;
        int sum = 0;
        while(!s.isEmpty())
        {
            Stack<Node> t = new Stack<Node>();
            while(!s.isEmpty())
            {
                Node x = s.pop();
                sum = sum+x.key;
                if(f)
                {
                    if(x.left != null)
                    {
                        x.left.key = -x.left.key;
                        t.push(x.left);
                    }
                    if(x.right != null)
                    {
                        x.right.key = -x.right.key;
                        t.push(x.right);
                    }
                }
                else
                {
                    if(x.left != null)t.push(x.left);
                    if(x.right != null)t.push(x.right);
                }
            }
                s = t;
                f = !f;
        }
        System.out.print("THE DIFFERENCE IS = "+sum);
    }
    public static void main(String []arg)
    {
        BST15 t = new BST15();
        t.insert(5);
        t.insert(3);
        t.insert(2);
        t.insert(4);
        t.insert(8);
        t.insert(7);
        t.OddEvenLevelDifference();

    }

}

