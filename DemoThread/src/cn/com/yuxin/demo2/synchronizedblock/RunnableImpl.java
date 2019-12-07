package cn.com.yuxin.demo2.synchronizedblock;

/**
 * ��Ʊ�����������̰߳�ȫ����
 * �����˲����ڵ�Ʊ���ظ���Ʊ
 * 
 * ����̰߳�ȫ����ĵ�һ�ַ���: ʹ��ͬ�������
 * ��ʽ:
 * 	  synchronized(������){
 * 		���ܻ�����̰߳�ȫ����Ĵ���(�����˹������ݵĴ���)
 * 	  }
 * 		
 * ע��:
 * 	  1.ͨ��������е�������,����ʹ������Ķ���
 * 	  2.���Ǳ��뱣֤����߳�ʹ�õ���������ͬһ��
 * 	  3.����������:
 * 		     ��ͬ���������ס,ֻ��һ���߳���ͬ���������ִ��
 */
public class RunnableImpl implements Runnable {

	// ����һ������̹߳����ƱԴ
	private int ticket = 100;
	
	// ����һ��������
	Object obj = new Object();
	
	/*
	 * �����߳�����:��Ʊ
	 */
	@Override
	public void run() {
		//ʹ����ѭ������Ʊ�����ظ�ִ��
		while (true) {
			//ͬ�������
			synchronized (obj) {
				if (ticket > 0) {
					//��߰�ȫ������ֵĸ���,�ó���˯��10����
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"-->��������"+ticket+"��Ʊ");
					ticket--;
				}
			}
		}
	}

}
