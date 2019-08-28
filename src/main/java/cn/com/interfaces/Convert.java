package cn.com.interfaces;
/**
 *
 *@author 作者:陈凯旗
 *@version 2019年8月25日下午8:02:18
 */
public interface Convert {
	//邮编转条码
	public String zipToBar(String zipCode);
	
	//条码转邮编
    public String barToZip(String barCode);

}
