package Map;

import java.util.ArrayList;

/*
@author : nik5646
 */
public class HashMap<K, V> {
      class Node{
          K key;
          V value;
          Node next;
      }
      private ArrayList<Node> bucket; // bucket to store address of each chain/ we are following chaining
      private int size;//hashmap size
      public HashMap(){
          this(4);
      }
      public HashMap(int n){
          bucket = new ArrayList<>();
          for(int i=0;i<n;i++){
              bucket.add(null);
          }
      }

      public int hashFunction(K key){
          int idx = key.hashCode() % bucket.size();
          if(idx <0){
              idx = idx+ bucket.size();
          }
          return idx;
      }

      public void put(K key, V value){
          int idx = hashFunction(key);
          Node temp = bucket.get(idx);
          while(temp != null){
              if(temp.key.equals(key)){
                  temp.value = value;
                  return;
              }
              temp = temp.next;
          }
          Node nn = new Node();
          nn.key = key;
          nn.value = value;
          nn.next = bucket.get(idx);
          bucket.set(idx, nn);
          size++;

          //Rehashing :- increasing Bucket Size
          double threshold = 2.0;
          double loadFactor = size * 0.1 / bucket.size();
          if(loadFactor > threshold){
              rehashing();
          }

      }

    private void rehashing() {
          // we will double the size of bucket and make old bucket point to new bucket address
        ArrayList <Node> new_bucket = new ArrayList<>();
        for(int i=0; i<2*bucket.size();i++){
            new_bucket.add(null);
        }
        ArrayList<Node> ll= bucket;
        new_bucket = bucket;
        for(Node nn : ll){
            while(nn != null){
                put(nn.key, nn.value);
                nn = nn.next;
            }
        }
    }

    public V remove(K key){
          int idx = hashFunction(key);
          Node prev = null;
          Node curr = bucket.get(idx);
          while(curr != null){
              if(curr.key.equals(key)){
                  break;
              }
              prev = curr;
              curr = curr.next;
          }
          if(curr == null){
              return null;// key not found
          }
          else if(prev == null){
              //first element from list
              bucket.set(idx, curr.next);
              curr.next = null;
          }
          else{
              prev.next = curr.next;
          }
          size--;
          return curr.value;
      }

      public V get(K key){
          int idx = hashFunction(key);
          Node temp = bucket.get(idx);
          while(temp != null){
              if(temp.key.equals(key)){
                  return temp.value;
              }
              temp = temp.next;
          }
          return null;
      }

      public boolean ContainsKey(K key){
          int idx = hashFunction(key);
          Node temp = bucket.get(idx);
          while(temp != null){
              if(temp.key.equals(key)){
                  return true;
              }
              temp = temp.next;
          }
          return false;
      }

        @Override
        public String toString() {
            String s = "{";
            for (Node nn : bucket) {// old date ke list pe loop lagye ho
                while (nn != null) {
                    s = s + nn.key + "=" + nn.value + ",";
                    nn = nn.next;
                }
            }
            s= s.substring(0, s.length()-1);
            return s + "}";
        }







}
