package Revision;

public class List {
  Employee Employers[] = new Employee[100];

  public void add(Employee newEmployee) {
    if (Employers[99] == null) {
      for (int i = 0; i < Employers.length; i++) {
        if (Employers[i] == null) {
          Employers[i] = newEmployee;
          System.out.println("Funcionario " + newEmployee.getName() + " adicionado a lista.");
          break;
        }
      }
    } else {
      System.out.print("A lista ja alcancou sua capacidade maxima!");
    }
  }


  public Employee search(int position) {
    if(Employers[position] == null){
      System.out.println("Nao achei");
    } else {
      System.out.println(Employers[position].getName());
    }
      return Employers[position];
  }

  private boolean positionIsBusy(int position) {
    if (Employers[position] != null) {
      return true;
    }
    return false;
  }

  public void remove(int position) {
    if (Employers[position] != null) {
      System.out.println("Funcionario " + Employers[position] + " removido da lista.");
      Employers[position] = null;
    } else {
      System.out.println("Esta posicao ainda nao foi ocupada!");
    }
  }

  public void containInList(String name) {
    if (contain(name)) {
      System.out.println("Encontrei " + name + " na lista!");
    } else {
      System.out.println("Nao encontrei " + name + " na lista =(");
    }
  }

  private boolean contain(String name) {
    for (int i = 0; i < Employers.length; i++) {
      if(Employers[i] != null) {
        if (Employers[i].getName().equalsIgnoreCase(name)) {
          return true;
        }
      } else {
        break;
      }
    }
    return false;
  }

  public int length() {
    return Employers.length;
  }

  public void printList() {
    System.out.println("Lista de funcionarios e respectivos salarios\n=====================================");
    for (int i = 0; i < Employers.length; i++) {
      if (Employers[i] != null) {
        System.out.println(i + " -> " + Employers[i].getName() + " - " + Employers[i].getSalary());
      } else {
        break;
      }
    }
  }

  public void orderByName() {
    System.out.println("Lista de funcionarios em ordenados por nome\n=====================================");
    for (int i = 0; i < Employers.length; i++) {
      if(Employers[i] != null){
        System.out.println("1 -> " + Employers[i].getName() + " - " + Employers[i].getSalary());
      } else {
        break;
      }
    }
  }
}
