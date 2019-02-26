package org.vin.sort;

public interface Sorter {

	default void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	default void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i] + " ");
		}
		System.out.println();
	}

	/**
	 * positive sequence first parameter should bigger than second one
	 * @param a
	 * @param b
	 * @return
	 */
	default boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}

	/**
	 * test the comparable a wether positive sequence
	 *
	 * @param a
	 * @return
	 */
	default boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}

	Comparable[] sort(Comparable[] a);


}
