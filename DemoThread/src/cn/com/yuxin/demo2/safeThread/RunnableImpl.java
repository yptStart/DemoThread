package cn.com.yuxin.demo2.safeThread;

/**
 * ʵ����Ʊ����
 */
public class RunnableImpl implements Runnable {

	// ����һ������̹߳����ƱԴ
	private int ticket = 100;
	
	/*
	 * �����߳�����:��Ʊ
	 */
	@Override
	public void run() {
		//ʹ����ѭ������Ʊ�����ظ�ִ��
		while (true) {
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
