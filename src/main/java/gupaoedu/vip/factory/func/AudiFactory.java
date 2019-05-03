package gupaoedu.vip.factory.func;

import gupaoedu.vip.factory.simple.Audi;
import gupaoedu.vip.factory.simple.Vehicle;

public class AudiFactory implements Factory{

	@Override
	public Vehicle getVehicle() {
		// TODO Auto-generated method stub
		return new Audi();
	}

}
