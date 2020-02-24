package thread.producercomsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerBQExecutor {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Integer> block = new LinkedBlockingQueue<Integer>(5);
		
		Thread producer = new Thread(() -> {
			while(true) {
				int value = 0;
				block.add(value++);
				System.out.println("Data Produced : " + block.peek());
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {}
			}			
		});
		
		Thread consumer = new Thread(() -> {
			while(true) {
				int value;
				try {
					value = block.take();
					System.out.println("Data Consumed : " + value);
					Thread.sleep(2000);
				} catch (InterruptedException e1) {}
			}			
		});
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		executor.execute(producer);
		executor.execute(consumer);
		
		executor.shutdown();
	}

}
