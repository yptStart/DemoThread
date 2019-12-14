package cn.com.yuxin.demo3;

/*
 * �ȴ����Ѱ���: �߳�֮���ͨ��
 * 	 ����һ���˿��߳�(������): ��֪�ϰ�Ҫ�İ��ӵ����������,����wait����,����cpu��ִ��,���뵽WAITING״̬(���޵ȴ�)
 * 	 ����һ���ϰ��߳�(������): ����5����������,���ð���֮��,����notify����,���ѹ˿ͳ԰���
 * 
 * ע��:
 * 	 �˿ͺ��ϰ��̱߳���ʹ��ͬ��������������,��֤�ȴ��ͻ���ֻ����һ���߳���ִ��
 * 	 ͬ��ʹ�õ���������뱣֤Ψһ
 * 	 ֻ����������ܵ���wait��notify����
 * 
 * Object���еķ���:
 * 	 void wait() �������̵߳��ô˶���� notify()������ notifyAll()����ǰ,���µ�ǰ�̵߳ȴ���  
 *	 void notify() �����ڴ˶���������ϵȴ��ĵ����̡߳�  �����ִ��wait����֮��Ĵ��� 
 *
 */
public class Demo1WaitAndNotify {

	public static void main(String[] args) {
		//����������,��֤Ψһ
		Object obj = new Object();
		
		//����һ���˿��߳�(������)--->�˴��õ��Ǵ���Thread������������ڲ��෽ʽʵ�ֶ��߳�
		new Thread(){
			@Override
			public void run() {
				//��֤�ȴ��ͻ��ѵ��߳�ֻ����һ��ִ��,��Ҫʹ��ͬ������
				synchronized (obj) {
					System.out.println("��֪�ϰ�Ҫ�İ��ӵ����������");
					//����wait����,����cpu��ִ��,���뵽WAITING״̬(���޵ȴ�)
					try {
						obj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					//����֮��ִ�еĴ���
					System.out.println("�����Ѿ�������,����!");
				}
			}
		}.start();
		
		//����һ���ϰ��߳�(������)
		new Thread(){
			@Override
			public void run() {
				//����5����������
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//��֤�ȴ��ͻ��ѵ��߳�ֻ����һ��ִ��,��Ҫʹ��ͬ������
				synchronized (obj) {
					System.out.println("�ϰ�5����֮�����ð���,��֪�˿Ϳ��Գ԰�����");
					//���ð���֮��,����notify����,���ѹ˿ͳ԰���
					obj.notify();
				};
			}
		}.start();
	}
	
}