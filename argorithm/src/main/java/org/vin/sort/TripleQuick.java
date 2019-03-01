package org.vin.sort;

public class TripleQuick implements Sorter {
	@Override
	public Comparable[] sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
		return a;
	}

	public void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		int lt = lo;
		int i = lo + 1;
		int gt = hi;
		Comparable v = a[lo];
		while (i <= gt) {
			int cmp = a[i].compareTo(v);
			if (cmp > 0) {
				exch(a, i, gt--);
			} else if (cmp < 0) {
				exch(a, lt++, i++);
			} else i++;
		}
		sort(a, lo, lt -1);
		sort(a, gt + 1, hi);
	}
}
