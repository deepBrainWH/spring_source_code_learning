package gupaoedu.vip.factory.abstrfac;

import gupaoedu.vip.factory.simple.Audi;
import gupaoedu.vip.factory.simple.Vehicle;

public class AudiFactory extends AbstractFactory{

	@Override
	public Vehicle getCar() {
		// TODO Auto-generated method stub
		return new Audi();
	}

}
