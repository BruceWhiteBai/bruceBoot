package com.bruce.util.thread;


public class A {
	private  B b=new B();
	public void sayhello() throws InterruptedException{

		synchronized (b) {
            System.out.println("1111111111111");
			 b.wait();
            System.out.println("2222222222222");
        }
	}
    public void sayBye() throws InterruptedException{

        synchronized (b) {
            System.out.println("3333333333");
            b.notifyAll();
            System.out.println("44444444444444");
        }
    }
	public static void main(String[] args) throws InterruptedException {
		
		final A a=new A();
        Thread thread0 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    a.sayhello();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread0.start();

		Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                    a.sayBye();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
		thread1.start();
	}
	
}
