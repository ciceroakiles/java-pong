package controller.thread;

import controller.util.ControleTempo;
import model.Desenho;

public class ThreadBola extends Thread {

	private Desenho ball;
	private int direction;
	
	public ThreadBola(Desenho d) {
		randomDir();
		this.ball = d;
	}
	
	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public void run() {
		while (true) {
			ControleTempo.esperar();
			mover();
		}
	}

	private void mover() {
		switch (direction) {
			case 0: {
				ball.setX(ball.getX()-ball.getWidth());
				ball.setY(ball.getY()-ball.getHeight());
			} break;
			case 1: {
				ball.setX(ball.getX()+ball.getWidth());
				ball.setY(ball.getY()-ball.getHeight());
			} break;
			case 2: {
				ball.setX(ball.getX()+ball.getWidth());
				ball.setY(ball.getY()+ball.getHeight());
			} break;
			case 3: {
				ball.setX(ball.getX()-ball.getWidth());
				ball.setY(ball.getY()+ball.getHeight());
			} break;
		}
	}
	
	public void randomDir() {
		direction = (int)(Math.random() * 4);
	}
}
