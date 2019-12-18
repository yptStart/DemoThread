package cn.com.yuxin.demo1.threadPool;

/**
 * 2.创建一个类,实现Runnable接口,重写run方法,设置线程任务
 * @author ypt
 *
 */
public class RunnableImpl implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"创建了一个新的线程执行");
	}

}
