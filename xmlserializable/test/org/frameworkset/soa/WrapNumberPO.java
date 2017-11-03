package org.frameworkset.soa;

public class WrapNumberPO implements java.lang.Comparable<WrapNumberPO>{
	private Integer data1 ;
	private Integer data2 ;
	private Integer data3 ;
	private Integer data4 ;
	private Integer data5 ;
	public Integer getData1() {
		return data1;
	}
	public void setData1(Integer data1) {
		this.data1 = data1;
	}
	public Integer getData2() {
		return data2;
	}
	public void setData2(Integer data2) {
		this.data2 = data2;
	}
	public Integer getData3() {
		return data3;
	}
	public void setData3(Integer data3) {
		this.data3 = data3;
	}
	public Integer getData4() {
		return data4;
	}
	public void setData4(Integer data4) {
		this.data4 = data4;
	}
	public Integer getData5() {
		return data5;
	}
	public void setData5(Integer data5) {
		this.data5 = data5;
	}
	@Override
	public int compareTo(WrapNumberPO o) {
		// TODO Auto-generated method stub
		return this.equals(o)?0:1;
	}

}
