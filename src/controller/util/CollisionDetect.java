package controller.util;

import controller.thread.ThreadBola;
import view.Janela;

public class CollisionDetect {

	private static boolean playerCollide = false;
	
	public static void detectarColisoes(ThreadBola tb) {
		switch (tb.getDirection()) {
			case 0: collEsqCima(tb); break;
			case 1: collDirCima(tb); break;
			case 2: collDirBaixo(tb); break;
			case 3: collEsqBaixo(tb); break;
		}
		if (playerCollide) {
			System.out.println("Colidiu com jogador");
			playerCollide = false;
		}
	}

	private static void collEsqCima(ThreadBola tb) {
		if (CollisionDetect.hasCollidedP1()) {
			tb.setDirection(1);
			playerCollide = true;
		}
		if (CollisionDetect.hasCollidedCima()) {
			tb.setDirection(3);
		}
	}
	
	private static void collDirCima(ThreadBola tb) {
		if (CollisionDetect.hasCollidedP2()) {
			tb.setDirection(0);
			playerCollide = true;
		}
		if (CollisionDetect.hasCollidedCima()) {
			tb.setDirection(2);
		}
	}
	
	private static void collDirBaixo(ThreadBola tb) {
		if (CollisionDetect.hasCollidedP2()) {
			tb.setDirection(3);
			playerCollide = true;
		}
		if (CollisionDetect.hasCollidedBaixo()) {
			tb.setDirection(1);
		}
	}
	
	private static void collEsqBaixo(ThreadBola tb) {
		if (CollisionDetect.hasCollidedP1()) {
			tb.setDirection(2);
			playerCollide = true;
		}
		if (CollisionDetect.hasCollidedBaixo()) {
			tb.setDirection(0);
		}
	}
	
	private static boolean hasCollidedP1() {
		return (Janela.getBola().getRetangulo().intersects(Janela.getRectP1().getRetangulo()));
	}
	
	private static boolean hasCollidedP2() {
		return (Janela.getBola().getRetangulo().intersects(Janela.getRectP2().getRetangulo()));
	}
	
	private static boolean hasCollidedCima() {
		return (Janela.getBola().getY() <= 0);
	}
	
	private static boolean hasCollidedBaixo() {
		return (Janela.getBola().getY() >= Janela.getHeight()-Janela.getBola().getHeight());
	}
}
