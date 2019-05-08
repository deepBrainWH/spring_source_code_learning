package meite.thread;

public class DaemonThread {
	
	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i = 0;i<10;i++) {
					System.out.println(Thread.currentThread().getName() + ":" + i);
				}
			}
		}, "thread1");
		
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i = 0;i<10;i++) {
					System.out.println(Thread.currentThread().getName() + ":" + i);
				}
		
			}
		},"thread2");
		
		thread1.start();
		thread2.start();
		
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int j = 0;j<10;j++) {
			System.out.println("Main thread: " + j);
		}
		
	}

	
}
