package cn.com.until;

import java.util.Arrays;
import java.util.List;

import cn.com.maping.ZipCode_BarCode_Enum;
import cn.com.service.AbatractZipBar;

/**
 *
 *@author ����:�¿���
 *@version 2019��8��25������7:46:07
 */
public  class Zip_Bar_until {
	
	
	//�ж������Ƿ�λ��  true�� �� false��Ϊ��
	public static boolean isNull(String str){
		if(str == null || str.trim().length() == 0){
		    return true;
		}else{
			return false;
		}
		
	}
	
	//��9λ�ʱ��"-"
	public static String plus_ZipCode(String zipCode){
		StringBuilder sb = new StringBuilder(zipCode);
		if(zipCode.length() == 9){
			sb = sb.insert(5, "-");
		}
		return sb.toString();
	}
	
	//�����ʱ��ȡУ����
	public static int  getCheckCode(String zipCode){
		int checkCode = 0;
		if(checkZipCode(zipCode)){
			int count = 0;
			char[] zipCh = zipCode.toCharArray();
			for (int i = 0; i < zipCh.length; i++) {
				int every = Integer.parseInt(String.valueOf(zipCh[i]));
				count += every;
			}
			if(count%10 == 0){
				checkCode = 0;
			}else{
				checkCode = 10 - count%10; 
			}
		}
		return checkCode;
	}
    //�ж��ʱ��Ƿ�Ϸ�  true �Ϸ�  ��false ���Ϸ�
	public static boolean checkZipCode(String zipCode){
		boolean flag = true;
		if(zipCode == null || zipCode.length() == 0 || 
				!(zipCode.length() == 5 || zipCode.length() == 9 )){
			flag = false;
		}else{
			char[] chs = zipCode.trim().toCharArray();
			for (int i = 0; i < chs.length; i++) {
				if(!Character.isDigit(chs[i])){
					//throw new Exception("�ʱ಻�Ϸ�");
					flag = false;
				}
			}
		}
		return flag;
	}
	
	//��ȡ������string����
	public static String[]  getBarcodeArray(String barCode){
		String newBarCode = barCode.substring(1, barCode.trim().length()-1);
		StringBuilder sb = new StringBuilder(newBarCode);
		 for(int i = 0; i < sb.length();i++){
			 if(i%(AbatractZipBar.BAR_EVERYLENGTH + 1)==0){ 
				 sb.insert(i,","); 
			 } 
	     }
		String sbstr = sb.substring(1,sb.length());
		String[]  barArray = sbstr.split(",");
		
		return barArray;
	}
	
	
	//�ж��������Ƿ�Ϸ� true �Ϸ�  �� false ���Ϸ�
	public static boolean checkBarcode(String barCode){
		
		boolean flag = true;
		if(barCode == null || barCode.trim().length() == 0){
			flag = false;
		    return flag;
		}
		if(!barCode.startsWith(AbatractZipBar.BARCODE_PRE) || 
				!barCode.endsWith(AbatractZipBar.BARCODE_SUF)){
			flag = false;
			return flag;
		}
		if((barCode.length()-2) % AbatractZipBar.BAR_EVERYLENGTH != 0){
			flag = false;
			return flag;
		}
		List<String> list = Arrays.asList(getBarcodeArray(barCode));
		if(!(list.size() == 6 || list.size() == 10)){
			flag = false;
			return flag;
		}
		for (String str : list) {
			if(ZipCode_BarCode_Enum.getDigitByBarCode(str) == -1){
				flag = false;
				return flag;
			}
		}
		return flag;
	}
}
