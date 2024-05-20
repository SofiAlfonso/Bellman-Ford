package principal;

/**
 * Esta clase se encarga de las aristas del vertice, así consigna un nodo origen u, un nodo destino v, y un peso entre ambos.
 */
public class Edge
{
    public Vertex u;
    public Vertex v;
    public int w;

    public Edge(Vertex u, Vertex v,int w)
    {
        this.u=u;
        this.v=v;
        this.w=w;

    }
}
