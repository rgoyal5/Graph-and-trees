/**CIRCUMFERENCE**/
class BST10
{
    class Node
    {
        int key;
        Node left, right;
        Node(int key)
        {
            this. key = key;
            this.right = this.left = null;
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
        if(key < n.key)n.left = insert(n.left, key);
        else n.right = insert(n.right, key);
        return n;
    }
    public void leaves(Node n)
    {
        if(n==null)return;
        leaves(n.left);
        if(n.left == null&&n.right == null)
        System.out.print(n.key+" ");
        leaves(n.right);
    }
    public void lefty(Node n)
    {
        if(n == null)return;
        if(n.left == null&&n.right == null)
            return;

        if(n.left!=null&&n.left != null)
        {
            System.out.print(n.key+" ");
            lefty(n.left);
        }
        if(n.left == null)
        {
            System.out.print(n.key+ " ");
            lefty(n.right);
        }

    }
    public void righty(Node n)
    {
        if(n==null)return;
        if(n.left == null&&n.right == null)
            return;

        if(n.right!=null)
        {
            righty(n.right);
            System.out.print(n.key+" ");
        }
        if(n.right == null)
        {
            righty(n.left);
            System.out.print(n.key+" ");
        }

    }
    public static void main(String []arg)
    {
        BST10 t = new BST10();
        t.insert(10);
        t.insert(5);
        t.insert(7);
        t.insert(6);
        t.insert(15);
        t.insert(14);
        t.lefty(root);
                    System.out.print("     ");

        t.leaves(root);
                    System.out.print("     ");

        t.righty(root.right);
    }
}

