package cn.com.yuxin.demo1.runnable;

public class RunnableImple implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(Thread.currentThread().getName()+i);
		}
	}

}
