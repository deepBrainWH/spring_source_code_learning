package com.gupaoedu.vip.proxy.staticproxy;

public class Main {
	public static void main(String[] args) {
//		new TranditionalOption().add();
		ServiceProxy serviceProxy = new ServiceProxy(new TranditionalOption());
		serviceProxy.add();
	}
}
