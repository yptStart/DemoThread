package cn.com.yuxin.demo1.thread;

/**
 * 创建多线程的第一种方式: 创建Thread类的子类
 * java.lang.Thread类:是描述线程的类,我们想要实现多线程的程序,就必须继承Thread类
 * 实现步骤:
 * 1.创建一个Thread类的子类
 * 2.在Thread类的子类中重写Thread中的run方法,设置线程任务(开启线程要做什么)
 * 3.创建Thread类的子类的对象
 * 4.调用Thread类中的start方法,开启新的线程,执行run方法。 
 * 	  void start() 导致此线程开始执行; Java虚拟机调用此线程的run方法。 
 *    结果是两个线程同时运行：当前线程（main线程）和另一个线程（创建的新线程,执行其run方法）。 
 *    多次启动一个线程是不合法的。 特别是当线程已经结束执行后,不会在重新启动。 
 * java程序属于抢占式调度,哪个线程的优先级高,哪个线程就优先执行;同一个优先级,随机选择一个线程随机执行   
 * @author ypt
 *
 */
public class DemoThread {

	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		t1.setName("小王");
		t1.start();  
		
		String name = Thread.currentThread().getName();
		for (int i = 0; i < 10; i++) {
			System.out.println(name+i);
		}
		
		MyThread t2 = new MyThread("旺财");
		t2.start();
		System.out.println("都挺好");
		System.out.println("今天不想加班了");
	}
}
