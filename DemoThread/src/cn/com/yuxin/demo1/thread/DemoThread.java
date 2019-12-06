package cn.com.yuxin.demo1.thread;

/**
 * �������̵߳ĵ�һ�ַ�ʽ: ����Thread�������
 * java.lang.Thread��:�������̵߳���,������Ҫʵ�ֶ��̵߳ĳ���,�ͱ���̳�Thread��
 * ʵ�ֲ���:
 * 1.����һ��Thread�������
 * 2.��Thread�����������дThread�е�run����,�����߳�����(�����߳�Ҫ��ʲô)
 * 3.����Thread�������Ķ���
 * 4.����Thread���е�start����,�����µ��߳�,ִ��run������ 
 * 	  void start() ���´��߳̿�ʼִ��; Java��������ô��̵߳�run������ 
 *    ����������߳�ͬʱ���У���ǰ�̣߳�main�̣߳�����һ���̣߳����������߳�,ִ����run�������� 
 *    �������һ���߳��ǲ��Ϸ��ġ� �ر��ǵ��߳��Ѿ�����ִ�к�,���������������� 
 * java����������ռʽ����,�ĸ��̵߳����ȼ���,�ĸ��߳̾�����ִ��;ͬһ�����ȼ�,���ѡ��һ���߳����ִ��   
 * @author ypt
 *
 */
public class DemoThread {

	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		t1.setName("С��");
		t1.start();  
		
		String name = Thread.currentThread().getName();
		for (int i = 0; i < 10; i++) {
			System.out.println(name+i);
		}
		
		MyThread t2 = new MyThread("����");
		t2.start();
		System.out.println("��ͦ��");
		System.out.println("���첻��Ӱ���");
	}
}
