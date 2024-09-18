public class QuickUnion {

    private int[] id;
    private int[] siz;
    private int largest[];

    public QuickUnion(int N)
    {
        for(int i=0;i<N;i++)
        {
            id[i]=i;
            siz[i]=1;
            largest[i]=i;
        }
    }

    // private int root(int i)
    // {
    //     while(i != id[i])
    //     {
    //         i=id[i];
    //     }
    //     return i;
    // }

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
        if(largest[i]<largest[j])
        {
            largest[i]=largest[j];
        }
        else{
            largest[j]=largest[i];
        }
    }


}


//  find is costy  