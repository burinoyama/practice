package org.vin.sort;

public interface Sorter<T extends Comparable> {

	default void exch(T[] a, int i, int j) {
		T t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	default void show(T[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i] + " ");
		}
		System.out.println();
	}

	/**
	 * positive sequence first parameter should bigger than second one
	 *
	 * @param a
	 * @param b
	 * @return
	 */
	default boolean less(T a, T b) {
		return a.compareTo(b) < 0;
	}

	/**
	 * test the comparable a wether positive sequence
	 *
	 * @param a
	 * @return
	 */
	default boolean isSorted(T[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}

	T[] sort(T[] a);


}
