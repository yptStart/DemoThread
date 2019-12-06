package cn.com.yuxin.demo1.innerThread;

/**
 * �����ڲ��෽ʽʵ���̵߳Ĵ���
 * 
 * ����: û������
 * �ڲ���:д���������ڲ�����
 * 
 * �����ڲ�������:�򻯴���
 * 	  ������̳и���,��д����ķ���,�����������ϳ�һ�����
 * 	  ��ʵ����ʵ�ֽӿ�,��д�ӿ��еķ���,����ʵ�������ϳ�һ�����
 * �����ڲ�������ղ���: ����/ʵ�������,�������û������
 * 
 * ��ʽ:
 * 	  new ����/�ӿ�(){
 * 		��д����/�ӿ��еķ���
 * 	  };
 * 
 * @author ypt
 *
 */
public class InnerClassThread {
	
	public static void main(String[] args) {
		
		//�̵߳ĸ�����Thread  new MyThread().start();
		new Thread(){
			//��дrun()����,�����߳����� 
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName()+"------>����");
				}
			}
		}.start();
		
		//�̵߳Ľӿ�runnable  Runnable r = new RunnableImpl(); ��̬
		Runnable r = new Runnable() {
			//��дrun()����,�����߳�����
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName()+"------>����Ա");
				}
			} 
		};
		new Thread(r).start();
		
		//�򻯽ӿڵķ�ʽ
		new Thread(new Runnable() {
			//��дrun()����,�����߳�����
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName()+"------>��ֵ����");
				}
			} 
		}).start();
	}

}
