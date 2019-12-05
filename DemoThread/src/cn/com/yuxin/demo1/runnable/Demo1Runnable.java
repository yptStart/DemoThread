package cn.com.yuxin.demo1.runnable;

/**
 * 创建多线程的第二种方式: 实现Runnable接口
 * java.lang.Runnable接口:
 * 	  Runnable接口应由任何类实现，其实例将由线程执行。 该类必须定义一个无参数的方法，称为run 
 * java.lang.Thread类的构造方法:
 * 	  Thread(Runnable target) 分配一个新的 Thread对象。  
 * 	  Thread(Runnable target, String name) 分配一个新的 Thread对象。
 * 实现步骤:
 * 1.创建一个Runnable接口的实现类
 * 2.在实现类中重写Runnable接口的run方法,设置线程任务
 * 3.创建一个Runnable接口的实现类对象
 * 4.创建Thread类对象,构造方法中传递Runnable接口的实现类对象
 * 5.调用Thread类的start方法,开启新的线程执行run方法
 * 
 * 实现Runnable接口创建创建多线程程序的好处:
 * 	  1.避免了单继承的局限性
 * 		 一个类只能继承一个类(一个人只能有一个亲爹),类继承了Thread类就不能继承其他的类
 * 		实现了Runnable接口,还可以继承其他的类,实现其他的接口
 * 	  2.增强了程序的扩展性,降低了程序的耦合性(解耦)
 * 		实现Runnable接口的方式,把设置线程任务和开启新线程进行了分离(解耦)
 * 		实现类中,重写了run方法:用来设置线程任务
 * 		创建Thread类对象,调用start方法:用来开启线程
 * @author ypt
 *
 */
public class Demo1Runnable {

	public static void main(String[] args) {
		RunnableImple rm = new RunnableImple();
		Thread t = new Thread(rm);
		Thread t1 = new Thread(new RunnableImple2());
		t.start();
		t1.start();
		
		for (int i = 0; i < 20; i++) {
			System.out.println(Thread.currentThread().getName()+i);
		}
	}
}
