package binary.tree;

/**
 *
 * @author Rishabh Goyal
 */

import java.util.*;

class node {
 int key;
 node left;
 node right;
 int N;
 public node(int key)
 {
  this.key = key;
  this.left = null;
  this.right = null;
  this.N = 1;
 }
}
public class Binary {

 
 node root;
 
 public void insert(int key)
 {
  root = insert(root, key);
 }
 private node insert(node root , int key)
 {
  if(root == null)
   return new node(key);
  if(root.key  < key)
  {
   root.right = insert(root.right, key);
  }
  else if(root.key  > key)
  {
   root.left = insert(root.left, key);
  }
  else if(root.key == key)
   {;}
  return root;
 }
 
 public void level()
 {
  level(root);
 }
 private void level(node root)
 {
  Queue<node> q = new LinkedList<node>();
  q.add(root);
  while(!q.isEmpty())
  {
   node temp = q.poll();
   System.out.print(temp.key+" ");
   if(temp.left != null)
   q.add(temp.left);
   if(temp.right != null)
   q.add(temp.right);
  }
 }
 public void floor(int key)
 {
  int ans;
  ans = floor(root,key);
  System.out.print(ans);
  
 }
 private int floor(node root, int key)
 {
  if(root == null)
  {
   return -1;
  }
  if(root.key == key)
   return root.key;
  
  
 if(root.key > key)
 {
  return floor(root.left, key);
 }
 else
 {
  int ans = floor(root.right, key);
  if(ans >= 0)
   return ans;
  return root.key;
   
 }
 
 }
 public void ceil(int key)
 {
  int ans = ceil(root,key);
  System.out.print(ans);
 }
 private int ceil(node root, int input)
 {
  
         
          // Base case
          if (root == null) {
              return -1;
          }
  
          // We found equal key
          if (root.key == input) {
              return root.key;
          }
  
          // If root's key is smaller, ceil must be in right subtree
          if (root.key < input) {
              return ceil(root.right, input);
          }
  
          // Else, either left subtree or root has the ceil value
          int ceili = ceil(root.left, input);
         
          return (ceili >= input) ? ceili : root.key;
      }
 public int sizeOf(node r)
 {
  if(r==null)
   return 0;
  else return r.N;
 }
 public void rank(int num)
 {
  int r = rank(root,num);
  if(r == -1)
  {
   System.out.print("Number not found");
   
  }
  else
   System.out.print("Rank = "+r);
  
 }
 
 private int rank(node root, int num)
 

 {
  if(root == null)return -1;
  if(root.key == num)return sizeOf(root.left);
  if(num  < root.key) return rank(root.left, num);
  int p = rank(root.right,num);
  if(p == -1)
  { return p;}
  return 1+sizeOf(root.left)+p; 
  
           
       
    }
 
  public void height()
  {
   //int h;
   int h = height(root);
   System.out.print(h);
  }
  private int height(node root)
  {
   if(root == null )
    return 0;
   else
    return (1+Math.max(height(root.left), height(root.right)));
  }
 public void diameter()
 {
  int ans = diameter(root);
  System.out.print(ans);
 }
 private int diameter(node root)
 {
  if(root==null)
   return 0;
  else
  {
   int l = height(root.left);
   int r = height(root.right);
   int left = diameter(root.left);
   int right = diameter(root.right);
   return Math.max((l+r+1),Math.max(left, right));
  }
 }
 node n;
 int s = 0 ;
 public void succesor(int key)
 {
  int ans = succesor(root, key);
  System.out.print(ans);
 }
 private int succesor(node root,int key)
 {
  
  if(root == null)
   return -1;
  if(key == root.key)
  {
   if(root.right != null)
   {
    n = findmin(root.right);
    s = n.key;
   }
  }
  else if(key < root.key)
  {
   s = root.key;
   succesor(root.left , key);
   
  }
  else if(key > root.key)
  {
   
   succesor(root.right, key);
  }
  return s;
 }
 private node findmin(node root)
 {
  if(root.left != null)
   root.left= findmin(root.left);
   return root;
 }
 
 public void predesesor(int key)
 {
  int ans = prede(root,key);
  System.out.print(ans);
 }
 private int prede(node root, int key)
 {
  if(root == null)
   return -1;
  if(root.key == key)
  {
   if(root.left != null)
    n = findmax(root.left);
    s = n.key;
  }
  else if(key > root.key)
  {
   s = root.key;
   prede(root.right, key);
  }
  else if(key < root.key)
  {
   prede(root.left,key);
  }
  return s;
 }
 private node findmax(node root)
 {
  if(root == null)
   return root;
  if(root.right != null)
   root.right = findmax(root.right);
  return root;
 }
 
 public static void main(String[] args) {
  
  Binary b = new Binary ();
  b.insert(5);
  b.insert(2);
  b.insert(3);
  b.insert(6);
  b.insert(1);
  b.insert(8);
  b.insert(7);
  b.insert(14);
  b.insert(10);
  b.insert(9);
  b.insert(12);
  b.insert(13);
  
  b.level();
  b.floor(16);
  b.ceil(11);
  b.rank(10);
  b.height();
  b.diameter();
  b.succesor(11);
  b.predesesor(11);

 }

}