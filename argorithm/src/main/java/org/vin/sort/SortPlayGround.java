package org.vin.sort;

import org.junit.Test;

public class SortPlayGround {

	Integer[] a = {2, 3, 6, 1, 4, 7, 8};
	Integer[] b = {-1, 3, 6, 1, 4, 7, 8};
	Integer[] forPartialMerge = {1, 3, 5, 2, 4, 8};


	@Test
	public void runTripleQuick() {
		TripleQuick quick = new TripleQuick();
		quick.show(quick.sort(a));
	}

	@Test
	public void runQucik() {
		Quick quick = new Quick();
		quick.show(quick.sort(b));
	}


	@Test
	public void runMerge(){
		Merge merge = new Merge();
		merge.show(merge.sort(a));
	}


	@Test
	public void runPartialMerge() {
		Merge merge = new Merge();
		merge.show(merge.sort(forPartialMerge));
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
