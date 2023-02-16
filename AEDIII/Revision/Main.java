package Revision;

public class Main {
  public static void main(String[] args) {

    Company CompanyData = new Company();

    System.out.println("\n++++++TESTANDO A CLASSE EMPRESA++++++");

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

    System.out.println("\n++++++FIM DOS TESTES DA CLASSE EMPRESA++++++");
    System.out.println("............................................");

    //////////////////////////////////////////////////////////

    System.out.println("\n++++++TESTANDO A CLASSE PILHA++++++");

    Stack EmployersStack = new Stack();

    EmployersStack.push(new Employee("Iago", 1100));
    EmployersStack.push(new Employee("Edson", 2200));
    EmployersStack.push(new Employee("Rosa", 5000));
    EmployersStack.push(new Employee("Larissa", 1500));
    EmployersStack.push(new Employee("Lais", 800));
    EmployersStack.push(new Employee("Bruno", 5200));
    EmployersStack.push(new Employee("Bruna", 7000));

    EmployersStack.print();

    EmployersStack.printContain("rosa");
    EmployersStack.printContain("nathan");

    EmployersStack.pop();
    EmployersStack.pop();

    EmployersStack.print();

    System.out.println("\n++++++FIM DOS TESTES DA CLASSE PILHA++++++");
    System.out.println("............................................");

    //////////////////////////////////////////////////////////

    System.out.println("\n++++++TESTANDO A CLASSE LISTA++++++");

    List EmployersList = new List();

    EmployersList.enqueue(new Employee("Iago", 1100));
    EmployersList.enqueue(new Employee("Edson", 2200));
    EmployersList.enqueue(new Employee("Rosa", 5000));
    EmployersList.enqueue(new Employee("Larissa", 1500));
    EmployersList.enqueue(new Employee("Lais", 800));
    EmployersList.enqueue(new Employee("Bruno", 5200));
    EmployersList.enqueue(new Employee("Bruna", 7000));

    EmployersList.print();

    EmployersList.printContain("rosa");
    EmployersList.printContain("nathan");

    EmployersList.dequeue();
    EmployersList.dequeue();

    EmployersList.print();

    System.out.println("\n++++++FIM DOS TESTES DA CLASSE LISTA++++++");
    System.out.println("............................................");
  }
}
