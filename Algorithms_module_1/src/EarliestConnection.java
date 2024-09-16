class UnionFind {

    private int[] id;
    private int count;
    private int[] siz;

    public UnionFind(int N)
    {
        for(int i=0;i<N;i++)
        {
            id[i]=i;
            siz[i]=1;
        }
        count=N;
    }

   

    private int root(int i)
    {
        while(i != id[i])
        {
            id[i]=id[id[i]];
            i=id[i];
        }
        return i;
    }

    public boolean connected(int p,int q)
    {
        return root(q)==root(p);
    }
    public boolean connected()
    {
        return count==1;
    }

    // public void union(int p,int q)
    // {
    //     int i=root(p);
    //     int j=root(q);
    //     id[i]=j;
    // }

    public void union(int p,int q)
    {
        int i = root(p);
        int j = root(q);
        if(i==j)
        {
            return;
        }
        if(siz[i]<siz[j])
        {
            id[i]=j;
            siz[j]+=siz[i];
        }
        else{
            id[j]=i;
            siz[i]+=siz[j];
        }
        count--;
    }


}
public class EarliestConnection {
    // Function to determine the earliest timestamp when all members are connected
    public static int earliestConnection(int n, int[][] log) {
        UnionFind uf = new UnionFind(n);

        for (int[] entry : log) {
            int timestamp = entry[0];
            int p = entry[1];
            int q = entry[2];

            uf.union(p, q);

            
            if (uf.connected()) {
                return timestamp;
            }
        }
        return -1;  
    }

   
}
