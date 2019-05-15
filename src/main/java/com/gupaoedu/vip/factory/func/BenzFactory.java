package com.gupaoedu.vip.factory.func;

import com.gupaoedu.vip.factory.simple.Vehicle;
import com.gupaoedu.vip.factory.simple.Benz;

public class BenzFactory implements Factory{

	@Override
	public Vehicle getVehicle() {
		// TODO Auto-generated method stub
		return new Benz();
	}

}
