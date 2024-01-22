package mypackage;

import java.util.*;

public class Practice {

	public static void main(String[] args) {
		
		
		List<Integer>product_list= new ArrayList<>();
		
		Thread t1= new Thread(new Producer(product_list));
		
		Thread t2= new Thread(new Producer(product_list));
		
		
		t1.start();
		t2.start();

	}

}
