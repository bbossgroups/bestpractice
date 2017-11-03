package org.frameworkset.soa;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class TestWrapNumberRef {
	@Test
	public void testWrapNumberRef() throws Exception{
		WrapNumberPO wrapNumberPO = new WrapNumberPO();
		Integer data1 = new Integer(1);
		wrapNumberPO.setData1(data1);
		wrapNumberPO.setData2(1);
		//wrapNumberPO.setData3(data1);
		
		String serial = ObjectSerializable.toXML(wrapNumberPO);
		System.out.println(serial);
		WrapNumberPO wrapNumberPO1 = ObjectSerializable.toBean(serial, WrapNumberPO.class);
		System.out.println();
		Set<WrapNumberPO> set = new TreeSet<WrapNumberPO>();
		set.add(wrapNumberPO);
		wrapNumberPO = new WrapNumberPO();
		Integer data2 = new Integer(1);
		wrapNumberPO.setData1(data2);
		wrapNumberPO.setData2(1);
		wrapNumberPO.setData3(data1);
		set.add(wrapNumberPO);
		
		NumberPOs pos = new NumberPOs();
		pos.setSet(set);
		serial = ObjectSerializable.toXML(pos);
		pos = ObjectSerializable.toBean(serial, NumberPOs.class);
		System.out.println();
		
	}

}
