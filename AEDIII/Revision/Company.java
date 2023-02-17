package Revision;

public class Company {
    private Employee Employers[] = new Employee[100];
    private int length = 0;

    public void addNewEmployee(Employee newEmployee) {
        if (length <= Employers.length) {
            Employers[length] = newEmployee;
            System.out.println("\nFuncionario " + newEmployee.getName()
                    + " adicionado a base de dados.\n=============================================");
            length++;
        } else {
            System.out.print("A base de dados ja alcancou sua capacidade maxima!");
        }
    }

    public Employee searchEmployeeForNumber(int position) {
        System.out.println(
                "\nBuscando funcionario na posicao " + position + "...\n---------------------------------------------");
        if (Employers[position] == null) {
            System.out.println("Nao encontrei ninguem nesta posicao!\n=============================================");
        } else {
            System.out.println("Encontrei " + Employers[position].getName()
                    + " nesta posicao.\n=============================================");
        }
        return Employers[position];
    }

    public void printPositionIsBusy(int position) {
        if (positionIsBusy(position)) {
            System.out.println("A posicao " + position + " ja esta ocupada!");
        } else {
            System.out.println("A posicao " + position + " ainda nao foi ocupada!");
        }
    }

    private boolean positionIsBusy(int position) {
        if (Employers[position] != null) {
            return true;
        }
        return false;
    }

    public void removeEmployeeForNumber(int position) {
        System.out.println("\nRemovendo o funcionario na posicao " + position
                + "...\n---------------------------------------------");
        if (Employers[position] != null && position >= 0) {
            System.out.println("Funcionario " + Employers[position].getName()
                    + " removido da base de dados.\n=============================================");
            Employers[position] = null;
            length--;
            dataRealocation();
        } else {
            System.out.println("A posicao " + position
                    + " esta vazia, entao nao posso\nremover ninguem. Favor verificar o numero\nda pessoa que deseja remover!\n=============================================");
        }
    }

    // Organiza a lista apos remover alguem
    private Employee[] dataRealocation() {
        for (int i = 0; i < this.length; i++) {
            if (Employers[i] == null && Employers[i + 1] != null) {
                Employers[i] = Employers[i + 1];
                Employers[i + 1] = null;
            }
        }
        return Employers;
    }

    public void printSearchEmployeeForName(String name) {
        System.out.println("\nBuscando " + name + " na base de dados...\n---------------------------------------------");
        if (searchEmployeeForName(name)) {
            System.out.println("Encontrei " + name + " na base de dados!\n=============================================");
        } else {
            System.out.println("Nao encontrei " + name + " na base de dados =(\n=============================================");
        }
    }

    private boolean searchEmployeeForName(String name) {
        for (int i = 0; i < length; i++) {
            if (Employers[i].getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public int companyLength() {
        return Employers.length;
    }

    public void printCompanyData() {
        System.out.println(
                "\nFuncionarios e seus respectivos salarios\n---------------------------------------------");
        for (int i = 0; i < length; i++) {
            System.out.println((i + 1) + " -> " + Employers[i].getName() + " - R$" + Employers[i].getSalary());
        }
        System.out.println("=============================================");
    }

    public Employee[] alphabeticalOrder() {
        Employee auxEmployee;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (Employers[i].getName().compareTo(Employers[j].getName()) < 0) {
                    auxEmployee = Employers[i];
                    Employers[i] = Employers[j];
                    Employers[j] = auxEmployee;
                }
            }
        }
        return Employers;
    }
}
