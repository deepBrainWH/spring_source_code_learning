package gupaoedu.vip.proxy.cglib;

public class TestCgLibProxy {
	public static void main(String[] args) {
		
		try {
			Yunzhongyu instance = (Yunzhongyu)new GPMeipo().getInstance(new Yunzhongyu());
			instance.findLove();
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
