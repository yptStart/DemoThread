package cn.com.yuxin.demo3.waitAndNotify;

/**
 * 资源类:包子类
 * 设置包子的属性:
 * 	  皮
 * 	  馅
 *   包子状态: 有  true  没有 false
 */
public class BaoZi {

	//皮
	private String pi;
	
	//馅
	private String xian;
	
	//包子的状态: 有 true  没有 false,设置初始值为false没有包子
	private boolean flag = false;

	public String getPi() {
		return pi;
	}

	public void setPi(String pi) {
		this.pi = pi;
	}

	public String getXian() {
		return xian;
	}

	public void setXian(String xian) {
		this.xian = xian;
	}

	public boolean getFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}
