package mypackage;

import java.util.*;

public class Consumer implements Runnable {

	List<Integer>product_list=null;
	int limit= 5;
	int product_no;
	
	public Consumer(List<Integer>product_list) {
		
		this.product_list=product_list;
	}
	
	public void TakeProduct() throws InterruptedException{
		
		synchronized(product_list) {
			
			while(product_list.isEmpty()) {
				
				System.out.println("No products to take!");
				product_list.wait();
			}
		}
		
		synchronized(product_list) {
			
			Thread.sleep(5000);
			System.out.println("Taken product "+product_list.remove(0));
			
			product_list.notify();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
