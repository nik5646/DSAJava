package HeapTopic;

import java.util.ArrayList;

public class Heap {
    private ArrayList<Integer> ll = new ArrayList<>();

    public void add(int item){
        ll.add(item);
        upheapify(ll.size()-1);
    }
   // ci :- child index
    // pi :- parent index
    //heap implementation takes place usinf array or arraylist since heap is a complete binary tree
    // and left child present at 2i+1 and right child present at 2i+2 index
    // for parent index we can do pi=(ci-1)/2
    private void upheapify(int ci) {
        int pi = (ci-1)/2;
        if(ll.get(pi)>ll.get(ci)){// minheap , smallest at root
            Swap(pi,ci);
            upheapify(pi);
        }
    }

    private void Swap(int pi, int ci) {
        int pi_data = ll.get(pi);
        int ci_data = ll.get(ci);
        ll.set(pi, ci_data);
        ll.set(ci, pi_data);
    }

    public int heapSize(){
        return ll.size();
    }

    public int minItem(){
        return ll.get(0);
    }

    public int remove(){ // remove root
        int v= ll.get(0);
        Swap(0, ll.size()-1);// for deletion we make last node as first node that we need to delete
        ll.remove(ll.size()-1);//delete the last node
        downheapify(0);// make heap again from root
        return v;
    }

    private void downheapify(int pi) {
        int lci = 2*pi +1;
        int rci = 2*pi +2;
        int mini = pi;
        if(lci < ll.size() && ll.get(mini) > ll.get(lci)){
            mini = lci;
        }
        if(rci < ll.size() && ll.get(mini) > ll.get(rci)){
            mini = rci;
        }
        if(mini != pi){
            Swap(mini, pi);
            downheapify(mini);
        }
    }


    public void Display() {
        System.out.println(ll);
    }
}
