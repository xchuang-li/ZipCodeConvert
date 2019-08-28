package cn.com.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import cn.com.service.impl.ZipBarImpl;

/**
 *
 *@author ����:�¿���
 *@version 2019��8��25������9:34:56
 */
public class ZipBarImplTest {

	@Test
	//���ݲ�ͬ��ѡ�ѡ��ͬ�Ĵ���ʽ
	public void testGetResultByChocie() {
		ZipBarImpl  zb = new ZipBarImpl();
		zb.getResultByChocie();
	}

	@Test
	//��Ԫ�����ʱ�ת������
	public void testZipToBar() {
		ZipBarImpl  zb = new ZipBarImpl();
		String zipCode = "123456666";
		zb.zipToBar(zipCode);
	}

	@Test
	//������ת�ʱ�
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
	//�ж��ʱ�ĺϷ���
	public void testCheckZipcode(){
		ZipBarImpl  zb = new ZipBarImpl();
		String zipCode="12355";
		Assert.assertEquals(true, zb.checkZipCode(zipCode));
	}
	
	@Test
	//�ж�������ĺϷ���
	public void testCheckBarcode(){
		ZipBarImpl  zb = new ZipBarImpl();
		String barCode="333";
		Assert.assertEquals(true, zb.checkBarcode(barCode));
	}
}
