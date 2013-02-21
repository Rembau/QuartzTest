package springQuartzTest;

public class JobTest {
	private String str;
	public void excute(){
		System.out.println("excute once,"+str);
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
}
