package com.gupaoedu.vip.factory.abstrfac;

import com.gupaoedu.vip.factory.simple.Vehicle;

public abstract class AbstractFactory {
	protected abstract Vehicle getCar();
	
	//这段代码就是动态配置。
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
