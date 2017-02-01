/**GENERATE TREE**/
import java.util.*;
import java.util.Arrays;
class BST2
{
    class Node
    {
        int key;
        Node left,right;

        Node(int key)
        {
            this.key = key;
            this.left = this.right = null;
        }
    }
   static Node root;

    void generateTree(int []a)
    {
        Arrays.sort(a);
        BST2 bst = new BST2();
        balanceBST(bst, a, 0, a.length-1 );
           bst.print(root);
    }
    public void print(Node n)
    {
        if(n==null)return;
        print(n.left);
        System.out.println(n.key);
        print(n.right);
    }
    public void balanceBST(BST2 bst, int []a, int L, int R)
    {
        if(L>R) return;
        int m = (L+R)/2;
        bst.insert(a[m]);
        balanceBST(bst,a,L,m-1);
        balanceBST(bst,a,m+1,R);
    }
    public void insert(int key)
    {
        root = insert(root,key);
    }
    public Node insert(Node n, int key)
    {
        if(n==null)
            return new Node(key);
        else if(key<n.key)n.left = insert(n.left,key);
        else if(key>n.key) n.right = insert(n.right,key);
        return n;

    }
    public static void main(String []arg)
    {
        Scanner sc = new Scanner(System.in);
        BST2 b = new BST2();
        int n = sc.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; i++)
                    {a[i] = sc.nextInt();}
        b.generateTree(a);
       // generateTree(a);

    }

}
