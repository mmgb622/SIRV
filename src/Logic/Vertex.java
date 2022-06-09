package Logic;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;

import Logic.logicList.DoubleLinkedList;

public class Vertex {
	//basic content
	public Object element;
	
	//elements for a dynamic graph
	public DoubleLinkedList asociatedVertex;
	public DoubleLinkedList weights;
	
	//flag for traverse
	public boolean seen;
	
	//elements for graphic drawing
	public int x, y, radio;
	public Rectangle area;
	
	public Vertex(Object element) {
		super();
		this.seen = false;
		this.element = element;
		this.asociatedVertex = new DoubleLinkedList();
		this.weights = new DoubleLinkedList();
		
		this.x = 50;
		this.y = 50;
		this.radio = 15;
		this.area = new Rectangle(x-radio, y-radio, 2*radio, 2*radio);
	}
	
	public void updateVertexPosition(Point location) {
		this.x = location.x;
		this.y = location.y;
		this.area.setLocation(this.x-radio, this.y-radio);
	}
	
	public void paint(Graphics g) {
		g.fillOval(x-radio, y-radio, 2*radio, 2*radio);
		for (int i = 1; i < asociatedVertex.getSize(); i++) {
			paintEdge(g, (Vertex) asociatedVertex.get(i));
		}
	}
	
	public void paintEdge(Graphics g, Vertex asociated) {
		Polygon arrow = calculateIntersection(asociated);
		g.drawLine(this.x, this.y, asociated.x, asociated.y);
		g.fillPolygon(arrow);
	}
	
	private Polygon generateArrow(Point base, double angle) {
		double refAngle = 15*Math.PI/180;
		
		double a1x = base.x + (Math.cos(angle-refAngle)* 20);
		double a1y = base.y + (Math.sin(angle-refAngle)* 20);
		Point aux1 = new Point((int)a1x, (int)a1y);
		
		double a2x = base.x + (Math.cos(angle+refAngle)* 20);
		double a2y = base.y + (Math.sin(angle+refAngle)* 20);
		Point aux2 = new Point((int)a2x, (int)a2y);
		
		int[] xPoints = {base.x,aux1.x,aux2.x};
		int[] yPoints = {base.y,aux1.y,aux2.y};
		
		return new Polygon(xPoints, yPoints, 3);
	}
	
	/**
	 * this method calculates the intersection point with another vertex, and 
	 * generates a polygon with triangle shape, using the generateArrow method.
	 * the purpose is to have a logical support when drawing the arrow, in case
	 * the position of the vertex changes
	 * @param asociated
	 * the associated vertex that will connect an arrow
	 * @return
	 * a polygon of arrow in the respective angle and position related to the 
	 * associated vertex
	 */
	private Polygon calculateIntersection(Vertex associated) {
		int radioDistance = associated.radio;
		double arrowAngle = -1;
		Point arrowImpact;
		
		if(this.x == associated.x) { //vertical line
			if(this.y > associated.y) { //up arrow
				arrowImpact = new Point(associated.x, associated.y+radioDistance);
				arrowAngle = 90*Math.PI/180;
			} else { //down arrow
				arrowImpact = new Point(associated.x, associated.y-radioDistance);
				arrowAngle = 270*Math.PI/180;
			}
			
		} else if(this.y == associated.y){ //horizontal line
			if(this.x < associated.x) {//right arrow
				arrowImpact = new Point(associated.x-radioDistance,associated.y);
				arrowAngle = 180*Math.PI/180;
			}else {//left arrow
				arrowImpact = new Point(associated.x+radioDistance,associated.y);
				arrowAngle = 0;
			}
			
		}else { //diagonal
			double Dy = associated.y-this.y; // there's a variation on the orientation of Y axe related to a real plain, so it turns negative on the slope
			double Dx = associated.x-this.x;
			double m = -1*(Dy/Dx); 
			int hip = radioDistance;
			
			if(m>0) { //upward
				double angle = Math.atan(m);
				
				if(associated.x<this.x) { //right-up
					double Px = associated.x + (Math.cos(angle)* hip);
					double Py = associated.y - (Math.sin(angle)* hip);
					arrowImpact = new Point((int)Px, (int)Py);
					
					arrowAngle = (360-(angle*180/Math.PI))*Math.PI/180;
				}else { //left-down
					double Px = associated.x - (Math.cos(angle)* hip);
					double Py = associated.y + (Math.sin(angle)* hip);
					arrowImpact = new Point((int)Px, (int)Py);
					
					arrowAngle = (180-(angle*180/Math.PI))*Math.PI/180;
				}
			} else { //downward 
				double angle = -1 * Math.atan(m);
				
				if(associated.x<this.x) { //right-down
					double Px = associated.x + (Math.cos(angle) * hip);
					double Py = associated.y + (Math.sin(angle) * hip);
					arrowImpact = new Point((int)Px, (int)Py);
					
					arrowAngle = angle;
				}else { //left-up
					double Px = associated.x - (Math.cos(angle)* hip);
					double Py = associated.y - (Math.sin(angle)* hip);
					arrowImpact = new Point((int)Px, (int)Py);
					
					arrowAngle = (180+(angle*180/Math.PI))*Math.PI/180;
				}
			}//slope type
			
		} //conditional type of line : horizontal, vertical, diagonal
		
		return generateArrow(arrowImpact, arrowAngle);
	} //calculateIntersection
	
	
	public String toString() {
		String info = element.toString()+" -> ";
		for (int i = 1; i <= asociatedVertex.getSize(); i++) {
			Vertex v = (Vertex) this.asociatedVertex.get(i);
			info+="("+v.element+","+this.weights.get(i)+")";
			if(i<asociatedVertex.getSize())
				info+=" - ";
		}
		return info;
	}
}//class end
