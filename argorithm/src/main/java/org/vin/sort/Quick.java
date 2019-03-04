package org.vin.sort;

public class Quick implements Sorter {


	//忽略这个注解
	@Override
	public Comparable[] sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
		return a;
	}

	public void sort(Comparable[] a, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);

	}

	private int partition(Comparable[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		Comparable v = a[lo];
		while (true) {
			// less 是比较两个数的大小
			while (less(a[++i], v)) {};
			while (less(v, a[--j])) {};
			if (i >= j) {
				break;
			}
			//exch是交换指定数组中两个位置的元素
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}
}
