package controller.thread;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
	
	public ThreadJogador(Desenho d, int k1, int k2) {
		this.rect = d;
		this.isCPU = false;
		this.addComandos(k1, k2);
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
	
	private void addComandos(int k1, int k2) {
		Janela.getGamePanel().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == k1) {
					moverCima();
					System.out.println("Pressionou tecla W");
				}
				if (e.getKeyCode() == k2) {
					moverBaixo();
					System.out.println("Pressionou tecla S");
				}
			}
		});
	}
	
	private void moverCima() {
		step = rect.getY() - (int)(rect.getHeight()/6);
		if (step > 0) {
			rect.setY(step);
		}
	}
	
	private void moverBaixo() {
		step = rect.getY() + (int)(rect.getHeight()/6);
		if (step < Janela.getHeight()-rect.getHeight()) {
			rect.setY(step);
		}
	}
}
