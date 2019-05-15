package com.gupaoedu.vip.visitor1.fruit;

import com.gupaoedu.vip.visitor1.Fruit;
import com.gupaoedu.vip.visitor1.Visit;

public class Apple implements Fruit {

	@Override
	public int price() {
		// TODO Auto-generated method stub
		return 50;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("红富士苹果！");
	}

	@Override
	public int acccept(Visit visit) {
		// TODO Auto-generated method stub
		return visit.sell(this);
	}
	
}
