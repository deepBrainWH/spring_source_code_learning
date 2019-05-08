package gupaoedu.vip.factory.func;

import gupaoedu.vip.factory.simple.Benz;
import gupaoedu.vip.factory.simple.Vehicle;

public class BenzFactory implements Factory{

	@Override
	public Vehicle getVehicle() {
		// TODO Auto-generated method stub
		return new Benz();
	}

}
