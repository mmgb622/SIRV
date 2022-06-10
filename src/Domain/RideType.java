package Domain;

public class RideType {
	
String name;
int CostoPorDistancia;
public RideType(String name, int costoPorDistancia) {
	super();
	this.name = name;
	CostoPorDistancia = costoPorDistancia;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getCostoPorDistancia() {
	return CostoPorDistancia;
}
public void setCostoPorDistancia(int costoPorDistancia) {
	CostoPorDistancia = costoPorDistancia;
}



}
