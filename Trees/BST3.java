/**CHECK IF THE TREE IS A BST OR NOT**/
class BST3
{
    class Node
    {
        int key;
        Node left, right;
        Node(int key)
        {
            this.key =key;
            this.right = this.left = null;
        }
    }
    Node root;
    public void insert(int key)
    {
        root=insert(root, key);
    }
    public Node insert(Node n, int key)
    {
        if(n==null)
            return new Node(key);
        else if(key<n.key)n.left = insert(n.left, key);
        else n.right = insert(n.right,key);
        return n;
    }
    public boolean isBST(Node n, int Lo, int Hi)
    {
        if(n==null)return true;
        if(n.key<=Lo||n.key>=Hi)
            return false;
        return isBST(n.left,Lo,n.key)&&isBST(n.right,n.key,Hi);
    }
    public static void main(String []arg)
    {
        BST3 b = new BST3();
        b.insert(5);
        b.insert(3);
        b.insert(4);
        b.insert(2);
        b.insert(1);
        boolean x = b.isBST(b.root,0,6);
        if(x==true)
            System.out.println("It is a BST");
        else
            System.out.println("Not a BST");
    }
}
