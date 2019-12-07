package cn.com.yuxin.demo2.synchroizedMethod;

/**
 * ��Ʊ�����������̰߳�ȫ����
 * �����˲����ڵ�Ʊ���ظ���Ʊ
 * 
 * ����̰߳�ȫ����ĵڶ��ַ���: ʹ��ͬ������
 * ʹ�ò���:
 * 	  1.�ѷ����˹������ݵĴ����ȡ����,�ŵ�һ��������
 * 	  2.�ڷ��������synchronized���η�
 * 
 * ��ʽ:
 * 	  ���η�  synchronized ����ֵ����  ������(�����б�){
 * 		���ܻ�����̰߳�ȫ����Ĵ���(�����˹������ݵĴ���)
 * 	 }
 */
public class RunnableImpl implements Runnable {

	// ����һ������̹߳����ƱԴ
	private static int ticket = 100;
	
	/*
	 * �����߳�����:��Ʊ
	 */
	@Override
	public void run() {
		//ʹ����ѭ������Ʊ�����ظ�ִ��
		while (true) {
			//payTicket();
			payTicketstatic();
		}
	}

	/**
	 * ����һ��ͬ������:
	 * ͬ������Ҳ��ѷ����ڲ��Ĵ�����ס ,ֻ��һ���߳�ִ��
	 * ͬ����������������˭?
	 * ����ʵ������� new RunnableImpl(), Ҳ����this
	 */
	public synchronized void payTicket() {
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
	
	/**
	 * ��̬��ͬ������:
	 * ��������˭?
	 * ������this,this�Ǵ�������֮�������,��̬���������ڶ���
	 * ��̬�������������Ǳ����class����-->class�ļ�����(RunnableImpl.class)
	 */
	public static synchronized void payTicketstatic() {
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