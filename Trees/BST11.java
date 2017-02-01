class BST11
{

    class Node
    {
        int key;
        Node left, right;
        Node(int key)
        {
            this.key = key;
            this.left = this.right =null;
        }
    }
    static Node root;
    public void insert(int key)
    {
        root = insert(root, key);
    }
    public Node insert(Node n, int key)
    {
        if(n==null)return new Node(key);
        if(key<n.key)n.left = insert(n.left, key);
        else n.right = insert(n.right, key);
        return n;
    }
    public Node getMin(Node n)
    {
        if(n.left == null)return n;
        return getMin(n.left);
    }
    public void delete(int key)
    {
        root = delete(root, key);
    }
    public Node delete(Node n, int key)
    {
        if(n == null)return null;
        if(key < n.key)n.left = delete(n.left, key);
        if(key > n.key)n.right = delete(n.right, key);
        else
        {
            if(n.right == null&&n.left == null)
                root = null;
            if(n.right == null)return n.left;
            if(n.left == null)return n.right;
                Node temp = getMin(n.right);
                n.key = temp.key;
                n.right = delete(n.right,temp.key);
        }
        return n;
    }
    /*public void search(int key)
    {
    Node p = search(root, key);
    if(p != null)System.out.println("FOUND");
        else  System.out.println("NOT FOUND");
    }
    public Node search(Node n, int key)
    {
        if(n == null)return n;
        else if(key == n.key)return n;
        else if(key < n.key)n.left = search(n.left, key);
        else n.right = search(n.right,key);
        //return n;
    }*/
    public void search(int key)
    {
        boolean b = search(root, key);
        if(b == true)System.out.println("FOUND");
        else System.out.println("NOT FOUND");
    }
    private boolean search(Node n, int key)
    {
        if(n==null)return false;/**If tree is traversed and the element is not found**/
        if(n.key == key)return true;/**If the element is found**/
        if(n.key > key)return search(n.left, key);/**Go left**/
        return search(n.right,key);/**Go right**/
    }
    public static void main(String []arg)
    {
        BST11 t =  new BST11();
        t.insert(15);
        t.insert(10);
        t.insert(8);
        t.insert(6);
        t.insert(9);
        t.insert(20);
        t.insert(16);
        t.insert(17);
        t.insert(25);
        t.search(20);
        t.delete(20);
        t.search(20);
    }
}
