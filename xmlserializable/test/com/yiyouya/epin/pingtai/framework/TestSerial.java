package com.yiyouya.epin.pingtai.framework;

import org.frameworkset.soa.ObjectSerializable;
import org.junit.Test;

import com.frameworkset.util.FileUtil;
import com.yiyouya.epin.pingtai.framework.user.AuthenIdentity;

public class TestSerial {
	@Test
	public void testS(){
		try {
			String content = FileUtil.getContent("file:/E:\\workspace\\bbossgroups\\bestpractice\\xmlserializable\\test\\org\\frameworkset\\soa\\s.xml", "UTF-8");
//			System.out.println(content);
			AuthenIdentity a = ObjectSerializable.toBean(content, AuthenIdentity.class);
			content = ObjectSerializable.toXML(a);
			System.out.println(content);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
