package model;

import java.awt.Color;

public class Desenho {

	private int x;
	private int y;
	private int width;
	private int height;
	private int type;
	private Color color;
	
	public Desenho(int x, int y, int w, int h, int t, Color c) {
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		this.type = t;
		this.color = c;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getType() {
		return type;
	}

	public Color getColor() {
		return color;
	}
	
	
}
