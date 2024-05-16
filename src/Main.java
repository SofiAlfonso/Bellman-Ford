import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import principal.*;

public class Main
{
    //Relax
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
    //Bellman Ford implementación
    public static boolean BF(G G, int s)
    {
        for(int i=1; i<=G.Vsize;i++)
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
    public static Vertex EncontrarVertice(int u, Vertex[] V)
    {
        for (int i=0; i< V.length; i++)
        {
            if(V[i].index==u)
            {
                return V[i];
            }
        }
        return null;
    }

   //LeerGrafo
    public static G leerGrafo(String archivo,int s)
    {
        try {
            Scanner sc = new Scanner(new File(archivo));
            int Vsize = sc.nextInt();
            int Esize = sc.nextInt();

            //Creamos los vertices
            Vertex[] V= new Vertex[Vsize];
            for (int i=1; i<=Vsize;i++)
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
                Vertex v= new Vertex(i,d,null);
                V[i-1]=v;
            }

            //Creamos los enlaces
            Edge[] E= new Edge[Esize];
            for (int i=0; i<Esize;i++)
            {
                int u1=sc.nextInt();
                Vertex u= EncontrarVertice(u1,V);
                int v1= sc.nextInt();
                Vertex v= EncontrarVertice(v1,V);
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

    //Main
    public static void main(String[] args)
    {
        System.out.println("_________________________________________________________________________________________________");
        int source=1;
        G G=leerGrafo("graphNew.txt", source);
        boolean result=  BF(G,source);
        System.out.println("Para el source " + source +"\n");
        if(result)
        {
            System.out.println("No tiene ciclos negativos");
        }
        else
        {
            System.out.println("Si tiene al menos un ciclo negativo");
        }
        System.out.println("_____________________________");
        G.printVertices();


    }
}