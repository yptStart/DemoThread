package cn.com.yuxin.demo2.lock;

/**
 * ʹ��Lock�ӿ��з������:
 * 	  ģ���̰߳�ȫ����(���̷߳����˹�������ݻ�����̰߳�ȫ����)-��Ʊ����(�����ظ���Ʊ�Ͳ����ڵ�Ʊ)
 * @author ypt
 *
 */
public class Demo1Ticket {

	public static void main(String[] args) {
		//����Runnable�ӿڵ�ʵ�������
		RunnableImpl run = new RunnableImpl();
		//����Thread�����,���췽���д���Runnable�ӿڵ�ʵ�������
		Thread t1 = new Thread(run);
		Thread t2 = new Thread(run);
		Thread t3 = new Thread(run);
		//����start�����������߳�
		t1.start();
		t2.start();
		t3.start();
	}
	
}
