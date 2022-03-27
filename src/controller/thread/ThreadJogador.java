package controller.thread;

import controller.util.ControleTempo;

public class ThreadJogador extends Thread {

	public ThreadJogador() {
		
	}
	
	public void run() {
		while (true) {
			ControleTempo.esperar();
			
		}
	}
}
