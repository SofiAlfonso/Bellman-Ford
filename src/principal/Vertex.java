package principal;

/**
 * Esta clase se encarga de los vertices que conforman al nodo, establece para cada uno unindice, la distancia al Source y el predecesor.
 */
public class Vertex
{
    public int index;
    public int d;
    public Vertex pi;

    public Vertex(int index, int d, Vertex pi)
    {
        this.index=index;
        this.d=d;
        this.pi=pi;
    }
}
