package gupaoedu.vip.visitor1;

import java.util.ArrayList;

import gupaoedu.vip.visitor1.fruit.Apple;
import gupaoedu.vip.visitor1.fruit.Bnana;
import gupaoedu.vip.visitor1.fruit.Orange;

public class TestVisitorPattern {
	public static void main(String[] args) {
		test();
	}
	
	private static void test() {
		ArrayList<Fruit> fruits = new ArrayList<Fruit>();
		fruits.add(new Apple());
		fruits.add(new Bnana());
		fruits.add(new Orange());
		Visit visit = new Visit();
		for(Fruit fruit: fruits) {
			fruit.draw();
			System.out.println("价格：" + fruit.acccept(visit));
		}
	}
}
