package view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.Desenho;
import model.DesenhoGrupo;

public class Janela {
	
	private static int width = 600;
	private static int height = 400;
	private static JPanel gamePanel;
	private static Desenho player1;
	private static Desenho player2;
	private static Desenho ball;
	
	public Janela() {
		definirDesenhos();
		criarGamePanel();
		criarFrame();
		while (true) {
			Janela.getGamePanel().repaint();
		}
	}
	
	public static int getWidth() {
		return width;
	}
	
	public static int getHeight() {
		return height;
	}
	
	public static Desenho getRectP1() {
		return player1;
	}
	
	public static Desenho getRectP2() {
		return player2;
	}
	
	public static Desenho getBola() {
		return ball;
	}
	
	private static JPanel getGamePanel() {
		return gamePanel;
	}

	private void definirDesenhos() {
		int playerW = 20;
		int playerH = 100;
		int ballSize = 8;
		Color playerColor = Color.BLUE;
		Color ballColor = Color.RED;
		player1 = new Desenho(0, (height-playerH)/2, playerW, playerH, 2, playerColor);
		player2 = new Desenho((width-playerW), (height-playerH)/2, playerW, playerH, 2, playerColor);
		ball = new Desenho((width-ballSize)/2, (height-ballSize)/2, ballSize, ballSize, 0, ballColor);
	}
	
	private DesenhoGrupo agrupar() {
		Desenho line1 = new Desenho(0, height, width, height, 1, Color.BLACK);
		Desenho line2 = new Desenho(width, 0, width, height, 1, Color.BLACK);
		DesenhoGrupo group = new DesenhoGrupo();
		group.adicionarDesenho(player1, player2, ball, line1, line2);
		return group;
	}
	
	private void criarGamePanel() {
		gamePanel = new JPanel();
		gamePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		gamePanel.setLayout(new GridLayout(1, 1));
		gamePanel.setFocusable(true);
		gamePanel.add(agrupar());
	}
	
	private void criarFrame() {
		JFrame frame = new JFrame("Ping-pong");
		frame.setSize(width+17, height+40);
		frame.add(gamePanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.setVisible(true);
	}
}
