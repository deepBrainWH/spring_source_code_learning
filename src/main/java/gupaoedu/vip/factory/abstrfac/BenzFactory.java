package gupaoedu.vip.factory.abstrfac;

import gupaoedu.vip.factory.simple.Benz;
import gupaoedu.vip.factory.simple.Vehicle;

public class BenzFactory extends AbstractFactory{

	@Override
	protected Vehicle getCar() {
		// TODO Auto-generated method stub
		return new Benz();
	}

}
