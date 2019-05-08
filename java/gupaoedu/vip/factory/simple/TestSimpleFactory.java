package gupaoedu.vip.factory.simple;

public class TestSimpleFactory {
	public static void main(String[] args) {
		Vehicle vehicle = new SimpleFactory().getVehicle("aenz");
		System.out.println(vehicle.getName());
	}
}
