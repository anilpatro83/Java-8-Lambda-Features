package com.lambda;

public class LamdaDemo {

	public static void main(String[] args) {
		LamdaDemo lamdaDemo = new LamdaDemo();
		lamdaDemo.greet(()->System.out.println("Hello World !!!"));
		System.out.println(lamdaDemo.add((a,b)->a+b));
		Thread t = new Thread(()-> System.out.println("Runnable"));
		t.start();
	}
	
	@FunctionalInterface
	interface Greeting{
		public void perform();
	}

	public void greet(Greeting greeting) {
		greeting.perform();
	}
	@FunctionalInterface
	interface ArithmaticOperation{
		int add(int a, int b);
	}
	public int add(ArithmaticOperation arithmaticOperation) {
		return arithmaticOperation.add(5, 6);
	}

}
