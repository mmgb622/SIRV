package Logic;

import javax.management.ListenerNotFoundException;

public class ExceptionHandling extends ListenerNotFoundException{
	
	public ExceptionHandling(String error) {
		super(error);
		// TODO Auto-generated constructor stub
	}

	public ExceptionHandling() {
		// TODO Auto-generated constructor stub
	}
	
	public void anyTimeOfError() {
		System.out.println("Error");
	}//anyTimeOfError
	
}//ExceptionHandling
