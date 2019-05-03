package gupaoedu.vip.factory.abstrfac;

import gupaoedu.vip.factory.simple.Audi;
import gupaoedu.vip.factory.simple.Vehicle;

//具体业务逻辑封装
public class AudiFactory extends AbstractFactory{

	@Override
	public Vehicle getCar() {
		// TODO Auto-generated method stub
		return new Audi();
	}

}
