/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gr;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Rishabh Goyal
 */
class Graph {

    private int V;
    private int E;
    private LinkedList<Integer>[] adj;
    public Graph(int v)
            {
                this.V=v;
                this.E=0;
                this.adj=new LinkedList[v];
                for(int i=0;i<v;i++)
                {
                    adj[i]=new LinkedList<Integer>();
                }
            }
    public void addEdge(int v,int w)
    {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
    public int V()
    {
        return V;
    }
    public Iterable<Integer> adjlist(int v)
    {
        return adj[v];
    }
 }
 class DFS
    {
         private boolean cycle;
    private boolean marked[];
    int count;
   public DFS(Graph g,int v){
        this.marked=new boolean[g.V()];
        
        cycle=false;
        count=0;
        for(int i=0;i<g.V();i++)
        {
        if(marked[i]==false)    
        {dfs(g,i,-1);
        count++;
        }
    }
   }
    private void dfs(Graph g,int v,int p)
    {
        marked[v]=true;
        for(Integer w : g.adjlist(v))
        {
            if(!marked[w])
                dfs(g,w,v);
            else
            {
                if(w!=p)
                    cycle=true;
        }
    }
    }
    public boolean haspathto(int v)
    {
        return marked[v];
    }
    public boolean cycle()
    {
        return cycle;
    }
    public int island()
    {
        return count;
    }
    public boolean con(Graph g)
    {
        boolean chk=true;
        for(int i=0;i<g.V();i++)
        {
            if(marked[i]==false)
                chk=false;
            //System.out.print(chk);
            System.out.print(marked[i]);
        }
        return chk;
    }
 }
class BFS
{
    private boolean marked[];
    public BFS(Graph g,int v)
    {
        this.marked=new boolean[g.V()];
        bfs(g,v);
    }
    private void bfs(Graph g,int v)
    {
        Queue<Integer>q=new LinkedList<Integer>();
        q.add(v);
        marked[v]=true;
        while(!q.isEmpty())
        {
            int w=q.poll();
            for(int x : g.adjlist(w))
            {
                if(!marked[x])
                {
                    marked[x]=true;
                    q.add(x);
                }
            }
        }
    }
    public boolean con(Graph g)
    {
        boolean chk=true;
        for(int i=0;i<g.V();i++)
        {
            if(marked[i]==false)
                chk=false;
            //System.out.print(chk);
         //   System.out.print(marked[i]);
        }
        return chk;
    }
    public boolean haspath(int v)
    {
        return marked[v];
    }
    
}
public class Gr {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  
         Graph g=new Graph(4);
        g.addEdge(1, 2);
        g.addEdge(0, 1);
        g.addEdge(2, 3);
        g.addEdge(1, 3);
        
        DFS d=new DFS(g,0);
        BFS b=new BFS(g,0);
        System.out.println(d.haspathto(1));
        System.out.println(d.cycle());
        System.out.println(b.haspath(1));
        System.out.println(d.island());
        //System.out.println(d.con(g));
        System.out.println(b.con(g));
    }
}
