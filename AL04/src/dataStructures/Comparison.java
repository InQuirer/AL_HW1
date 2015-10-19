package dataStructures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Comparison {
    public static PriorityQueue<Integer> ascPriorityQueue(int n) {
    	PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    	for (int i = 0; i < n; i++)
			pq.add(i);
    	return pq;
    }

    public static PriorityQueue<Integer> randomPriorityQueue(int n) {
    	PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    	for (int i = 0; i < n; i++)
			pq.add((int) Math.random()*n);
    	return pq;
    }
    
    public static TreeSet<Integer> ascTree(int n) {
    	TreeSet<Integer> ts = new TreeSet<Integer>();
       	for (int i = 0; i < n; i++)
			ts.add(i);
    	return ts;
    }

    public static TreeSet<Integer> randomTree(int n) {
      	TreeSet<Integer> ts = new TreeSet<Integer>();
       	for (int i = 0; i < n; i++)
       		ts.add((int) Math.random()*n);
    	return ts;
    }
    
    public static Hashtable<Integer,Integer> ascHashTable(int n) {
    	Hashtable<Integer,Integer> ht = new Hashtable<Integer,Integer>();
       	for (int i = 0; i < n; i++)
			ht.put(i, i);
    	return ht;
    }

    public static Hashtable<Integer,Integer> randomHashTable(int n) {
      	Hashtable<Integer,Integer> ht = new Hashtable<Integer,Integer>();
       	for (int i = 0; i < n; i++)
			ht.put(i, (int) Math.random()*n);
    	return ht;
    }
    
    public static List<String> dataStructureComparison(int n) {
    	List<String> list = new ArrayList<String>();
    	HashMap<String, Long> hm = new HashMap<String, Long>();
    	hm.put("ascPriorityQueue", timeOfAscPriorityQueue(n));
    	hm.put("randomPriorityQueue", timeOfRandomPriorityQueue(n));
    	hm.put("ascTree", timeOfAscTree(n));
    	hm.put("randomTree", timeOfRandomTree(n));
    	hm.put("ascHashTable", timeOfAscHashTable(n));
    	hm.put("randomHashTable", timeOfRandomHashTable(n));
    	
    	list.add("ascPriorityQueue");
    	list.add("randomPriorityQueue");
    	list.add("ascTree");
    	list.add("randomTree");
    	list.add("ascHashTable");
    	list.add("randomHashTable");
    	
    	list.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (hm.get(o1) < hm.get(o2))
					return 1;
				if (hm.get(o1) == hm.get(o2))
					return 0;
				else return -1;
			}
		});
    	return list;
    }
    
    public static List<Node> dataStructureComparisonTimesK(int n, int k) {
    	List<Node> list = new ArrayList<Node>();
    	list.add(new Node("ascPriorityQueue", timeOfAscPriorityQueue(k) - timeOfAscPriorityQueue(n)));
    	list.add(new Node("randomPriorityQueue", timeOfRandomPriorityQueue(k) - timeOfRandomPriorityQueue(n)));
    	list.add(new Node("ascTree", timeOfAscTree(k) - timeOfAscTree(n)));
    	list.add(new Node("randomTree", timeOfRandomTree(k) - timeOfRandomTree(n)));
    	list.add(new Node("ascHashTable", timeOfAscHashTable(k) - timeOfAscHashTable(n)));
    	list.add(new Node("randomHashTable", timeOfRandomHashTable(k) - timeOfRandomHashTable(n)));
    	
    	list.sort(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if (o1.k < o2.k)
					return 1;
				if (o1.k == o2.k)
					return 0;
				else return -1;
			}
		});
    	return list;
    }
    static long timeOfAscPriorityQueue(int n) {
    	long start = System.nanoTime();
    	ascPriorityQueue(n);
		return System.nanoTime() - start;
    }
    static long timeOfRandomPriorityQueue(int n) {
    	long start = System.nanoTime();
    	randomPriorityQueue(n);
    	return System.nanoTime() - start;
    }
    static long timeOfAscTree(int n) {
    	long start = System.nanoTime();
    	ascTree(n);
    	return System.nanoTime() - start;
    }
    static long timeOfRandomTree(int n) {
    	long start = System.nanoTime();
    	randomTree(n);
    	return System.nanoTime() - start;
    }
    static long timeOfAscHashTable(int n) {
    	long start = System.nanoTime();
    	ascHashTable(n);
    	return System.nanoTime() - start;
    }
    static long timeOfRandomHashTable(int n) {
    	long start = System.nanoTime();
    	randomHashTable(n);
    	return System.nanoTime() - start;
    }
}