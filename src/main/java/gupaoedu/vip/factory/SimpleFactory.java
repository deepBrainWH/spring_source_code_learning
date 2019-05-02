package gupaoedu.vip.factory;

public class SimpleFactory {
	public Vehicle getVehicle(String name) {
		if(name.startsWith("A")) {
			return new Audi();
		}else if(name.startsWith("Be")) {
			return new Benz();
		}else if(name.startsWith("Bm")){
			return new Bmw();
		}else {
			throw new RuntimeException("There is an error of producing vehicle!");
		}
	}
}
