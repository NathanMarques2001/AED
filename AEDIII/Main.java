package Revision;

public class Main {
  public static void main(String[] args) {
    /*
     * Liste todos os funcionários em ordem alfabética
     * Realizar uma remoção de um registro existente
     * Tentar uma remoção de um registro não existente
     */
    Employee one = new Employee("Iago", 1100);
    Employee two = new Employee("Edson", 2200);
    Employee three = new Employee("Rosa", 5000);
    Employee four = new Employee("Larissa", 1500);
    Employee five = new Employee("Lais", 800);

    List EmployersList = new List();

    EmployersList.add(one);
    EmployersList.add(two);
    EmployersList.add(three);
    EmployersList.add(four);
    EmployersList.add(five);

    EmployersList.printList();

    EmployersList.containInList("rosa");
    EmployersList.containInList("nathan");

    EmployersList.search(0);
    EmployersList.search(5);

    EmployersList.alphabeticalOrder();

    EmployersList.remove(1);
    EmployersList.remove(10);

    EmployersList.printList();

  }
}
