package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape{
	private int x;
	private int y;
	public Point() {
		
	}
	
	public Point(int x , int y) {
		this.x = x;
		this.y = y;
	}

	public Point(int x , int y , boolean selected) {
		this (x , y);
		this.setSelected(selected);
	}
	
	public Point(int x, int y, Color color) {
		this(x,y);
		this.setColor(color);
	}

	public Point(int x, int y, boolean selected, Color color) {
		this(x, y, selected);
		this.setColor(color);
	}
	
	public double distance (int x2 , int y2) {
		double dx = this.x - x2;
		double dy = this.y - y2;
		double d = Math.sqrt(dx * dx + dy * dy);
		return d;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point pomocna = (Point) obj;
			if (this.x == pomocna.x && this.y == pomocna.y)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	public boolean contains(int x , int y) {
		return this.distance(x, y) <= 2;
	}
	
	@Override 
	public void draw(Graphics g) {
		
		g.setColor(getColor());
		g.drawLine(this.x - 2, this.y, this.x + 2, this.y); 
		g.drawLine(this.x, this.y - 2, this.x, this.y + 2);
		if(isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(this.x-3, this.y-3, 6, 6);
		}

	}

	@Override
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y; 
	}

	@Override
	public void moveBy(int byX, int byY) {
		this.x = this.x + byX;
		this.y += byY; 
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Point) {
			return (int)(this.distance(0, 0) - ((Point)o).distance(0, 0));
		}
		
		return 0;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getY() {
		return this.y;
	}
	
	public String toString() {
		return "Point,x:" + getX() + ",y:" + getY() + 
				",selected:" + this.isSelected() +	",color:" + this.getColor().getRGB();
		
	}
	
	@Override
	public Point clone() {
		return new Point(this.getX(), this.getY(), this.isSelected(), this.getColor());
	}
}