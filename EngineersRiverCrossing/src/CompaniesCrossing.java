// Hannah Wenger
public class CompaniesCrossing {
	
	public static void searchEmployee(Employee a, Employee b, Employee c, Employee d, Employee e, Employee f) {
		System.out.println(a);
		
	}
	public static void createEmployee(int beforeBoat, int beforeA, int beforeB, int beforeC, 
			int beforeD, int beforeE, int beforeF, int afterBoat, int afterA, int afterB, 
			int afterC, int afterD, int afterE, int afterF) {
		
		Employee a = new Employee("A", "manager", 2, beforeA, afterA);
		Employee b = new Employee("B", "manager", 1, beforeB, afterB);
		Employee c = new Employee("C", "engineer", 2, beforeC, afterC);
		Employee d = new Employee("D", "engineer", 1, beforeD, afterD);
		Employee e = new Employee("E", "engineer", 3, beforeE, afterE);
		Employee f = new Employee("F", "manager", 3, beforeF, afterF);
		searchEmployee(a, b, c, d, e, f);
		
		System.out.println(beforeBoat);
	}
	
	public static boolean isMoveOkay(int beforeBoat, int beforeA, int beforeB, int beforeC, 
			int beforeD, int beforeE, int beforeF, int afterBoat, int afterA, int afterB, 
			int afterC, int afterD, int afterE, int afterF) {
	createEmployee(beforeBoat, beforeA, beforeB, beforeC, 
			beforeD, beforeE,  beforeF, afterBoat, afterA, afterB, 
			 afterC, afterD, afterE, afterF);
		
		return false;
	}
	

}
