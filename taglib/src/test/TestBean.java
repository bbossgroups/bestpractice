package test;

public class TestBean {
	private String id;
	private String name;
	private TestBean inner;
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

}
