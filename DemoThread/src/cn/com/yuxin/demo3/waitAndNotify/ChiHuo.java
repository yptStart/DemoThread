package cn.com.yuxin.demo3.waitAndNotify;

/*
 * ������(�Ի�)��: ��һ���߳���,���Լ̳�Thread
 * �����߳�����(run): �԰���
 * �԰��ӵ�״̬�����ж�:
 * false: û�а���
 * 	  �Ի�����wait��������ȴ�״̬
 * true: �а���
 * 	  �Ի��԰���
 * 	  �Ի��������,�޸İ��ӵ�״̬Ϊfalseû��
 *   �Ի����Ѱ������߳�,��������
 */
public class ChiHuo extends Thread {

	//1.��Ҫ�ڳ�Աλ�ô���һ�����ӱ���
	private BaoZi bz;

	//2.ʹ�ô��ι��췽��,Ϊ������ӱ�����ֵ
	public ChiHuo(BaoZi bz) {
		this.bz = bz;
	}
	
	//�����߳�����(run):�԰���
	@Override
	public void run() {
		//ʹ����ѭ��,�óԻ�һֱ�԰���
		while (true) {
			//����ʹ��ͬ��������֤�����߳�ֻ����һ����ִ��
			synchronized (bz) {
				//�԰��ӵ�״̬�����ж�
				if (bz.getFlag() == false) {
					//�Ի�����wait��������ȴ�״̬
					try {
						bz.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				//������֮��ִ�еĴ���,�԰���
				System.out.println("�Ի����ڳ�: "+bz.getPi()+bz.getXian()+"�İ���");
				//�Ի��������,�޸İ��ӵ�״̬Ϊfalseû��
				bz.setFlag(false);
				//�Ի����Ѱ������߳�,��������
				bz.notify();
				System.out.println("�Ի��Ѿ���: "+bz.getPi()+bz.getXian()+"�İ��ӳ�����,�����̿�ʼ����");
				System.out.println("----------------------------------------");
			}
		}
		
	}
}
