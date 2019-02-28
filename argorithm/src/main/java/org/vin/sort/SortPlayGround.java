package org.vin.sort;

import org.junit.Test;

public class SortPlayGround {

	Integer[] a = {2, 3, 6, 1, 4, 7, 8};
	Integer[] forMerge = {1, 3, 5, 2, 4, 8};


	@Test
	public void runMerge() {
		Merge merge = new Merge();
		merge.show(merge.sort(forMerge));
	}

	@Test
	public void runShell() {
		Shell shell = new Shell();
		shell.show(shell.sort(a));
	}

	@Test
	public void runChosen() {
		Chosen chosen = new Chosen();
		chosen.show(chosen.sort(a));
	}

	@Test
	public void runInsertion() {
		Insertion insertion = new Insertion();
		insertion.show(insertion.sort(a));
	}


}
