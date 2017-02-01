/**GET RANK**/
class BST4
{
    class Node
    {
        int key;
        Node left;
        Node right;
        int size;
        Node(int key)
        {
            this.key = key;
            this.right = this.left = null;
            this.size = 0;
        }
    }
         static Node root;
        public  void insert(int key)
        {
            root = insert(root, key);
        }
        public Node insert(Node n , int key)
        {
            if(n==null)return new Node(key);
            if(n.key == key );
            if(n.key>key)n.left = insert(n.left,key);
            if(n.key<key)n.right = insert(n.right,key);
            n.size = 1+ sizeOf(n.left)+sizeOf(n.right);
            return n;
        }
        public int sizeOf(Node n)
        {
            if (n == null) return 0;
            return 1+sizeOf(n.left)+sizeOf(n.right);
        }
        public int getRank(Node n, int key)
        {
            //if(n==null)return 0;
            if(n.key == key)
                return sizeOf(n.left);
            else if(n.key>key)
            {
                    n = n.left;
            return getRank(n,key);
            }
                return 1+ getRank(n.right, key)+sizeOf(n.left);
        }
        void print(Node n)
        {
            if(n==null)
                return;
            print(n.left);
            System.out.println(n.key);
            print(n.right);
        }
        public static void main(String []arg)
        {
            BST4 t = new BST4();
            t.insert(5);
            t.insert(2);
            t.insert(4);
            t.insert(1);
            t.insert(7);
            t.insert(8);
            //t.print(root);
            //int r = t.getRank(5);
            System.out.println(t.getRank(root,1));
        }
    }


