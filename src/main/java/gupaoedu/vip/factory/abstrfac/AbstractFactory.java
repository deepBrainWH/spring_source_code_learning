package gupaoedu.vip.factory.abstrfac;

import gupaoedu.vip.factory.simple.Vehicle;

public abstract class AbstractFactory {
	protected abstract Vehicle getCar();
	
	public Vehicle getCar(String name) {
		if("BENZI".toLowerCase().equals(name.toLowerCase())) {
			return new BenzFactory().getCar();
		}else if("BMW".toLowerCase().equals(name.toLowerCase())){
			return new BmwFactory().getCar();
		}else if("AUDI".toLowerCase().equals(name.toLowerCase())) {
			return new AudiFactory().getCar();
		}else {
			return null;
		}
	}
}
