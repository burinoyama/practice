package org.vin.sort;

public class Insertion implements Sorter {


	@Override
	public Comparable[] sort(Comparable[] a) {
		int len = a.length;

		for (int i = 1; i < len; i++) {
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
			}
		}
		return a;
	}
}
