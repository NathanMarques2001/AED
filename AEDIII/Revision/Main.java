package Revision;

public class Main {
	public static void main(String[] args) {
		
		  Company CompanyData = new Company();
		  
		  CompanyData.addNewEmployee(new Employee("Iago", 1100));
		  CompanyData.addNewEmployee(new Employee("Edson", 2200));
		  CompanyData.addNewEmployee(new Employee("Rosa", 5000));
		  CompanyData.addNewEmployee(new Employee("Larissa", 1500));
		  CompanyData.addNewEmployee(new Employee("Lais", 800));
		  CompanyData.addNewEmployee(new Employee("Bruno", 5200));
		  CompanyData.addNewEmployee(new Employee("Bruna", 7000));
		  
		  CompanyData.printCompanyData();
		  
		  CompanyData.printSearchEmployeeForName("rosa");
		  CompanyData.printSearchEmployeeForName("nathan");
		  
		  CompanyData.searchEmployeeForNumber(0);
		  CompanyData.searchEmployeeForNumber(7);
		  
		  CompanyData.alphabeticalOrder();
		  
		  CompanyData.removeEmployeeForNumber(2);
		  CompanyData.removeEmployeeForNumber(10);
		  
		  CompanyData.printCompanyData();
		 
		////////////////////////////////////
		
		Stack EmployeeStack = new Stack();
			
		EmployeeStack.push(new Employee("Iago", 1100));
		EmployeeStack.push(new Employee("Edson", 2200));
		EmployeeStack.push(new Employee("Rosa", 5000));
		EmployeeStack.push(new Employee("Larissa", 1500));
		EmployeeStack.push(new Employee("Lais", 800));
		EmployeeStack.push(new Employee("Bruno", 5200));
		EmployeeStack.push(new Employee("Bruna", 7000));
		
		EmployeeStack.print();
	}
}
