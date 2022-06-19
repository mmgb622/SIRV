package GUI;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import Logic.DynamicGraph;
import Logic.GraphException;
import Logic.Vertex;

public class JMap extends JPanel implements MouseListener,MouseMotionListener{

	private DynamicGraph graph;
	private boolean movingVertex; 
	private Vertex selectedVertex;
	private boolean editable;
	private JPopupMenu optionMenu;
	private JMenuItem addVertex, editVertex, deleteVertex, manageEdges;
	
	public JMap(DynamicGraph grafo, int width, int height, boolean editable) {
		this.graph = grafo;
		this.movingVertex = false;
		this.selectedVertex = null;
		this.editable = editable;
		
		this.setSize(width,height);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		initMenu();
		repaint();
	}

	private void initMenu() {
		this.optionMenu = new JPopupMenu("Graph options");
		
		this.addVertex = new JMenuItem("Add new location");
		
		this.editVertex = new JMenuItem("Edit");
		
		this.deleteVertex = new JMenuItem("Delete location");
		
		this.manageEdges = new JMenuItem("Manage routes");
	}
	
	private void resetMenu() {
		this.optionMenu.add(addVertex);
		this.optionMenu.add(editVertex);
		this.optionMenu.add(deleteVertex);
		this.optionMenu.add(manageEdges);
	}

	public void paint(Graphics g) {
		g.setColor(Style.colors[5]);
		g.fillRect(0, 0, this.getWidth()-1, this.getHeight()-1);
		g.setColor(Style.colors[2]);
		g.drawRect(0, 0, this.getWidth()-1, this.getHeight()-1);
		graph.paint(g);
		
		g.setColor(Style.colors[0]);
		if(selectedVertex!=null) {
			g.fillOval(selectedVertex.area.x+5, selectedVertex.area.y+5, selectedVertex.area.width-10, selectedVertex.area.height-10);
			g.setColor(Style.colors[1]);
			g.drawString((String) selectedVertex.element, selectedVertex.x-30, selectedVertex.y-20);
		}
	}


	public void mouseDragged(MouseEvent e) {
		if(editable)
			if(movingVertex) {
				selectedVertex.updateVertexPosition(e.getPoint());
				repaint();
			}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		this.selectedVertex = null;
		try {
			for(int i=1;i<=graph.size();i++) {
				Vertex verified = graph.get(i);
				
				if(verified.area.contains(e.getPoint())) {
					movingVertex = true;
					this.selectedVertex = verified;
					break;
				}
			}//for verifies which vertex is selected
		} catch (GraphException e1) {
			e1.printStackTrace();
		}
		repaint();
	}//mousePressed


	@Override
	public void mouseReleased(MouseEvent e) {
		movingVertex = false;
		if(e.getButton() == MouseEvent.BUTTON3 && editable) {
			resetMenu();
			if(this.selectedVertex!=null) {
				this.optionMenu.remove(addVertex);
			}else {
				this.optionMenu.remove(editVertex);
				this.optionMenu.remove(deleteVertex);
				this.optionMenu.remove(manageEdges);
			}
			this.optionMenu.show(this, e.getX(), e.getY());	
		}
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		
	}


	public Vertex getSelectedVertex() {
		return selectedVertex;
	}


	public void setSelectedVertex(Vertex selectedVertex) {
		this.selectedVertex = selectedVertex;
	}

	public DynamicGraph getGraph() {
		return graph;
	}

	public void setGraph(DynamicGraph graph) {
		this.graph = graph;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public JMenuItem getAddVertex() {
		return addVertex;
	}

	public void setAddVertex(JMenuItem addVertex) {
		this.addVertex = addVertex;
	}

	public JMenuItem getEditVertex() {
		return editVertex;
	}

	public void setEditVertex(JMenuItem editVertex) {
		this.editVertex = editVertex;
	}

	public JMenuItem getDeleteVertex() {
		return deleteVertex;
	}

	public void setDeleteVertex(JMenuItem deleteVertex) {
		this.deleteVertex = deleteVertex;
	}

	public JMenuItem getManageEdges() {
		return manageEdges;
	}

	public void setManageEdges(JMenuItem manageEdges) {
		this.manageEdges = manageEdges;
	}

}//class end
