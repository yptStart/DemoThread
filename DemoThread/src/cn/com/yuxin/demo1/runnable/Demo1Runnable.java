package cn.com.yuxin.demo1.runnable;

/**
 * �������̵߳ĵڶ��ַ�ʽ: ʵ��Runnable�ӿ�
 * java.lang.Runnable�ӿ�:
 * 	  Runnable�ӿ�Ӧ���κ���ʵ�֣���ʵ�������߳�ִ�С� ������붨��һ���޲����ķ�������Ϊrun 
 * java.lang.Thread��Ĺ��췽��:
 * 	  Thread(Runnable target) ����һ���µ� Thread����  
 * 	  Thread(Runnable target, String name) ����һ���µ� Thread����
 * ʵ�ֲ���:
 * 1.����һ��Runnable�ӿڵ�ʵ����
 * 2.��ʵ��������дRunnable�ӿڵ�run����,�����߳�����
 * 3.����һ��Runnable�ӿڵ�ʵ�������
 * 4.����Thread�����,���췽���д���Runnable�ӿڵ�ʵ�������
 * 5.����Thread���start����,�����µ��߳�ִ��run����
 * 
 * ʵ��Runnable�ӿڴ����������̳߳���ĺô�:
 * 	  1.�����˵��̳еľ�����
 * 		 һ����ֻ�ܼ̳�һ����(һ����ֻ����һ���׵�),��̳���Thread��Ͳ��ܼ̳���������
 * 		ʵ����Runnable�ӿ�,�����Լ̳���������,ʵ�������Ľӿ�
 * 	  2.��ǿ�˳������չ��,�����˳���������(����)
 * 		ʵ��Runnable�ӿڵķ�ʽ,�������߳�����Ϳ������߳̽����˷���(����)
 * 		ʵ������,��д��run����:���������߳�����
 * 		����Thread�����,����start����:���������߳�
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
