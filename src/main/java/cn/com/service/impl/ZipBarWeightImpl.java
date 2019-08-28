package cn.com.service.impl;

import java.util.List;

import cn.com.entity.EachBarZuoBiao;
import cn.com.entity.EachDigitZuoBiao;
import cn.com.maping.Weight_Code_Enum;
import cn.com.service.AbatractZipBar;
import cn.com.until.Zip_Bar_until;

/**
 *
 *@author 作者:陈凯旗
 *@version 2019年8月27日下午6:10:03
 */
public class ZipBarWeightImpl extends AbatractZipBar{

	public String zipToBar(String zipCode) {
		List<EachDigitZuoBiao> list = getListDigitZuoBiao(zipCode);
		int checkCode = getCheckCode(zipCode);
		StringBuilder sb = new StringBuilder();
		for (EachDigitZuoBiao eachDigitBar : list) {
			sb.append(Weight_Code_Enum.Code.getCodeStrBynum(eachDigitBar.getX()));
			sb.append(Weight_Code_Enum.Code.getCodeStrBynum(eachDigitBar.getY()));
			sb.append(Weight_Code_Enum.Code.getCodeStrBynum(eachDigitBar.getZ()));
			sb.append(Weight_Code_Enum.Code.getCodeStrBynum(eachDigitBar.getG()));
			sb.append(Weight_Code_Enum.Code.getCodeStrBynum(eachDigitBar.getH()));
		}
		System.out.println("Validation Check:"+ plus_ZipCode(zipCode) + " == " + sb + "\n" + "cd is "+ checkCode);
		return sb.toString();
	}

	public String barToZip(String barCode) {
		List<EachBarZuoBiao> list = getListBarZuoBiao(barCode);
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (EachBarZuoBiao eachBar : list) {
			count ++;
			if(count == list.size()){
				break;
			}
			int sum = 
					Weight_Code_Enum.Code.getNumByCodeStr(eachBar.getX())*Weight_Code_Enum.Weight.SEVEN.getNum()+
					Weight_Code_Enum.Code.getNumByCodeStr(eachBar.getY())*Weight_Code_Enum.Weight.FOUR.getNum()+
					Weight_Code_Enum.Code.getNumByCodeStr(eachBar.getZ())*Weight_Code_Enum.Weight.TWO.getNum()+
					Weight_Code_Enum.Code.getNumByCodeStr(eachBar.getG())*Weight_Code_Enum.Weight.ONE.getNum()+
					Weight_Code_Enum.Code.getNumByCodeStr(eachBar.getH())*Weight_Code_Enum.Weight.ZERO.getNum();
			if(sum == 11){
				sum = 0;
			}
			sb.append(sum);
		}
		System.out.println("Validation Check:("+ barCode + ") == " + plus_ZipCode(sb.toString()));
		return sb.toString();
	}

}
