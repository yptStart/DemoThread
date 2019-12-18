package cn.com.yuxin.demo1.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * �̳߳�:JDK1.5֮���ṩ��
 * java.util.concurrent.Executors: �̳߳صĹ�����,���������̳߳�
 * Executors���еľ�̬����:
 * 	  static ExecutorService newFixedThreadPool(int nThreads) ����һ�������ù̶��߳������̳߳ء� 
 * 	     ����: int nThreads �����̳߳��а������߳�����
 * 	     ����ֵ: ExecutorService�ӿ�,���ص���ExecutorService�ӿڵ�ʵ�������,���ǿ���ʹ��ExecutorService�ӿڽ���(����ӿڱ��)
 * java.util.concurrent.ExecutorService: �̳߳ؽӿ�
 * 	     �������̳߳��л�ȡ�߳�,����start����,ִ���߳�����
 *	  	submit(Runnable task) �ύһ��  Runnable ��������ִ��
 *	    �ر�/�����̳߳صķ���
 *		void shutdown()  
 * �̳߳ص�ʹ�ò���:
 * 	  1.ʹ���̳߳صĹ�����Executors�ṩ�ľ�̬����newFixedThreadPool����һ��ָ���߳��������̳߳�
 * 	  2.����һ����,ʵ��Runnable�ӿ�,��дrun����,�����߳�����
 * 	  3.����ExecutorService�еķ���submit,�����߳�����(ʵ����),�����߳�,ִ��run����
 * 	  4.����ExecutorService�еķ���shutdown�����̳߳�(������ִ��)
 * @author ypt
 */
public class Demo1ThreadPool {

	public static void main(String[] args) {
		//1.ʹ���̳߳صĹ�����Executors�ṩ�ľ�̬����newFixedThreadPool����һ��ָ���߳��������̳߳�
		ExecutorService es = Executors.newFixedThreadPool(2);
		//3.����ExecutorService�еķ���submit,�����߳�����(ʵ����),�����߳�,ִ��run����
		es.submit(new RunnableImpl());//pool-1-thread-1������һ���µ��߳�ִ��
		//�̳߳ػ�һֱ����,ʹ�������߳�,���Զ����̹߳黹���̳߳�,�߳̿��Լ���ʹ��
		es.submit(new RunnableImpl());//pool-1-thread-2������һ���µ��߳�ִ��
		es.submit(new RunnableImpl());//pool-1-thread-1������һ���µ��߳�ִ��
		
		//4.����ExecutorService�еķ���shutdown�����̳߳�(������ִ��)
		es.shutdown();
		
		es.submit(new RunnableImpl());//�׳��쳣,�̳߳ض�û��,�Ͳ��ܻ�ȡ�߳���
	}
	
}
