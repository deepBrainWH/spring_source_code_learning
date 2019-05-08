package gupaoedu.vip.factory.abstrfac;

import gupaoedu.vip.factory.simple.Benz;
import gupaoedu.vip.factory.simple.Vehicle;

//具体业务逻辑封装
public class BenzFactory extends AbstractFactory{

	@Override
	protected Vehicle getCar() {
		// TODO Auto-generated method stub
		return new Benz();
	}

}
