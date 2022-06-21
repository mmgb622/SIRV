package GUI.administrator;

import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import GUI.JMap;
import GUI.Style;
import Logic.DynamicGraph;
import Logic.GraphException;
import Logic.Vertex;

public class JPManageMap extends JPanel implements ActionListener{

	private JLabel title;
	private JButton update; 
	private JMap map;
	
	private VertexInfo vertexInfo;
	private ManageRoutes vertexRoutes;
	
	public JPManageMap() {
		this.setLayout(null);
		this.setBackground(Style.colors[0]);
		this.setSize(900, 580);
		
		initMap();
		
		init();
	}//constructor

	private void initMap() {
		DynamicGraph mapGraph = new DynamicGraph();
		
		//Here comes the reading of graph from memory in files
		//>>
		
		this.map = new JMap(mapGraph, 580, 540, true);
		this.map.setLocation(10, 0);
		
		this.map.getAddVertex().addActionListener(this);
		this.map.getEditVertex().addActionListener(this);
		this.map.getDeleteVertex().addActionListener(this);
		this.map.getManageEdges().addActionListener(this);
		this.add(map);
	}//initMap
	
	private void init() {
		this.title = new JLabel("Map management");
		this.title.setBounds(600, 10, 300, 40);
		Style.setTitle(title);
		this.add(title);
		
		this.update = new JButton("Update map");
		this.update.setBounds(660, 490, 180, 40);
		this.update.addActionListener(this);
		Style.setButton(update);
		this.add(update);
		
		this.vertexInfo = new VertexInfo(this);
		this.vertexInfo.setLocation(600,90);
		this.vertexRoutes = new ManageRoutes(this.map.getGraph(), this);
		this.vertexRoutes.setLocation(600, 60);
		reset();
	}//init

