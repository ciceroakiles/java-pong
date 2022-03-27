package controller.util;

public class ControleTempo {

	private static int delay = 42;
	
	public static int getDelay() {
		return delay;
	}

	public static void setDelay(int delay) {
		ControleTempo.delay = delay;
	}
	
	public static void esperar() {
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}
