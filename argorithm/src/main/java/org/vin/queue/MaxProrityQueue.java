package org.vin.queue;

public class MaxProrityQueue <T extends Comparable>{

	private T[] pq;
	private int N = 0;

	public MaxProrityQueue(int max) {
		this.pq = new T[max + 1];
	}

	public boolean isEmpty() {
		return this.N == 0;
	}

	public int size() {
		return this.N;
	}

	public boolean insert(T v) {
		this.pq[++N] = v;
		try {
			swim(this.N);
		} catch (Exception ex) {
			return false;
		}
		return true;

	}

	public Comparable delMax() {
		Comparable max = pq[1];
		exch(1, N--);
		pq[++N] = null;
		sink(1);
		return max;
	}


	private void exch(int i, int j) {
		T t = this.pq[i];
		this.pq[i] = this.pq[j];
		this.pq[j] = t;
	}

	private boolean less(int i, int j) {
		return this.pq[i].compareTo(this.pq[j]) < 0;
	}


	private void swim(int n) {
		while (n > 1 && less(n, n / 2)) {
			exch(n, n / 2);
			n /= 2;
		}

	}

	private void sink(int k) {
		while (2 * k <= this.N) {
			int j = 2 * k;
			if (j < this.N && less(j, j + 1)) {
				j++;
			}
			if (!less(k, j)) {
				break;
			}
			exch(k, j);
			k = j;
		}
	}
}
