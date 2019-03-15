import org.vin.sort.Sorter;

public class Quick<T extends Comparable> implements Sorter {


	private int partition(T[] t, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		T v = t[lo];

		while (true) {
			while (less(t[++i], v)){}
			while (less(v, t[--j])){}
			if (i >= j) {
				break;
			}
			exch(t, i, j);
		}
		exch(t, lo, j);
		return j;

	}

	private void sort(T[]a, int lo, int hi) {
		if (lo >= hi) {
			return ;
		}
		int p = partition(a, lo, hi);

		sort(a, lo, p - 1);
		sort(a, p + 1, hi);
	}

	@Override
	public Comparable[] sort(Comparable[] a) {
		sort((T[]) a, 0, a.length - 1);
		return a;
	}
}
