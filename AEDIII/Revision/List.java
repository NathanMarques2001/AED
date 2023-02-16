package Revision;

public class List {
  private Employee Employers[] = new Employee[100];
  private int length = 0;

  public boolean isEmpty() {
    return true;
  }

  public void enqueue(Employee newEmployee) {
      if(length <= Employers.length){
        Employers[length] = newEmployee;
        length++;
        System.out.println("\nFuncionario " + newEmployee.getName()
                + " adicionado a lista.\n=============================================");
      } else {
        System.out.print("A lista ja alcancou sua capacidade maxima!");
      }
  }

  public void dequeue() {
    System.out.println("\nRemovendo o ultimo funcionario da lista...\n---------------------------------------------");
      if(Employers[length - 1] != null){
        System.out.println("Funcionario " + Employers[length - 1].getName()
                + " removido da lista.\n=============================================");
        Employers[length - 1] = null;
        length--;
      } else {
        System.out.println("A lista esta vazia, entao nao e possivel remover ninguem!\n=============================================");
      }
  }

  public void printContain(String name){
    System.out.println(
            "\nBuscando "+name+" na lista...\n---------------------------------------------");
    if(contain(name)){
      System.out.println("Encontrei " + name + " na lista!\n=============================================");
    } else{
      System.out.println("Nao encontrei " + name + " na lista!\n=============================================");
    }
  }

  private boolean contain(String name) {
    for (int i = 0; i < length; i++) {
      if(name.equalsIgnoreCase(Employers[i].getName())){
        return true;
      }
    }
    return false;
  }

  public void print() {
    System.out.println(
            "\nFuncionarios e seus respectivos salarios\n---------------------------------------------");
    for (int i = 0; i < length; i++) {
      System.out.println((i+1) + " -> " + Employers[i].getName() + " - R$" + Employers[i].getSalary());
    }
    System.out.println("=============================================");
  }

  public int size() {
    return length;
  }
}
