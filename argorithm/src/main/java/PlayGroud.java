import daily.execise.DoubleStackDijkstra;
import daily.execise.ReplaceBlank;

public class PlayGroud {

	public static void main(String[] args) {
//		System.out.println(new ReplaceBlank().repalceSpace(new StringBuffer("we are the world")));
		String command = "((1+3)*(6-3))";
		System.out.println(new DoubleStackDijkstra().calculat(command));

	}
}
