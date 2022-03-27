package controller.thread;

import controller.util.ControleTempo;
import model.Desenho;
import view.Janela;

public class ThreadJogador extends Thread {
	
	private Desenho rect;
	private boolean isCPU;
	private int step;
	
	public ThreadJogador(Desenho d) {
		this.rect = d;
		this.isCPU = true;
	}
	
	public void run() {
		while (true) {
			ControleTempo.esperar();
			if (this.isCPU) {
				moverCPU();
			}
		}
	}

	private void moverCPU() {
		step = Janela.getBola().getY() - (int)(rect.getHeight()/2);
		if (step > 0 && step < Janela.getHeight()-rect.getHeight()) {
			rect.setY(step);
		}
	}
}
