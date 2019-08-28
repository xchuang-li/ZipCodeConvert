package cn.com.service.impl;

import java.util.Arrays;
import java.util.Scanner;

import cn.com.maping.ZipCode_BarCode_Enum;
import cn.com.service.AbatractZipBar;
import cn.com.until.Zip_Bar_until;

/**
 *
 *@author 作者:陈凯旗
 *@version 2019年8月25日下午9:17:07
 */
public class ZipBarImpl extends AbatractZipBar {

	public ZipBarImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

  //邮编转化为条形码
	public String zipToBar(String zipCode){
		StringBuilder sb = new StringBuilder();
		int checkCode = Zip_Bar_until.getCheckCode(zipCode);
		sb.append(BARCODE_PRE);
		String quanZipCode = zipCode + checkCode;
		char[] zipCodechs = quanZipCode.toCharArray();
		for (int i = 0; i < zipCodechs.length; i++) {
			switch(zipCodechs[i]){
			case '1':
				sb.append(ZipCode_BarCode_Enum.ONE.getEachBar());
				break;
			case '2':
				sb.append(ZipCode_BarCode_Enum.TWO.getEachBar());
				break;
			case '3':
				sb.append(ZipCode_BarCode_Enum.THREE.getEachBar());
				break;
			case '4':
				sb.append(ZipCode_BarCode_Enum.FOUR.getEachBar());
				break;
			case '5':
				sb.append(ZipCode_BarCode_Enum.FIVE.getEachBar());
				break;
			case '6':
				sb.append(ZipCode_BarCode_Enum.SIX.getEachBar());
				break;
			case '7':
				sb.append(ZipCode_BarCode_Enum.SEVEN.getEachBar());
				break;
			case '8':
				sb.append(ZipCode_BarCode_Enum.EIGHT.getEachBar());
				break;
			case '9':
				sb.append(ZipCode_BarCode_Enum.NINE.getEachBar());
				break;
			case '0':
				sb.append(ZipCode_BarCode_Enum.ZERO.getEachBar());
				break;
			}
		}
		sb.append(BARCODE_SUF);
		System.out.println("Validation Check:"+ Zip_Bar_until.plus_ZipCode(zipCode) + " == " + sb + "\n" + "cd is "+ checkCode);
		return sb.toString();
	}
	
	//条形码转邮编
	public String barToZip(String barCode) {
		StringBuilder  sb = new StringBuilder();
		String[] barArrays = Zip_Bar_until.getBarcodeArray(barCode);
		//barArrays去掉验证码值
		String[] newBarArrays = Arrays.copyOfRange(barArrays, 0, barArrays.length - 1);
		for (String newBarEvery : newBarArrays) {
			sb.append(ZipCode_BarCode_Enum.getDigitByBarCode(newBarEvery));
		}
		System.out.println("Validation Check:("+ barCode + ") == " + Zip_Bar_until.plus_ZipCode(sb.toString()));
		return sb.toString();
	}

}
