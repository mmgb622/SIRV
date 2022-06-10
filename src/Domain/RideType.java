package Domain;

public class RideType {
	
private String name;
private int distanceCost;
	
public RideType(String name, int distanceCost) {
	super();
	this.name = name;
	distanceCost = distanceCost;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getDistanceCost() {
	return distanceCost;
}
public void setDistanceCost(int distanceCost) {
	distanceCost = distanceCost;
}



}
