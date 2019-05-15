package com.gupaoedu.vip.visitor1.fruit;

import com.gupaoedu.vip.visitor1.Fruit;
import com.gupaoedu.vip.visitor1.Visit;

public class Orange implements Fruit{

	@Override
	public int price() {
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("桔子！");
	}

	@Override
	public int acccept(Visit visit) {
		// TODO Auto-generated method stub
		return visit.sell(this);
	}

}
