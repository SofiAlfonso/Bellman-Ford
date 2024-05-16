package principal;

public class G {
    public int Vsize;
    public int Esize;

    public Vertex[] V;
   public  Edge[] E;

    public G(int Vsize, int Esize, Vertex[]V, Edge[]E)
    {
        this.Vsize= Vsize;
        this.Esize=Esize;
        this.V=V;
        this.E=E;
    }

    public void printVertices()
    {
        for (int i=0; i<this.Vsize; i++)
        {

            int d;
            Vertex v= this.V[i];
            if(v.d==Integer.MAX_VALUE)
            {
                 d= -1;
            }
            else
            {
                d= v.d;
            }

            if(v.pi!=null)
            {
                System.out.println("v: "+ v.index + " | d: " + d+ " | pi: "+ v.pi.index);
            }
            else
            {
                System.out.println("v: "+ v.index + " | d: " + d+ " | pi: "+ null);
            }


        }
    }
}