/**FREQUENCY COUNTER**/
import java.util.*;
class BST5
{
    class Node
    {
        int fre;
        String s;
        Node left,right;
        Node(String s)
        {
            this.fre = 1;
            this.left = this.right =null;
            this.s = s;
        }
    }
    static Node root;
    public void insert(String s)
    {
        root = insert(root,s);
    }
    public Node insert(Node n, String s)
    {
        if(n==null)return new Node(s);
        if(n.s.compareTo(s)== 0)n.fre++;
        else if(s.compareTo(n.s)<0)n.left = insert(n.left,s);
        else n.right = insert(n.right, s);
        return n;
    }
   static public Node max;
    public void getMax(Node n)
    {
        if(n==null) return ;
        if(max.fre<n.fre)
            max=n;
       getMax(n.left);
       getMax(n.right);
    }
    public static void main(String []arg)
    {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        String str;
        BST5 t = new BST5();
        while(sc.hasNext())
        {
            str = sc.next();
            if(str.length()>=m);
            {
                t.insert(str);
            }
        }
        max=root;
        t.getMax(root);
        System.out.println("The maximum occurring string is = "+max.s+" and it has occurred ="+max.fre);
    }
}
