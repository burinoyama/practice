package org.vin.sort;

public class Merge implements Sorter {

	private Comparable[] aux = null;

	@Override
	public Comparable[] sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
		return a;
	}


	public void sort(Comparable[] a, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		aux = new Comparable[a.length];
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid);
		sort(a, mid + 1, hi);
		merge(a, lo, mid, hi);
	}


	/**
	 * 本方法只试用于只有两个有序部分的数组，他们各自的长度不限，但要确定分界点mid的位置
	 * 是归并排序的一部分
	 * <p>
	 * 这个方法中的for循环中的判断的顺序是不能变得，我开始，把他们变成 3412,这样不仅仅是多写一个判断的问题，
	 */

	public Comparable[] merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo;
		int j = mid + 1;
		aux = a;
		a = new Comparable[aux.length];

		for (int k = 0; k < a.length; k++) {
			if (i > mid) {
				a[k] = aux[j++];
			} else if (j > hi) {
				a[k] = aux[i++];
			} else if (less(aux[i], aux[j])) {
				a[k] = aux[i++];
			} else {
				a[k] = aux[j++];
			}
		}
		return a;
	}
}
