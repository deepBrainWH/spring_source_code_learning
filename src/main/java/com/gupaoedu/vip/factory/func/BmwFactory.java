package com.gupaoedu.vip.factory.func;

import com.gupaoedu.vip.factory.simple.Bmw;
import com.gupaoedu.vip.factory.simple.Vehicle;

public class BmwFactory implements Factory{

	@Override
	public Vehicle getVehicle() {
		// TODO Auto-generated method stub
		return new Bmw();
	}

}
