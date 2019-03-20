import java.io.*;
import java.util.Random;

public class WriteRandomNumber {

	public static void main(String[] args) throws IOException {

		int count = 0;

		File file = new File("G:/big.txt");

		FileOutputStream out = new FileOutputStream(file);

		OutputStreamWriter writer1 = new OutputStreamWriter(out, "utf-8");

		BufferedWriter writer = new BufferedWriter(writer1);

		while (true) {
			if (count < 20000000000L) {
				int num = new Random().nextInt();
				writer.write(num + "\n");
				count++;
			}
		}

	}
}
