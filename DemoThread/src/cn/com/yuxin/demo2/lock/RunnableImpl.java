package cn.com.yuxin.demo2.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ��Ʊ�����������̰߳�ȫ����
 * �����˲����ڵ�Ʊ���ظ���Ʊ
 * 
 * ����̰߳�ȫ����ĵ����ַ���: ʹ��Lock��
 * java.util.concurrent.locks.Lock�ӿ�
 * Lockʵ���ṩ�˱�ʹ��synchronized�����������Ի�õĸ��㷺������������
 * Lock�ӿ��еķ���:
 * 	 void lock() �������
 *   void unlock() �ͷ�����  
 * java.util.concurrent.locks.ReentrantLock ʵ����  Lock�ӿ�
 * 
 * ʹ�ò���:
 * 	  1.�ڳ�Աλ�ô���һ��ReentrantLock����
 * 	  2.�ڿ��ܻ�����̰߳�ȫ����Ĵ���ǰ����Lock�ӿ��еķ���lock()�����
 * 	  3.�ڿ��ܻ�����̰߳�ȫ����Ĵ�������Lock�ӿ��еķ���unlock()�ͷ���
 */
public class RunnableImpl implements Runnable {

	// ����һ������̹߳����ƱԴ
	private int ticket = 100;
	
	//1.�ڳ�Աλ�ô���һ��ReentrantLock����
	Lock l = new ReentrantLock();
	
	
	/*
	 * �����߳�����:��Ʊ
	 */
	@Override
	public void run() {
		//ʹ����ѭ������Ʊ�����ظ�ִ��
		while (true) {
			//2.�ڿ��ܻ�����̰߳�ȫ����Ĵ���ǰ����Lock�ӿ��еķ���lock()�����
			l.lock();
			if (ticket > 0) {
				try {
					//��߰�ȫ������ֵĸ���,�ó���˯��10����
					Thread.sleep(10);
					System.out.println(Thread.currentThread().getName()+"-->��������"+ticket+"��Ʊ");
					ticket--;
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					//3.�ڿ��ܻ�����̰߳�ȫ����Ĵ�������Lock�ӿ��еķ���unlock()�ͷ���
					l.unlock(); //���۳����Ƿ�����쳣,��������ͷ�
				}
			}
		}
	}

}