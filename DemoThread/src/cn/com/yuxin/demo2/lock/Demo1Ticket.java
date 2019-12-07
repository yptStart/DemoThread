package cn.com.yuxin.demo2.lock;

/**
 * 使用Lock接口中方法解决:
 * 	  模拟线程安全问题(多线程访问了共享的数据会产生线程安全问题)-卖票案例(出现重复的票和不存在的票)
 * @author ypt
 *
 */
public class Demo1Ticket {

	public static void main(String[] args) {
		//创建Runnable接口的实现类对象
		RunnableImpl run = new RunnableImpl();
		//创建Thread类对象,构造方法中传递Runnable接口的实现类对象
		Thread t1 = new Thread(run);
		Thread t2 = new Thread(run);
		Thread t3 = new Thread(run);
		//调用start方法开启多线程
		t1.start();
		t2.start();
		t3.start();
	}
	
}
