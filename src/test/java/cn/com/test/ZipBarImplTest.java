package cn.com.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import cn.com.service.impl.ZipBarImpl;

/**
 *
 *@author 作者:陈凯旗
 *@version 2019年8月25日下午9:34:56
 */
public class ZipBarImplTest {

	@Test
	//根据不同的选项，选择不同的处理方式
	public void testGetResultByChocie() {
		ZipBarImpl  zb = new ZipBarImpl();
		zb.getResultByChocie();
	}

	@Test
	//单元测试邮编转条形码
	public void testZipToBar() {
		ZipBarImpl  zb = new ZipBarImpl();
		String zipCode = "123456666";
		zb.zipToBar(zipCode);
	}

	@Test
	//条形码转邮编
	public void testBarToZip() {
		ZipBarImpl  zb = new ZipBarImpl();
		
		//|:|::|:|:|:||::::|:|::||:::::||::|:|::||::|::||
		//|:|::|:|:|:||::::|:|::||:::::||::|:|::||:|
		//|:|::|:|:|:||::::|:|::||:::::||::|:||
		//|:|::|:|:|:||::::|:|::||:::::|||
		String barCode = "|:|::|:|:|:||::::|:|::||:::::||::|:|::||::|::|||:::|";
		zb.barToZip(barCode);
	}
	@Test
	//判断邮编的合法性
	public void testCheckZipcode(){
		ZipBarImpl  zb = new ZipBarImpl();
		String zipCode="12355";
		Assert.assertEquals(true, zb.checkZipCode(zipCode));
	}
	
	@Test
	//判断条形码的合法性
	public void testCheckBarcode(){
		ZipBarImpl  zb = new ZipBarImpl();
		String barCode="333";
		Assert.assertEquals(true, zb.checkBarcode(barCode));
	}
}
