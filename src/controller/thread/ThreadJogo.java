package controller.thread;

import controller.util.ControleTempo;

public class ThreadJogo extends Thread {

	public ThreadJogo() {
		
	}
	
	public void run() {
		while (true) {
			ControleTempo.esperar();
			
		}
	}
}
