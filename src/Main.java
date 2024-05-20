/**
 * El programa implementa el algoritmo de bellman ford, usando prgogramación orientada a objetos para analizar el grafos, sus vertices y aristas.
 *
 * @author  Tomás Gañan Rivera y Ana Sofia ALfonso Moncada
 * @since   2024-05-16
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import principal.*;


public class Main
{
    /**
     *  Este método "relaja" una arista, encuentra si el peso del vertice de llegada
     *  es mayor que el de entrada más el peso de la arista, finaliza otorgandole al vertice de llegada, el menor de los pesos.
     * @param e  es la arista que recive, con un vertice de llegada, uno de entrada y el peso de la arista
     */

    public static void Relax(Edge e)
    {
        Vertex u= e.u;
        Vertex v= e.v;
        int w= e.w;
        if(v.d>u.d+w)
        {
            v.d=e.u.d+w;
            v.pi=u;
        }
    }

    /**
     * Este método relaja cada arista varias veces(el número de vertices-1 veces)
     * lo que asegura que cada vertice termine con una distancia mínima al Source
     * para el peor de los casos.
     * @param G es el grafo sobre el que estamos trabajando
     * @param s es el nodo source desde el que partimos
     * @return se retorna verdadero si es que el grafo no contiene ciclos negativos, y falso en caso contrario
     */
    public static boolean BF(G G, int s)
    {
        for (int i=1; i<=G.Vsize;i++)
        {
            int d;
            if (i==s)
            {
                d=0; //Distancia del source es 0
            }
            else
            {
                d=999999999;
            }
            G.V[i-1].d=d;
            G.V[i-1].pi=null;
        }
        for(int i=1; i<G.Vsize;i++)
        {
            for (int a=0;a<G.Esize;a++)
            {
                Relax(G.E[a]);
            }
        }
        for(int i=0; i<G.Esize;i++)
        {
            Vertex v= G.E[i].v;
            Vertex u= G.E[i].u;
            int w= G.E[i].w;

            if (v.d>u.d+w)
            {
                return false;
            }
        }
        return true;
    }


    /**
     * Este método se encarga de leer el arcivo txt, establecer los vertices y aristas, y el grafo con el cuál se trabajará.
     * @param archivo Nombre del archivo txt
     * @return reorna el grafo creado, al método main
     */
    public static G leerGrafo(String archivo)
    {
        try {
            Scanner sc = new Scanner(new File(archivo));
            int Vsize = sc.nextInt();
            int Esize = sc.nextInt();

            //Creamos los vertices
            Vertex[] V= new Vertex[Vsize];
            for (int i=1; i<=Vsize;i++)
            {
                Vertex v= new Vertex(i,999999999,null);
                V[i-1]=v;
            }

            //Creamos los enlaces
            Edge[] E= new Edge[Esize];
            for (int i=0; i<Esize;i++)
            {
                int u1=sc.nextInt();
                Vertex u= V[u1-1];
                int v1= sc.nextInt();
                Vertex v= V[v1-1];
                int w=sc.nextInt();
                E[i]=new Edge(u,v,w);
            }

            //Creamos el grafo
            G G= new G(Vsize,Esize, V,E);

            return G;
        } catch (FileNotFoundException e) {
            System.out.println("No hay archivo");
        }
        return null;
    }

    /**
     * Se encarga de manejar paso por paso los métodos relacionados con la lectura del grafo, y el BF
     * toma también el tiempo de ejecución del algoritmo BF
     * @param args
     */
    public static void main(String[] args)
    {
        //Se lee el grafo
        System.out.println("_________________________________________________________________________________________________");
        int source=1;
        G G=leerGrafo("graph1.txt");

        //Se implementa Bellman Ford
        long ti=System.nanoTime();
        boolean result=  BF(G,source);
        long tf=System.nanoTime();

        System.out.println("Tiempo de esjución (ns):"+(tf-ti));

        //Se imprime si hay o no ciclos negativos
        System.out.println("\nPara el source " + source +"\n");
        if(result)
        {
            System.out.println("No tiene ciclos negativos");
        }
        else
        {
            System.out.println("Si tiene al menos un ciclo negativo");
        }
        System.out.println("_____________________________");

        //Se imprime el estado final de los vertices y la ruta más corta desde el source a otro vertice seleccionado
        G.printVertices();
        G.printShortestPath(5,source);


    }
}