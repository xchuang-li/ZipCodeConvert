package cn.com.entity;
/**
 *@describ 每个数字 对应的全码半码坐标
 *@author 作者:陈凯旗
 *@version 2019年8月27日下午6:57:26
 */
public class EachDigitZuoBiao {
	public int x;
	public int y;
	public int z;
	public int g;
	public int h;
	public EachDigitZuoBiao(int x, int y, int z, int g, int h) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.g = g;
		this.h = h;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	public int getG() {
		return g;
	}
	public void setG(int g) {
		this.g = g;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}

}
