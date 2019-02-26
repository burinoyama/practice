package org.vin.sort;

public class Chosen implements Sorter {


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

	public Comparable[] betterChosenSort(Comparable[] a) {
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
}
