package org.vin.sort;

public class Merge implements Sorter {
	@Override
	public Comparable[] sort(Comparable[] a) {
		return merge(a, 0, a.length / 2 - 1, a.length);
	}


	/**
	 * 本例子只试用于只有两个有序部分的数组，他们各自的长度不限，但要确定分界点mid的位置
	 *
	 * 这个方法中的for循环中的判断的顺序是不能变得，我开始，把他们变成 3412,这样不仅仅是多写一个判断的问题，
	 *
	 */

	public Comparable[] merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo;
		int j = mid + 1;
		Comparable[] tmp = a;
		a = new Comparable[tmp.length];

		for (int k = 0; k < a.length; k++) {
			if (i > mid) {
				a[k] = tmp[j++];
			} else if (j > hi) {
				a[k] = tmp[i++];
			} else if (less(tmp[i], tmp[j])) {
				a[k] = tmp[i++];
			} else {
				a[k] = tmp[j++];
			}
		}
		return a;
	}
}
