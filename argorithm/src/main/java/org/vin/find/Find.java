package org.vin.find;

public class Find {

	/**
	 * best solution
	 */
	public boolean bestFind(int target, int[][] array) {
		int len = array.length - 1;
		int i = 0;
		while ((len >= 0) && (i < array[0].length)) {
			if (array[len][i] > target) {
				len--;
			} else if (array[len][i] < target) {
				i++;
			} else {
				return true;
			}
		}
		return false;
	}

	public boolean run(int target, int[][] array) {
		for (int[] ints : array) {
			if (ints[0] > target || ints[ints.length - 1] < target) {
				continue;
			} else {
				return binarySearch(target, ints, 0, ints.length);
			}
		}
		return false;
	}

//	private boolean binarySearch(int target, int[] arr, int lo, int hi) {
//		while (hi >= lo) {
//			int mid = (hi - lo) / 2 + 1;
//			if (arr[mid] > target) {
//				return binarySearch(target, arr, lo, mid - 1);
//			} else if (arr[mid] < target) {
//				return binarySearch(target, arr, mid + 1, hi);
//			} else {
//				System.err.println(mid);
//				return true;
//			}
//		}
//		return false;
//	}

	public boolean Find(int target, int[][] array) {
		for (int i = 0; i < array.length; i++) {
			int[] subarr = array[i];
			if (subarr[0] > target || subarr[subarr.length - 1] < target) {
				continue;
			} else {
//				return binarySearch(target, subarr, 0, subarr.length);
				int rank = rank(target, subarr);
				if (rank > -1) {
					return true;
				} else {
					continue;
				}
			}
		}
		return false;
	}

	public boolean binarySearch(int target, int[] arr, int lo, int hi) {
		while (hi >= lo) {
			int mid = lo + (hi - lo) / 2;
			System.err.println(mid);
			if (arr[mid] > target) {
				binarySearch(target, arr, mid + 1, hi);
			} else if (arr[mid] < target) {
				binarySearch(target, arr, lo, mid - 1);
			} else {
				System.err.println(mid);
				return true;
			}
		}
		return false;
	}

	public int rank(int key, int[] a) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (a[mid] < key) {
				lo = mid + 1;
			} else if (a[mid] > key) {
				hi = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
