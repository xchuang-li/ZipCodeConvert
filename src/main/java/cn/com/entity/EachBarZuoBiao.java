package cn.com.entity;
/**
 *@describe 每个条形码对应的条形码坐标
 *@author 作者:陈凯旗
 *@version 2019年8月27日下午7:35:10
 */
public class EachBarZuoBiao {
	public String x;
	public String y;
	public String z;
	public String g;
	public String h;
	public String getX() {
		return x;
	}
	
	public EachBarZuoBiao(String x, String y, String z, String g, String h) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.g = g;
		this.h = h;
	}

	public void setX(String x) {
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}
	public String getZ() {
		return z;
	}
	public void setZ(String z) {
		this.z = z;
	}
	public String getG() {
		return g;
	}
	public void setG(String g) {
		this.g = g;
	}
	public String getH() {
		return h;
	}
	public void setH(String h) {
		this.h = h;
	}
	
}
