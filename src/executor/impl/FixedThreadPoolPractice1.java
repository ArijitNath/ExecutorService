package executor.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolPractice1 {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		
		for(int i = 0; i < 10; i++) {
			executor.execute(() -> {
				System.out.println("Arijit");
			});
		}
				
		executor.shutdown();
	}

}
