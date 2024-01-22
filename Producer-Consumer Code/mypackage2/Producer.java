package mypackage2;

import java.util.*;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	BlockingQueue<Integer>product_list=null;
	
	int product_no;
	
	public Producer(BlockingQueue<Integer>product_list) {
		
		this.product_list=product_list;
	}
	
	
	@Override
	public void run() {
		
		while(true) {
			
			try {
				synchronized(this) {
					
					int nextprod= product_no++;
					System.out.println("Added a new product!"+nextprod);
					product_list.put(nextprod);
				}
			}catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}

}
