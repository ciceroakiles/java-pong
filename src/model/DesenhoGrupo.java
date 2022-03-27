package model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class DesenhoGrupo extends JPanel {

	private List<Desenho> grupoDesenhos;
	
	public DesenhoGrupo() {
		this.grupoDesenhos = new ArrayList<>();
	}
	
	public void adicionarDesenho(Desenho... desenhos) {
		for (Desenho d: desenhos) {
			grupoDesenhos.add(d);
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		for (Desenho d: grupoDesenhos) {
			g.setColor(d.getColor());
			switch (d.getType()) {
				case 0: {
					g.fillOval(d.getX(), d.getY(), d.getWidth(), d.getHeight());
				} break;
				case 1: {
					g.drawLine(d.getX(), d.getY(), d.getWidth(), d.getHeight());
				} break;
				case 2: {
					g.fillRect(d.getX(), d.getY(), d.getWidth(), d.getHeight());
				} break;
			}
		}
	}
}
