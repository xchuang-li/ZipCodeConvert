package cn.com.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import cn.com.service.impl.ZipBarImpl;
import cn.com.service.impl.ZipBarWeightImpl;

/**
 *
 *@author ����:�¿���
 *@version 2019��8��27������7:22:57
 */
public class ZipBarWeightImplTest {

	@Test
	public void testZipToBar() {
		ZipBarWeightImpl  zb = new ZipBarWeightImpl();
		String zipCode = "12345";
		zb.zipToBar(zipCode);
	}

	@Test
	public void testBarToZip() {
		ZipBarWeightImpl  zb = new ZipBarWeightImpl();
		String barCode = "|:|::|:|:|:||::::|:|::||:::::||::|:|::||:|";
		zb.barToZip(barCode);
	}

	@Test
	public void testCheckZipCode() {
		ZipBarWeightImpl  zb = new ZipBarWeightImpl();
		String zipCode = "555690";
		Assert.assertEquals(true, zb.checkZipCode(zipCode));
		
	}

	@Test
	public void testCheckBarcode() {
		ZipBarWeightImpl  zb = new ZipBarWeightImpl();
		String barCode = "|:|:|:|";
		Assert.assertEquals(true, zb.checkBarcode(barCode));
		
	}

	@Test
	public void testGetResultByChocie() {
		ZipBarWeightImpl  zb = new ZipBarWeightImpl();
		zb.getResultByChocie();
	}

}
