package Revision;

public class List {
  Employee Employers[] = new Employee[100];
  private int length = 0;

  public void add(Employee newEmployee) {
    if (Employers[99] == null) {
      for (int i = 0; i < Employers.length; i++) {
        if (Employers[i] == null) {
          Employers[i] = newEmployee;
          System.out.println("\nFuncionario " + newEmployee.getName()
              + " adicionado a lista.\n=============================================");
          length++;
          break;
        }
      }
    } else {
      System.out.print("A lista ja alcancou sua capacidade maxima!");
    }
  }

  public Employee search(int position) {
    System.out.println("\nBuscando funcionario pelo numero...\n---------------------------------------------");
    if (Employers[position] == null) {
      System.out.println("Nao encontrei ninguem nesta posicao!\n=============================================");
    } else {
      System.out.println("Encontrei " + Employers[position].getName()
          + " nesta posicao.\n=============================================");
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
      System.out.println("\nRemovendo um funcionario pelo numero...\n---------------------------------------------");
      System.out.println("Funcionario " + Employers[position].getName()
          + " removido da lista.\n=============================================");
      Employers[position] = null;
      length--;
      for (int i = 0; i < Employers.length; i++) {
        if (i < length) {
          if (Employers[i] == null && Employers[i + 1] != null) {
            Employers[i] = Employers[i + 1];
            Employers[i + 1] = null;
          }
        }
      }
    } else {
      System.out.println(
          "\nEsta posicao esta vazia, entao nao posso\nremover ninguem. Favor verificar o numero\nda pessoa que deseja remover!\n=============================================");
    }
  }

  public void containInList(String name) {
    System.out.println("\nBuscando funcionario na lista pelo nome...\n---------------------------------------------");
    if (contain(name)) {
      System.out.println("Encontrei " + name + " na lista!\n=============================================");
    } else {
      System.out.println("Nao encontrei " + name + " na lista =(\n=============================================");
    }
  }

  private boolean contain(String name) {
    for (int i = 0; i < Employers.length; i++) {
      if (Employers[i] != null) {
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
    System.out.println("\nLista de funcionarios e respectivos salarios\n---------------------------------------------");
    for (int i = 0; i < Employers.length; i++) {
      if (Employers[i] != null) {
        System.out.println(i + " -> " + Employers[i].getName() + " - $" + Employers[i].getSalary());
      } else {
        break;
      }
    }
    System.out.println("=============================================");
  }

  public Employee[] alphabeticalOrder() {
    Employee auxEmployee;
    Employee[]Emp = Employers;
    for (int i = 0; i < Emp.length; i++) {
      if (Emp[i] != null) {
        for (int j = 0; j < Emp.length; j++) {
          if (Emp[i].getName().compareTo(Emp[j].getName()) > 0) {
            auxEmployee = Emp[i];
            Emp[i] = Emp[j];
            Emp[j] = auxEmployee;
          }
        }
      } else {
        break;
      }
    }
    printAlphabeticalOrder(Emp);
    return Emp;
  }

  public void printAlphabeticalOrder(Employee []arr) {
    System.out.println("\nLista de funcionarios em ordenados por nome\n---------------------------------------------");
    for (int i = 0; i < Employers.length; i++) {
      if (Employers[i] != null) {
        System.out.println(i + " -> " + Employers[i].getName() + " - $" + Employers[i].getSalary());
      } else {
        break;
      }
    }
    System.out.println("=============================================");
  }
}
