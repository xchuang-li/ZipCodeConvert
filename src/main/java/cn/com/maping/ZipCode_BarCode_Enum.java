package cn.com.maping;

/**
 *
 *@author 作者:陈凯旗
 *@version 2019年8月25日下午7:25:45
 */
public enum ZipCode_BarCode_Enum {
	
	 ONE(1,":::||"), TWO(2,"::|:|"),
	 THREE(3,"::||:"),FOUR(4,":|::|"), 
	 FIVE(5,":|:|:"),SIX(6,":||::"),
	 SEVEN(7,"|:::|"),EIGHT(8,"|::|:"),
	 NINE(9,"|:|::"),ZERO(0,"||:::");
	 private int eachNum;
	 private String eachBar;  
	 // 构造方法  
    private ZipCode_BarCode_Enum(int eachNum,String eachBar) {  
   	   this.eachNum= eachNum;
       this.eachBar = eachBar;  
    }
    
    //根据条形码获取对应的阿拉伯数字
    public static int getDigitByBarCode(String barCode){
    	for (ZipCode_BarCode_Enum zbe : ZipCode_BarCode_Enum.values()) {
			if(barCode.trim().equals(zbe.getEachBar())){
				return zbe.getEachNum();
			}
		}
    	return -1;
    }
    //根据数字获取对应条形码
    public static String getEachBarByDigit(int eachDigit){
    	for (ZipCode_BarCode_Enum zbe : ZipCode_BarCode_Enum.values()) {
			if(zbe.getEachNum() == eachDigit){
				return zbe.getEachBar();
			}
		}
    	return null;
    }
	public int getEachNum() {
		return eachNum;
	}
	public void setEachNum(int eachNum) {
		this.eachNum = eachNum;
	}
	public String getEachBar() {
		return eachBar;
	}
	public void setEachBar(String eachBar) {
		this.eachBar = eachBar;
	}
}