	public void reset() {
		this.remove(this.vertexRoutes);
		this.vertexRoutes.setVisible(false);
		this.remove(vertexInfo);
		this.vertexInfo.setVisible(false);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.update)) {
			//waiting for the files saving, then here it updates the graph
			
		}else if(e.getSource().equals(this.map.getAddVertex())){
			Point location = this.map.getMousePosition();
			String name = "Location";
			try {
				name +=  " "+ (this.map.getGraph().size()+1);
				this.map.getGraph().addVertex(name);
				this.map.getGraph().getByContent(name).updateVertexPosition(location);
				this.map.setSelectedVertex(this.map.getGraph().get(this.map.getGraph().size()));
				
				this.reset();
				
				this.vertexInfo.updateInfo(this.map.getSelectedVertex());
				
				//it will show a panel to edit the added vertex
				this.add(this.vertexInfo);
				this.vertexInfo.setVisible(true);
				
			} catch (GraphException e1) {
				e1.printStackTrace();
			}
		
		}else if(e.getSource().equals(this.map.getDeleteVertex())) {  //delete a vertex and its connections
			DynamicGraph graphMap = this.map.getGraph();
			try {
				graphMap.deleteVertex(this.map.getSelectedVertex());
			} catch (GraphException e1) {
				e1.printStackTrace();
			}
			this.map.setSelectedVertex(null);
			this.reset();
			
		} else if(e.getSource().equals(this.map.getEditVertex())) {
			this.reset();
			
			this.vertexInfo.updateInfo(this.map.getSelectedVertex());
			
			this.add(vertexInfo);
			this.vertexInfo.setVisible(true);
			
		} else if(e.getSource().equals(this.map.getManageEdges())) {
			reset();
			this.vertexRoutes.updateInfo(this.map.getSelectedVertex());
			
			this.add(vertexRoutes);
			this.vertexRoutes.setVisible(true);
		}
		repaint();
	}//actionPerformed

	
	private class VertexInfo extends JPanel implements Runnable, ActionListener{
		private JLabel name , x , y;
		private JTextField vertexName;
		private JButton changeName;
		private Vertex vertex;
		private Thread updater;
		
		public VertexInfo(ActionListener listener) {
			this.setSize(270,400);
			this.setLayout(null);
			this.setBackground(null);
			
			initElements(listener);
			
			this.updater = new Thread(this);
			this.updater.start();
		}
		
		private void initElements(ActionListener listener) {
			this.name = new JLabel("Name: ");
			this.name.setBounds(30,50,100,30);
			Style.text(name);
			this.add(name);
			
			this.vertexName = new JTextField(); 
			this.vertexName.setBounds(130, 45, 100, 40);
			Style.setTextField(vertexName);
			this.add(vertexName);
			
			this.x = new JLabel("");
			this.x.setBounds(30, 90, 150, 30);
			Style.text(x);
			this.add(x);
			
			this.y = new JLabel();
			this.y.setBounds(30, 130, 150, 30);
			Style.text(y);
			this.add(y);
			
			this.changeName = new JButton("Change name");
			this.changeName.setBounds(40,170,200,50);
			Style.setButton(changeName);
			this.changeName.addActionListener(this);
			this.changeName.addActionListener(listener);
			this.add(changeName);
			
		}
		
		public void updateInfo(Vertex v) {
			this.vertex = v;
			this.vertexName.setText((String) vertex.element);
			this.x.setText("X position: "+ this.vertex.x); 
			this.y.setText("Y position: "+ this.vertex.y);
		}

		@Override
		public void run() {
			while(true) {
				try {
					this.x.setText("X position: "+ this.vertex.x); 
					this.y.setText("Y position: "+ this.vertex.y);
				}catch (Exception e) {}
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(this.changeName))
				this.vertex.element = this.vertexName.getText();
		}
		
		
	}// end class VertexInfo

	
	private class ManageRoutes extends JPanel implements ActionListener{
		private Vertex vertex;
		private DynamicGraph map;
		private JComboBox<String> openRoutes, closedRoutes;
		private JLabel title, jlOpen, jlClosed, jlAddWeight, jlChangeWeight;
		private JTextField addWeight, changeWeight;
		private JButton addEdge, updateEdge, deleteEdge;
		
		
		public ManageRoutes(DynamicGraph map, ActionListener listener) {
			this.setSize(280,400);
			this.setLayout(null);
			this.setBackground(null);
			this.map = map;
			initComponents(listener);
			//updateRoutes();
			repaint();
		}
		
		private void initComponents(ActionListener listener) {
			this.title = new JLabel();
			this.title.setBounds(0, 0, 280, 40);
			Style.setSubtitle(title);
			this.title.setFont(title.getFont().deriveFont(16));
			this.add(title);
			
			this.jlClosed = new JLabel("Closed routes");
			this.jlClosed.setBounds(0, 40, 200, 30);
			Style.text(jlClosed);
			this.add(jlClosed);
			
			this.closedRoutes = new JComboBox<>();
			this.closedRoutes.setBounds(0, 70, 280, 30);
			this.closedRoutes.setBackground(Style.colors[6]);
			this.closedRoutes.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
			this.closedRoutes.setFocusable(false);
			this.add(this.closedRoutes);
			
			this.jlAddWeight = new JLabel("Weight:");
			this.jlAddWeight.setBounds(0,110,100,30);
			Style.text(jlAddWeight);
			this.add(jlAddWeight);
			
			this.addWeight = new JTextField();
			this.addWeight.setBounds(100, 110, 180, 30);
			Style.setTextField(addWeight);
			this.add(this.addWeight);
			
			this.addEdge = new JButton("Add route");
			this.addEdge.setBounds(20, 150, 240, 40);
			this.addEdge.addActionListener(listener);
			this.addEdge.addActionListener(this);
			Style.setButton(this.addEdge);
			this.add(addEdge);
			
			this.jlOpen = new JLabel("Open routes");
			this.jlOpen.setBounds(0, 200, 200, 30);
			Style.text(jlOpen);
			this.add(jlOpen);
			
			this.openRoutes = new JComboBox<>();
			this.openRoutes.setBounds(0, 230, 280, 30);
			this.openRoutes.setBackground(Style.colors[6]);
			this.openRoutes.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
			this.openRoutes.setFocusable(false);
			this.openRoutes.addActionListener(this);
			this.add(this.openRoutes);
			
			this.jlChangeWeight = new JLabel("Weight:");
			this.jlChangeWeight.setBounds(0,270,100,30);
			Style.text(jlChangeWeight);
			this.add(jlChangeWeight);
			
			this.changeWeight = new JTextField();
			this.changeWeight.setBounds(100, 270, 180, 30);
			Style.setTextField(changeWeight);
			this.add(this.changeWeight);
			
			this.updateEdge = new JButton("Update weight");
			this.updateEdge.setBounds(20, 310, 240, 40);
			this.updateEdge.addActionListener(this);
			Style.setButton(this.updateEdge);
			this.add(updateEdge);
			
			this.deleteEdge = new JButton("Remove route");
			this.deleteEdge.setBounds(20, 360, 240, 40);
			this.deleteEdge.addActionListener(listener);
			this.deleteEdge.addActionListener(this);
			Style.setButton(this.deleteEdge);
			this.add(deleteEdge);
		}//initComponents

		private void updateRoutes() {
			this.openRoutes.removeAllItems();
			this.closedRoutes.removeAllItems();
			
			try {
				for(int i = 1; i<=map.size();i++) {
					if(!map.get(i).equals(this.vertex))
						if(vertex.asociatedVertex.exists(map.get(i))) {
							this.openRoutes.addItem((String) map.get(i).element);
						}else {
							this.closedRoutes.addItem((String) map.get(i).element);
						}
				}
			} catch (GraphException e) {
				e.printStackTrace();
			}
			
			this.changeWeight.setText(""+this.vertex.weights.get(1));
		}
		
		public void updateInfo(Vertex v) {
			this.vertex = v;
			this.title.setText(""+this.vertex.element);
			updateRoutes();
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(openRoutes)) {
				int selectedIndex = openRoutes.getSelectedIndex()+1;
				String associatedWeight = ""+ this.vertex.weights.get(selectedIndex);
				this.changeWeight.setText(associatedWeight);
				
			} else if(e.getSource().equals(this.updateEdge)) {
				if(this.openRoutes.getItemCount()==0)
					JOptionPane.showMessageDialog(this, "There's no posible location to update");
				else {
					int selectedIndex = openRoutes.getSelectedIndex()+1;
					int weight = Integer.parseInt(this.changeWeight.getText());
					this.vertex.weights.set(selectedIndex, weight);
				}
				
			}else if(e.getSource().equals(this.addEdge)) {
				if(this.closedRoutes.getItemCount()==0)
					JOptionPane.showMessageDialog(this, "There's no posible location to create the route");
				else {
					if(this.addWeight.getText().isBlank())
						try {
							this.map.addEdge(this.vertex.element, this.closedRoutes.getSelectedItem());
						} catch (GraphException e1) {
							e1.printStackTrace();
						}
					else {
						int weight = Integer.parseInt(this.addWeight.getText());
						try {
							this.map.addEdge(this.vertex.element, this.closedRoutes.getSelectedItem(), weight);
						} catch (GraphException e1) {
							e1.printStackTrace();
						}
					}//if else whether or not is a specific weight	
				}
				updateRoutes();
			} else if(e.getSource().equals(this.deleteEdge)) {
				if(this.openRoutes.getItemCount()==0)
					JOptionPane.showMessageDialog(this, "There's no posible route to delete");
				else {
					Vertex associated = this.map.getByContent(this.openRoutes.getSelectedItem());
					this.map.deleteEdge(this.vertex, associated);
	
					updateRoutes();
				}
			}
		}//actionPerformed
		
	}//class end (ManageRoutes)
	
}//class end