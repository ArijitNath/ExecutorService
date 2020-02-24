package thread.producercomsumer;

public class ProducerConsumerMain {

	public static void main(String[] args) throws InterruptedException {
		ProducerConsumer pc = new ProducerConsumer();
		
		Thread producer = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException e) {}
			}
		});
		
		Thread consumer = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					pc.consume();
				} catch (InterruptedException e) {}
			}
		});
		
		producer.start();
		consumer.start();
		
		producer.join();
		consumer.join();
	}

}
