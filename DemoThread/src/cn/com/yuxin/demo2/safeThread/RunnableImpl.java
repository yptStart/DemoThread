package cn.com.yuxin.demo2.safeThread;

/**
 * 实现卖票案例
 */
public class RunnableImpl implements Runnable {

	// 定义一个多个线程共享的票源
	private int ticket = 100;
	
	/*
	 * 设置线程任务:卖票
	 */
	@Override
	public void run() {
		//使用死循环让卖票操作重复执行
		while (true) {
			if (ticket > 0) {
				//提高安全问题出现的概率,让程序睡眠10毫秒
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"-->正在卖第"+ticket+"张票");
				ticket--;
			}
		}
	}

}
