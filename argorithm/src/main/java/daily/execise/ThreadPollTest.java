package daily.execise;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPollTest {

	public static void main(String[] args) {


		ExecutorService service = Executors.newCachedThreadPool();

		Future<?> submit = service.submit(new Mytest());

		submit.isDone();


	}
}

class Mytest implements Runnable{
	@Override
	public void run() {
		System.err.println(new Date());
	}
}
