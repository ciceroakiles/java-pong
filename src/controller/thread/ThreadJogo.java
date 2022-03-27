package controller.thread;

import controller.util.ControleTempo;
import view.Janela;

public class ThreadJogo extends Thread {

	private int pontosP1 = 0;
	private int pontosP2 = 0;
	private ThreadBola tb;
	
	public ThreadJogo() {
		tb = new ThreadBola(Janela.getBola());
		tb.start();
		ThreadJogador tp1 = new ThreadJogador(Janela.getRectP1());
		tp1.start();
		ThreadJogador tp2 = new ThreadJogador(Janela.getRectP2());
		tp2.start();
	}
	
	public void run() {
		while (true) {
			ControleTempo.esperar();
			
			checarReset();
		}
	}

	private void checarReset() {
		if (escapouEsq() || escapouDir()) {
			atualizaPlacar();
			Janela.getBola().setX((int)(Janela.getWidth()-Janela.getBola().getWidth())/2);
			Janela.getBola().setY((int)(Janela.getHeight()-Janela.getBola().getHeight())/2);
			Janela.getRectP1().setY((int)(Janela.getHeight()-Janela.getRectP1().getHeight())/2);
			Janela.getRectP2().setY((int)(Janela.getHeight()-Janela.getRectP2().getHeight())/2);
			tb.randomDir();
		}
	}
	
	private void atualizaPlacar() {
		if (escapouEsq()) pontosP2++;
		if (escapouDir()) pontosP1++;
		System.out.println(pontosP1 + " x " + pontosP2);
	}

	private boolean escapouEsq() {
		return (Janela.getBola().getX()+Janela.getBola().getWidth() <= 0);
	}
	
	private boolean escapouDir() {
		return (Janela.getBola().getX()-Janela.getBola().getWidth() >= Janela.getWidth());
	}
}
