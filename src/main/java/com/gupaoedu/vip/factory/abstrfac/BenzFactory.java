package com.gupaoedu.vip.factory.abstrfac;

import com.gupaoedu.vip.factory.simple.Vehicle;
import com.gupaoedu.vip.factory.simple.Benz;

//具体业务逻辑封装
public class BenzFactory extends AbstractFactory{

	@Override
	protected Vehicle getCar() {
		// TODO Auto-generated method stub
		return new Benz();
	}

}
