package cn.com.yuxin.demo1.threadPool;

/**
 * 2.����һ����,ʵ��Runnable�ӿ�,��дrun����,�����߳�����
 * @author ypt
 *
 */
public class RunnableImpl implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"������һ���µ��߳�ִ��");
	}

}
