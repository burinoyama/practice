import org.junit.Test;

public class PlayGround {

	Integer[] a = {5, 9, 1, 4, 7, 2, 3, 8};

	@Test
	public void runQuick() {
		Quick<Integer> quick = new Quick<>();
		quick.show(quick.sort(a));
	}
}
