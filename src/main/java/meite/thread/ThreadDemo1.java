package meite.thread;

public class ThreadDemo1 {
	
	public static void main(String[] args) {
		
		CreateThread thread1 = new CreateThread();
		thread1.start();
//		for(int i = 0;i<3;i++) {
//			
//		}
	}
	
	static class CreateThread extends Thread{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("线程name" + this.getName());
		}
		
	}

}
