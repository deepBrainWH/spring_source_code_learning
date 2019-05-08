package gupaoedu.vip.factory.func;

import gupaoedu.vip.factory.simple.Bmw;
import gupaoedu.vip.factory.simple.Vehicle;

public class BmwFactory implements Factory{

	@Override
	public Vehicle getVehicle() {
		// TODO Auto-generated method stub
		return new Bmw();
	}

}
