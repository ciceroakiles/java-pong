package controller.thread;

import controller.util.ControleTempo;
import view.Janela;

public class ThreadJogo extends Thread {

	private ThreadBola tb;
	
	public ThreadJogo() {
		tb = new ThreadBola(Janela.getBola());
		tb.start();
	}
	
	public void run() {
		while (true) {
			ControleTempo.esperar();
			
		}
	}
}
