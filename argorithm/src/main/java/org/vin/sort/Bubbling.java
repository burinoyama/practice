package org.vin.sort;

public class Bubbling implements Sorter {
	@Override
	public Comparable[] sort(Comparable[] a) {
		int len = a.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len - i - 1; j++) {
				if (!less(a[j], a[j + 1])) {
					exch(a, j, j + 1);
				}
			}
		}
		return a;
	}
}
