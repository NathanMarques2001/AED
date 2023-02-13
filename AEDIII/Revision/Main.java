
package Revision;

public class Main {
	public static void main(String[] args) {

		Employee one = new Employee("Iago", 1100);
		Employee two = new Employee("Edson", 2200);
		Employee three = new Employee("Rosa", 5000);
		Employee four = new Employee("Larissa", 1500);
		Employee five = new Employee("Lais", 800);
		Employee six = new Employee("Bruno", 5200);
		Employee seven = new Employee("Bruna", 7000);

		List EmployersList = new List();

		EmployersList.addNewEmployee(one);
		EmployersList.addNewEmployee(two);
		EmployersList.addNewEmployee(three);
		EmployersList.addNewEmployee(four);
		EmployersList.addNewEmployee(five);
		EmployersList.addNewEmployee(six);
		EmployersList.addNewEmployee(seven);

		EmployersList.printList();

		EmployersList.printSearchEmployeeForName("rosa");
		EmployersList.printSearchEmployeeForName("nathan");

		EmployersList.searchEmployeeForNumber(0);
		EmployersList.searchEmployeeForNumber(7);

		EmployersList.alphabeticalOrder();

		EmployersList.removeEmployeeForNumber(2);
		EmployersList.removeEmployeeForNumber(10);

		EmployersList.printList();
			
	}
}
