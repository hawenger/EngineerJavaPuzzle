// Hannah Wenger
public class CompaniesCrossing {

    public static boolean illegalBoatVariables(Employee[] employees) {

        if(employees[0].beforeBoatValue >= 3 || employees[0].afterBoatValue >= 3) {

            return false;																	// Did boat move to real location

        } else {

            return true;
        }
    }

    public static boolean illegalEmployeeVariables(Employee[] employees) {

        boolean flag = true;

        for( int i = 0; i < employees.length; i++) {
            if(employees[i].beforeValue >= 3 || employees[i].afterValue >= 3) { // Did employee move to real location
                flag = false;
            }
        }

        return flag;

    }


    public static boolean stillBoat(Employee[] employees) { //Boat changing position

        if(employees[0].beforeBoatValue == employees[0].afterBoatValue) { //Did boat move

            return false;

        } else {

            return true;

        }
    }

    public static boolean sameSide(Employee[] employees) { //People moving on same side of boat

        boolean flag = true;

        for(int i = 0; i < employees.length; i++) {
            if(employees[i].beforeValue != employees[i].afterValue) {
                for(int j = 0; j < employees.length; j++) {
                    if(employees[j].beforeValue != employees[j].afterValue && employees[j].beforeValue != employees[i].beforeValue ) {
                        flag = false;
                    }
                }
            }
        }

        return flag;
    }

    public static boolean peopleMoving(Employee[] employees) {  // One or two people moving

        int crossingTicker = 0;
        boolean flag;

        for(int i = 0; i < employees.length; i++) {

            if(employees[i].beforeValue != employees[i].afterValue) { // Increase Crossing Ticker if employee crossed sides
                crossingTicker++;
            }
        }

        if(crossingTicker >= 3) {

            flag = false;

        } else {

            flag = true;

        }

        return flag;
    }

    public static boolean recruitmentOne(Employee[] employees) {

        boolean flag = true;

        for(int i = 0; i < employees.length; i++) {
        	
            for(int j = 0; j < employees.length; j++) {
                if(employees[i].afterValue == employees[j].afterValue && employees[i].company != employees[j].company) {
                    if(employees[i].role == "manager" && employees[j].role == "engineer") {
                        if(employees[i].role == "manager" & employees[i].company == 1) {
                            flag = false;
                        }

                    } else if(employees[i].role == "engineer" && employees[j].role == "manager") {
                        if(employees[i].role == "manager" & employees[i].company == 1) {
                            flag = false;

                        }

                    }
                }

            }
        }

        return flag;

    }


    public static boolean recruitmentTwo(Employee[] employees) {

        boolean flag = true;

        for(int i = 0; i < employees.length; i++) {
            for(int j = 0; j < employees.length; j++) {
                if(employees[i].afterValue == employees[j].afterValue && employees[i].company != employees[j].company) {
                    if(employees[i].role == "manager" && employees[j].role == "engineer") {
                        if(employees[i].role == "manager" & employees[i].company == 2) {
                            flag = false;
                        }

                    } else if(employees[i].role == "engineer" && employees[j].role == "manager") {
                        if(employees[i].role == "manager" & employees[i].company == 2) {
                            flag = false;

                        }

                    }
                }

            }
        }

        return flag;

    }

    public static boolean recruitmentThree(Employee[] employees) {
        boolean flag = true;

        for(int i = 0; i < employees.length; i++) {
            for(int j = 0; j < employees.length; j++) {
                if(employees[i].afterValue == employees[j].afterValue && employees[i].company != employees[j].company) {
                    if(employees[i].role == "manager" && employees[j].role == "engineer") {
                        if(employees[i].role == "manager" & employees[i].company == 3) {
                            flag = false;
                        }

                    } else if(employees[i].role == "engineer" && employees[j].role == "manager") {
                        if(employees[i].role == "manager" & employees[i].company == 3) {
                            flag = false;

                        }

                    }
                }

            }
        }

        return flag;

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

        boolean variablesBoat = illegalBoatVariables(employees);
        boolean variablesEmployee = illegalEmployeeVariables(employees);
        boolean unmovingBoat = stillBoat(employees);
        boolean onSameSide = sameSide(employees);
        boolean movingPeople = peopleMoving(employees);
        boolean recruit1 = recruitmentOne(employees);
        boolean recruit2 = recruitmentTwo(employees);
        boolean recruit3 =  recruitmentThree(employees);

        if(!variablesBoat) {
            String message = "All positions must be 1 or 2!";
            System.out.println(message);
            return false;
        } else if (!variablesEmployee) {
            String message = "All positions must be 1 or 2!";
            System.out.println(message);
            return false;
        } else if (!unmovingBoat) {
            String message = "The boat must move!";
            System.out.println(message);
            return false;
        } else if (!onSameSide) {
            String message = "You may not move a person who is not with the boat!";
            System.out.println(message);
            return false;
        } else if (!movingPeople) {
            String message = "You must move one or two people!";
            System.out.println(message);
            return false;
        } else if (!recruit1) {
            String message = "Company 1 manager would try to recruit someone!";
            System.out.println(message);
            return false;
        } else if (!recruit2) {
            String message = "Company 2 manager would try to recruit someone!";
            System.out.println(message);
            return false;
        } else if (!recruit3) {
            String message = "Company 3 manager would try to recruit someone!";
            System.out.println(message);
            return false;
        } else {
            String message = "You solved the puzzle!";
            System.out.println(message);
            return true;
        }

    }


}

public static boolean recruitmentOne(Employee[] employees) {

    boolean flag = true;

    for(int i = 0; i < employees.length; i++) {
        for (int j = 0; j < employees.length; j++) {
            if (employees[i].afterValue == employees[j].afterValue && employees[i].company != employees[j].company && employees[i].role == "manager" && employees[j].role == "engineer" && employees[i].company == 1) {
                for (int k = 0; k < employees.length; j++) {
                    if (employees[j].company == employees[k].company && employees[k].role == "manager" && employees[k].afterValue == employees[j].afterValue) {
                        flag = true;
                    } else {

                        flag = false;
                    }
                }
            } else if (employees[i].role == "engineer" && employees[j].role == "manager" && employees[j].company == 1) {
                for (int k = 0; k < employees.length; j++) {
                    if (employees[i].company == employees[k].company && employees[k].role == "manager" && employees[k].afterValue == employees[i].afterValue) {
                        flag = true;
                    } else {
                        flag = false;
                    }
                }

            }
        }
    }
    return flag;
}
