package cn.com.yuxin.demo3;

/**
 *���뵽TIMED_WAITING(��ʱ�ȴ�)�����ַ�ʽ
 *	1.ʹ��sleep(long m)����,�ں���ֵ����֮��,�߳�˯�ѽ��뵽Runnable/Blocked״̬
 *	2.ʹ��wait(long m)����,wait��������ں���ֵ����֮��,��û�б�notify����,�ͻ��Զ�����,�߳�˯�ѽ��뵽Runnable/Blocked״̬
 *
 *���ѵķ���:
 *	void notify() �����ڴ˶���������ϵȴ��ĵ����̡߳� 
 *	void notifyAll() �����ڴ˶���������ϵȴ��������̡߳�  
 */
public class Demo2WaitAndNotify {

	public static void main(String[] args) {
		//����������,��֤Ψһ
		Object obj = new Object();
		
		//����һ���˿��߳�(������)--->�˴��õ��Ǵ���Thread������������ڲ��෽ʽʵ�ֶ��߳�
		new Thread(){
			@Override
			public void run() {
				//��֤�ȴ��ͻ��ѵ��߳�ֻ����һ��ִ��,��Ҫʹ��ͬ������
				synchronized (obj) {
					System.out.println("�˿�1-->��֪�ϰ�Ҫ�İ��ӵ����������");
					//����wait����,����cpu��ִ��,���뵽WAITING״̬(���޵ȴ�)
					try {
						obj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					//����֮��ִ�еĴ���
					System.out.println("�˿�1-->�����Ѿ�������,����!");
				}
			}
		}.start();
		
		//����һ���˿��߳�(������)--->�˴��õ��Ǵ���Thread������������ڲ��෽ʽʵ�ֶ��߳�
		new Thread(){
			@Override
			public void run() {
				//��֤�ȴ��ͻ��ѵ��߳�ֻ����һ��ִ��,��Ҫʹ��ͬ������
				synchronized (obj) {
					System.out.println("�˿�2-->��֪�ϰ�Ҫ�İ��ӵ����������");
					//����wait����,����cpu��ִ��,���뵽WAITING״̬(���޵ȴ�)
					try {
						obj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					//����֮��ִ�еĴ���
					System.out.println("�˿�2-->�����Ѿ�������,����!");
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
					//obj.notify(); //����ж���ȴ��߳�,�������һ��
					obj.notifyAll(); //�������еȴ����߳�
				};
			}
		}.start();
	}
	
}