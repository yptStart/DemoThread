package cn.com.yuxin.demo1.thread;

public class MyThread extends Thread {

	public MyThread() {
	}
	
	public MyThread(String name) {
		super(name);
	}

	public void run() {
		String name = getName();
		for (int i = 0; i < 10; i++) {
			System.out.println(name+"run"+i);
		}
	}
	
}
