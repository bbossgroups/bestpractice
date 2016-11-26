package test;

public class TestBean {
	private String id;
	private String name;
	private TestBean inner;
	private long sellMonery = 1000l;
	private double selldoubleMonery = 100000.00d;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TestBean getInner() {
		return inner;
	}
	public void setInner(TestBean inner) {
		this.inner = inner;
	}
	public long getSellMonery() {
		return sellMonery;
	}
	public void setSellMonery(long sellMonery) {
		this.sellMonery = sellMonery;
	}
	public double getSelldoubleMonery() {
		return selldoubleMonery;
	}
	public void setSelldoubleMonery(double selldoubleMonery) {
		this.selldoubleMonery = selldoubleMonery;
	}

}
