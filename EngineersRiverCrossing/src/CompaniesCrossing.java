// Hannah Wenger
public class CompaniesCrossing {
	
	
	public static boolean searchEmployee(Employee[] employees) {
		
		boolean ifPassed = true;
		int crossingTicker = 0;
		
		if(employees[0].beforeBoatValue == employees[0].afterBoatValue) { //Did boat move
			displayError(0);
			ifPassed = false;
		}
		
		if(employees[0].beforeBoatValue >= 3 || employees[0].afterBoatValue >= 3) { // Did boat move to real location
			displayError(0);
			ifPassed = false;
		}
		
		for(int i = 0; i < employees.length; i++) {

			if(employees[i].beforeValue >= 3 || employees[i].afterValue >= 3) { // Did employee move to real location
				displayError(0);
				ifPassed = false;
			}
			if(employees[i].beforeValue != employees[i].afterValue) { // Increase Crossing Ticker if employee crossed sides
				crossingTicker++;
			}
		}
		
		if(crossingTicker >= 3) {
			
			displayError(0);
			ifPassed = false;
		}
		
		for(int i = 0; i < employees.length; i++) {
				for(int j = 0; j < employees.length; j++) {
				
					if(employees[i].afterValue == employees[j].afterValue && employees[i].company != employees[j].company) {
						if(employees[i].role == "manager" && employees[j].role == "engineer") {
							ifPassed = false;
						} else if(employees[i].role == "engineer" && employees[j].role == "manager") {
							ifPassed = false;
						} else {
							System.out.println("");
						}
					} else {
						System.out.println("");
					}
				}	
			}
		return ifPassed;
	}
	
	public static void displayError(int errorReference) {
		String[] messageArray = Messages.createMessageArr();
		String message = Messages.findMessage(messageArray, errorReference);
		Messages.printMessage(message);
	}
	
	public static Employee[] createEmployee(int beforeBoat, int beforeA, int beforeB, int beforeC,  //Method for creating Employees
			int beforeD, int beforeE, int beforeF, int afterBoat, int afterA, int afterB, 
			int afterC, int afterD, int afterE, int afterF) {

        Employee e1 = new Employee("A", "manager", 2, beforeA, afterA, beforeBoat, afterBoat);
        Employee e2 = new Employee("B", "manager", 1, beforeB, afterB, beforeBoat, afterBoat);
        Employee e3 = new Employee("C", "engineer", 2, beforeC, afterC, beforeBoat, afterBoat);
        Employee e4 = new Employee("D", "engineer", 1, beforeD, afterD, beforeBoat, afterBoat);
        Employee e5 = new Employee("E", "engineer", 3, beforeE, afterE, beforeBoat, afterBoat);
        Employee e6 = new Employee("F", "manager", 3, beforeF, afterF, beforeBoat, afterBoat);
		
        return new Employee[] {e1, e2, e3, e4, e5, e6};
	}
	
	public static boolean isMoveOkay(int beforeBoat, int beforeA, int beforeB, int beforeC, 
			int beforeD, int beforeE, int beforeF, int afterBoat, int afterA, int afterB, 
			int afterC, int afterD, int afterE, int afterF) {
		
	Employee[] employees = createEmployee(beforeBoat, beforeA, beforeB, beforeC, 
			beforeD, beforeE,  beforeF, afterBoat, afterA, afterB, 
			 afterC, afterD, afterE, afterF);
	boolean passedTest = searchEmployee(employees);
	
		
		return passedTest;
	}

}
