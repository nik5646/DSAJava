package Graph;

import java.util.HashMap;

// Undirected, Weighted Graph
public class GraphImplementation {

    HashMap<Integer, HashMap<Integer, Integer>> map;

    GraphImplementation(int v){
        map = new HashMap<>();
        for(int i=1; i<=v;i++){
            map.put(i, new HashMap<>());
        }
    }
    public void AddEdge(int v1, int v2, int cost){
        map.get(v1).put(v2, cost);
        map.get(v2).put(v1,cost);
    }

    public void AddVertex(int v){
        map.put(v, new HashMap<>());
    }

    public boolean ContainsEdge(int v1, int v2){
        return map.get(v1).containsKey(v2);
    }

    public boolean ContainsVertex(int v){
        return map.containsKey(v);
    }

    public int NoOfEdges(){
        int sum=0;
        for(int vtx : map.keySet()){
           sum  += map.get(vtx).size();
        }
        return sum/2;
    }

    public void removeEdge(int v1, int v2){
        map.get(v1).remove(v2);
        map.get(v2).remove(v1);
    }

    public void removeVertex(int v){
        for(int nbrs : map.get(v).keySet()){
            map.get(nbrs).remove(v);
        }
        map.remove(v);
    }

    public void display(){
        for(int vtx : map.keySet()){
            System.out.println(vtx+" "+ map.get(vtx));
        }
    }




}
