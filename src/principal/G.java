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

            Vertex v= this.V[i];
            if(v.pi!=null)
            {
                System.out.println("v: "+ v.index + " | d: " + v.d+ " | pi: "+ v.pi.index);
            }
            else
            {
                System.out.println("v: "+ v.index + " | d: " + v.d+ " | pi: "+ null);
            }


        }
    }
}