package cn.com.yuxin.demo3.waitAndNotify;

/*
 * ������:
 * ����main����,����ִ�е����,��������
 * �������Ӷ���;
 * �����������߳�,����,��������;
 * �����Ի��߳�,����,�԰���;
 */
public class DemoTest {
	
	public static void main(String[] args) {
		//�������Ӷ���
		BaoZi bz = new BaoZi();
		//�����������߳�,����,��������
		new BaoZiPu(bz).start();
		//�����Ի��߳�,����,�԰���
		new ChiHuo(bz).start();
	}

}
