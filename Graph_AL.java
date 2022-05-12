
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Graph_AL {
    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph{
        int vertices;
        LinkedList<Edge>[] adjacencylist;

        Graph(int vertices) {
            this.vertices = vertices;
            adjacencylist = new LinkedList[vertices];
            // initialize adjacency lists for all the vertices
            for (int i = 0; i < vertices; i++) {
                adjacencylist[i] = new LinkedList<>();
            }
        }

        public void addEgde(int source, int destination, int weight){
            Edge edge = new Edge(source, destination, weight);
            adjacencylist[source].addFirst(edge); // for directed graph
            
        }

        public void printGraph(){

            for (int i = 0; i < vertices; i++) {
                LinkedList<Edge> list = adjacencylist[i];
                for (int j = 0; j < list.size(); j++) {
                    System.out.println("vertex-" + i + " is connected to " +
                            list.get(j).destination + " with weight " + list.get(j).weight);
                }
            }
        }


     
    }

   static class pair{
        int v;
        int av;
        int wt;
         

        pair(int v, int av,int wt){
            this.v = v;
            this.av= av;
            this.wt=wt;

        }
   }




    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEgde(0, 1, 4);
        graph.addEgde(0, 2, 3);
        graph.addEgde(1, 3, 2);
        graph.addEgde(1, 2, 5);
        graph.addEgde(2, 3, 7);
        graph.addEgde(3, 4, 2);
        graph.addEgde(4, 0, 4);
        graph.addEgde(4, 1, 4);
        graph.addEgde(4, 5, 6);
        graph.printGraph();
       
        System.out.println();


        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(0, -1, 0));

        boolean[] visited = new boolean[vertices];
        while(pq.size() >= 0){




            pair remove = pq.remove();

            if (visited[remove.v] == true) {
                continue;
            }

            
            
            
            visited[remove.v] = true;
            if (remove.av != -1) {
                
                System.out.println(remove.v);
            }

            for (Edge e : graph[remove.v]) {
                    if (visited[e.destination] == false) {
                        pq.add(new pair(e.destination, remove.v, e.weight));
                    }
            }




        }

    }

}