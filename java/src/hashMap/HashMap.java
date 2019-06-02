package hashMap;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMap<K, V> {
	class Node {
		K key;
		V value;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	LinkedList<Node>[] bucketArray;
	int size;

	public HashMap() {
		this(5);
	}

	public HashMap(int cap) {
		this.bucketArray = new LinkedList[cap];
		this.size = 0;
		for (int i = 0; i < bucketArray.length; i++) {
			this.bucketArray[i] = new LinkedList<>();
		}
	}

	public void put(K key, V value) {
		int bi = getBi(key);
		LinkedList<Node> bucket = this.bucketArray[bi];

		int si = findInBucket(bucket, key);
//		System.out.println(si+" "+bi);
		if (si == -1) {
			Node nn = new Node(key, value);
			bucket.addLast(nn);
			this.size++;
		} else {
			Node nn = bucket.get(si);
//			System.out.println(nn.key);//just to check
			nn.value = value;
		}

		double avgSize = 1.0 * this.size / this.bucketArray.length;
//		System.out.println(avgSize);
		if (avgSize > 2.0) {
			reHash();
		}

	}

	public ArrayList<K> Allkeys() {
		ArrayList<K> ml = new ArrayList<>();
		for (int i = 0; i < bucketArray.length; i++) {
			LinkedList<Node> bucket = this.bucketArray[i];
			for (int j = 0; j < bucket.size(); j++) {
				K k = bucket.get(j).key;
//				System.out.println(k);
				ml.add(k);
			}

		}

		return ml;
	}

	private void reHash() {
		LinkedList<Node>[] oba = this.bucketArray;
		this.bucketArray = new LinkedList[2 * oba.length];
		this.size = 0;
		for (int i = 0; i < bucketArray.length; i++) {
			this.bucketArray[i] = new LinkedList<HashMap<K, V>.Node>();

		}

		for (int i = 0; i < oba.length; i++) {

			LinkedList<Node> bucket = oba[i];
			for (int j = 0; j < bucket.size(); j++) {
				Node mn = bucket.get(i);
				this.put(mn.key, mn.value);
			}
		}
	}

	public V removeKey(K key) {
		int bi = this.getBi(key);

		LinkedList<Node> bucket = this.bucketArray[bi];
		int si = this.findInBucket(bucket, key);
		V mv = null;
		if (si != -1) {
			this.size--;
			mv = bucket.get(si).value;
			bucket.remove(si);
		}

		return mv;

	}

	public boolean containsKey(K key) {
		int bi = this.getBi(key);

		LinkedList<Node> bucket = this.bucketArray[bi];
		int si = this.findInBucket(bucket, key);
		return si != -1;

	}

	public V get(K key) {

		int bi = this.getBi(key);

		LinkedList<Node> bucket = this.bucketArray[bi];
		int si = this.findInBucket(bucket, key);
		V mv = null;
		if (si != -1) {
			mv = bucket.get(si).value;
		}

		return mv;
	}

	public int getBi(K key) {
		return Math.abs(key.hashCode()) % this.bucketArray.length;
	}

	public int findInBucket(LinkedList<Node> bucket, K key) {

		for (int i = 0; i < bucket.size(); i++) {
			if (bucket.get(i).key.equals(key)) {
				return i;
			}
		}
		return -1;

	}

	public void display() {
		for (int i = 0; i < bucketArray.length; i++) {
			System.out.print("Bucket " + i + ": ");

			LinkedList<Node> bucket = bucketArray[i];
			for (int j = 0; j < bucket.size(); j++) {
				Node mn = bucket.get(j);
				System.out.print(mn.key + "@" + mn.value + ", ");
			}
			System.out.println();
		}
	}

}
