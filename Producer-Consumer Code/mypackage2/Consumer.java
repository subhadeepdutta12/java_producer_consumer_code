package mypackage2;

import java.util.*;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	BlockingQueue<Integer>product_list=null;
	
	int product_no;
	
	public Consumer(BlockingQueue<Integer>product_list) {
		
		this.product_list=product_list;
	}
	
	@Override
	public void run() {
		
		while(true) {
			
			try {
				
				Thread.sleep(1000);
				System.out.println("Taken the product! "+product_list.take());
			}catch(InterruptedException e){
				
				e.printStackTrace();
				
			}
		}
	}

}
