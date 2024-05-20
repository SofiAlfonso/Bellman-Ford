package principal;
import java.util.ArrayList;

/**
 * Esta clase se encarga de la creación del grafo, contiene el número de verices, aristas y una lista para estos
 */
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

    /**
     * Imprime el estado final de los vertices luego de la aplicación de Bellman Ford
     */

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

    /**
     * Imprime el camino más corto entre el nodo source y otro elegido. Lo hace siguiendo los predecesores hasta llegar a null (El predecesor del source)
     * @param v indice del nodo destino
     * @param s indice del nodo source
     */
    public void printShortestPath (int v,int s)
    {
        Vertex llegada= this.V[v-1];
        System.out.println("\nEl camino más corto entre " + s +" y "+v+" es: ");
        ArrayList<Integer> camino= new ArrayList<>();
        while(llegada!=null)
        {
            camino.add(llegada.index);
            llegada=llegada.pi;
        }
        for(int i=camino.size()-1;i>=0;i--)
        {
            System.out.print("-> "+camino.get(i));
        }
        System.out.println(" | Su peso es de: "+this.V[v-1].d);


    }
}