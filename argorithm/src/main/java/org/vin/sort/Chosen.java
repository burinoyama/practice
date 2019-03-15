package org.vin.sort;

public class Chosen<T extends Comparable> implements Sorter {


	public T[] betterChosenSort(T[] a) {
		int len = a.length;
		for (int i = 0; i < len; i++) {
			int min = i;
			for (int j = i; j < len; j++) {
				if (less(a[j], a[min])) {
					min = j;
				}
			}
			exch(a, i, min);
		}
		return a;
	}

	@Override
	public Comparable[] sort(Comparable[] a) {
		int len = a.length;
		for (int i = 0; i < len; i++) {
			int min = i;
			for (int j = i; j < len; j++) {
				if (less(a[j], a[min])) {
					exch(a, j, min);
				}
			}
		}
		return a;
	}
}
