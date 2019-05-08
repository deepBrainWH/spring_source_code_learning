package gupaoedu.vip.factory.abstrfac;

import gupaoedu.vip.factory.simple.Vehicle;

public class DefaultFactory extends AbstractFactory{
	
	private AudiFactory defaultFactory = new AudiFactory();

	@Override
	protected Vehicle getCar() {
		// TODO Auto-generated method stub
		return defaultFactory.getCar();
	}

}
