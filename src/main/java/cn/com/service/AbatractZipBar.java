package cn.com.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import cn.com.entity.EachBarZuoBiao;
import cn.com.entity.EachDigitZuoBiao;
import cn.com.interfaces.Convert;
import cn.com.maping.ZipCode_BarCode_Enum;
import cn.com.until.Zip_Bar_until;

/**
 *
 *@author ����:�¿���
 *@version 2019��8��25������8:34:09
 */
public abstract class AbatractZipBar implements Convert {
	public static  String BARCODE_PRE = "|";//������ǰ׺
	public static  String BARCODE_SUF = "|";//�������׺
	public static  String CHOICE1 = "1";//ѡ��1 ����ת������
	public static  String CHOICE2 = "2";//ѡ��2 ������ת����
	public static  String CHOICE3 = "3";//ѡ��3 �˳�
	public static  int BAR_EVERYLENGTH = 5;//0-9���ֶ�Ӧ�����볤�� 5���ַ�
	
	public AbatractZipBar() {
		System.out.println("1. Translate zip code to bar code");
		System.out.println("2. Translate bar code to zip code");
		System.out.println("3. Quit");
	}
	//��ȡ�ʱ�0,1����
	public static List<EachDigitZuoBiao> getListDigitZuoBiao(String zipCode){
		char[] zipChars = zipCode.toCharArray();
		zipCode += getCheckCode(zipCode);
		List<EachDigitZuoBiao> list = new ArrayList<EachDigitZuoBiao>();
		for (int i = 0; i < zipChars.length; i++) {
			int x=0,y=0,z=0,g=0,h=0;
			EachDigitZuoBiao edg = new EachDigitZuoBiao(x, y, z, g, h);
			int index = Integer.parseInt(String.valueOf(zipChars[i]));
			if(index > 7){
				index = index%7;
				x = 1;
				edg.setX(x);
			}
			if(index >= 4){
				index = index%4;
				y = 1;
				edg.setY(y);
			}
			if(index >= 2){
				index = index%2;
				z=1;
				edg.setZ(z);
			}
			if(index >=1){
				index = index%1;
				h = 1;
				edg.setH(h);
			}
			if(index == 0){
				x = 1;
				y = 1;
				edg.setX(x);
				edg.setY(y);
			}
			list.add(edg);
			
		}
		
		return list;
	}
	
	//��ȡ�����룺|����
	public static List<EachBarZuoBiao> getListBarZuoBiao(String barCode){
		List<EachBarZuoBiao> list = new ArrayList<EachBarZuoBiao>();
		String[] barArrays = getBarcodeArray(barCode);
		for (String eachbar : barArrays) {
			String x=":",y=":",z=":",g=":",h=":";
			EachBarZuoBiao ebz = new EachBarZuoBiao(x,y,z,g,h);
			ebz.setX(String.valueOf(eachbar.charAt(0)));
			ebz.setY(String.valueOf(eachbar.charAt(1)));
			ebz.setZ(String.valueOf(eachbar.charAt(2)));
			ebz.setG(String.valueOf(eachbar.charAt(3)));
			ebz.setH(String.valueOf(eachbar.charAt(4)));
			list.add(ebz);
		}
		return list;
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
		if(flag){
			System.out.println("�ʱ�Ϸ�");
		}else{
			System.out.println("�ʱ಻�Ϸ�");
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
		
		boolean flag = true;//Ĭ�ϺϷ�
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
	
	//�������� ���ݲ�ͬ��ѡ�� ѡȡ��ͬ��ת����ʽ
	public  void getResultByChocie(){
		Scanner scn = new Scanner(System.in);
		outer:while(true){
			System.out.println("Please input your choices(1~3)");
			String choice = scn.nextLine();
		    if(CHOICE1.equals(choice)){
		    	inner1:while(true){
					System.out.println("Please input zip code:");
					String inputStr = scn.nextLine().trim();
					if(!Zip_Bar_until.isNull(inputStr) 
							&& Zip_Bar_until.checkZipCode(inputStr)){
						zipToBar(inputStr);
					}else{
						if("exit".equals(inputStr.toLowerCase())){
							continue outer;
						}
						System.out.println("������ʱ಻�Ϸ�������������.");
						continue inner1;
					}
		    	}
		    }else if(CHOICE2.equals(choice)){
		    	inner2:while(true){
					System.out.println("Please input bar code:");
					String inputStr = scn.nextLine().trim();
					if(!Zip_Bar_until.isNull(inputStr) && 
							Zip_Bar_until.checkBarcode(inputStr)){
						barToZip(inputStr);
					}else{
						if("exit".equals(inputStr.toLowerCase())){
							continue outer;
						}
						System.out.println("����������벻�Ϸ�������������.");
						continue inner2;
					}
		    	}
		    }else if(CHOICE3.equals(choice)){
		    	break outer;
		    }else{
		    	System.out.println("Please give right input:");
		    	continue;
		    }
		}
		
	}
	

}
