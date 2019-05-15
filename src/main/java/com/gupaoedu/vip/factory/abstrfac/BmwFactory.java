package com.gupaoedu.vip.factory.abstrfac;

import com.gupaoedu.vip.factory.simple.Bmw;
import com.gupaoedu.vip.factory.simple.Vehicle;

public class BmwFactory extends AbstractFactory{

	@Override
	public Vehicle getCar() {
		// TODO Auto-generated method stub
		return new Bmw();
	}

}
