package gupaoedu.vip.delegate;

public class DispatcherTest {
	public static void main(String[] args) {
		Dispatcher dispatcher = new Dispatcher(new ExecutorA());
		//看上去是调度员在工作，实际上工作室由执行者完成的。（功劳是你的，干活是我的）
		//委派模式关心的是结果。策略模式关心的是过程。
		dispatcher.doing();
	}
}
