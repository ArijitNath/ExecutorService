package thread.producercomsumer;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {
	
	private List<Integer> data;
	private int capacity;
	private int value = 0;
	
	public ProducerConsumer() {
		this.capacity = 5;
		this.data = new ArrayList<>();
	}
	
	public void produce() throws InterruptedException {		
		while( true ) {
			synchronized (this) {
				if(data.size() == capacity)
					wait();
				
				System.out.println("Value produced : " + value);
				data.add(value++);
				
				notify();
				Thread.sleep(2000);
			}
		}
	}
	
	public void consume() throws InterruptedException {
		while( true ) {
			synchronized (this) {
				if(data.size() == 0)
					wait();
				
				System.out.println("Value consumed : " + data.get(data.size() - 1));
				data.remove(data.size() - 1);
				
				notify();
				Thread.sleep(2000);
			}
		}
	}
}
