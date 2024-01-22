package mypackage;

import java.util.*;

public class Producer implements Runnable {
	
	List<Integer>product_list=null;
	int limit= 5;
	int product_no;
	
	public Producer(List<Integer>product_list) {
		
		this.product_list=product_list;
	}
	
	
	public void SeeProduct(int product_no) throws InterruptedException{
		
		//lock on product list
		synchronized(product_list) {
			
			while(product_list.size()==limit) {
				
				System.out.println("Demand Overload!");
				product_list.wait();
			}
		}
		
		synchronized(product_list) {
			
			System.out.println("New Product: "+product_no);
			product_list.add(product_no);
			Thread.sleep(100);
			product_list.notify();
		}
	}
	
	
	@Override
	public void run() {
		
		while(true) {
			
			try {
				SeeProduct(product_no);
				product_no++;
			}catch(InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}

	

}
