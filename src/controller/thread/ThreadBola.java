package controller.thread;

import controller.util.ControleTempo;

public class ThreadBola extends Thread {

	public ThreadBola() {
		
	}
	
	public void run() {
		while (true) {
			ControleTempo.esperar();
			
		}
	}
}
