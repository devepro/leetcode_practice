/* IMPORTANT: Multiple classes and nested static classes are supported */



import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {

    class Edge{
        int source;
        int destination;
        int wt;

        public Edge(int source, int destination, int wt){
            this.source = source;
            this.destination = destination;
            this.wt = wt;
        }
    }
    public static void main(String args[] ) throws Exception {
  
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int arr[][]=new int[m][3];
        for(int i=0;i<m;i++){
            for(int j=0;j<3;j++)
                arr[i][j]=s.nextInt();
        }

        System.out.println(primtMst(n,m,arr));

    }

    public int primMst(int n,int edgeCount,int [][]edges){
        Map<Integer, List<Edge>> adj = new HashMap();

        for(int i = 0; i <= n; i++){
            List<Edge> e = new ArrayList();
            adj.put(i , e);
        }

        for(int i=0; i < edges.length; i++){

        }
    }
}
