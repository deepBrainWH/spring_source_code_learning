package gupaoedu.vip.visitor1.fruit;

import gupaoedu.vip.visitor1.Fruit;
import gupaoedu.vip.visitor1.Visit;

public class Bnana implements Fruit{

	@Override
	public int price() {
		// TODO Auto-generated method stub
		return 30;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("香蕉！");
	}

	@Override
	public int acccept(Visit visit) {
		// TODO Auto-generated method stub
		return visit.sell(this);
	}

}
