package cn.com.yuxin.demo3.waitAndNotify;

/*
 * ������(������)��: ��һ���߳���,���Լ̳�Thread
 * �����߳�����(run): ��������
 * �԰��ӵ�״̬�����ж�:
 * true: �а���
 * 		�����̵���wait��������ȴ�״̬
 * false: û�а���
 * 		��������������
 * 		����һЩȤ����: �����������ְ���; ������״̬��(i%2 == 0)������
 * 		�������������˰���,�޸İ��ӵ�״̬Ϊtrue ��
 * 		���ѳԻ��߳�,�óԻ��̳߳԰���
 * 
 * ע��:
 * 	  �������̺߳ͳԻ��̵߳Ĺ�ϵ-->ͨ��(����)
 * 	 ����ʹ��ͬ��������֤�����߳�ֻ����һ����ִ��
 * 	 ��������뱣֤Ψһ,����ʹ�ð��Ӷ�����Ϊ������
 * 	 ��������ͳԻ������Ҫ�Ѱ��Ӷ�����Ϊ�������ݽ���
 *   	1.��Ҫ�ڳ�Աλ�ô���һ�����ӱ���
 *   	2.ʹ�ô��ι��췽��,Ϊ������ӱ�����ֵ
 */
public class BaoZiPu extends Thread {
	
	//1.��Ҫ�ڳ�Աλ�ô���һ�����ӱ���
	private BaoZi bz;

	//2.ʹ�ô��ι��췽��,Ϊ������ӱ�����ֵ
	public BaoZiPu(BaoZi bz) {
		this.bz = bz;
	}

	//�����߳�����(run):��������
	@Override
	public void run() {
		int count = 0;
		
		//�ð�����һֱ��������
		while (true) {
			//����ʹ��ͬ��������֤�����߳�ֻ����һ����ִ��
			synchronized (bz) {
				//�԰��ӵ�״̬�����ж�
				if (bz.getFlag() == true) {
					//�����̵���wait��������ȴ�״̬
					try {
						bz.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				//������֮��ִ��,��������������
				//����һЩȤ����,�����������ְ���	
				if (count % 2 == 0) {
					//�ɲ���Ƥ�����ڽ���
					bz.setPi("��Ƥ");
					bz.setXian("������");
				} else {
					//�ɲ���Ƥţ�����ڽ���
					bz.setPi("��Ƥ");
					bz.setXian("ţ������");
				}
				count++;
				System.out.println("��������������: "+bz.getPi()+bz.getXian()+"����");
				//����������Ҫ3����
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//�������������˰���,�޸İ��ӵ�״̬Ϊtrue ��
				bz.setFlag(true);
				//���ѳԻ��߳�,�óԻ��̳߳԰���
				bz.notify();
				System.out.println("�������Ѿ���������: "+bz.getPi()+bz.getXian()+"����, �Ի����Կ�ʼ����");
			}
		}
	}

}