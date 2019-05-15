package com.gupaoedu.vip.delegate;

public class Dispatcher implements Executor{
	
	private Executor executor;
	
	public Dispatcher(Executor executor) {
		// TODO Auto-generated constructor stub
		this.executor = executor;
	}

	@Override
	public void doing() {
		// TODO Auto-generated method stub
		this.executor.doing();
	}

}
