package Revision;

public class List {
	Employee Employers[] = new Employee[100];
	private int length = 0;

	public void addNewEmployee(Employee newEmployee) {
		if (Employers[99] == null) {
			Employers[length] = newEmployee;
			System.out.println("\nFuncionario " + newEmployee.getName()
					+ " adicionado a lista.\n=============================================");
			length++;

		} else {
			System.out.print("A lista ja alcancou sua capacidade maxima!");
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
		if (Employers[position] != null) {
			System.out.println("Funcionario " + Employers[position].getName()
					+ " removido da lista.\n=============================================");
			Employers[position] = null;
			length--;
			relocationInTheList();
		} else {
			System.out.println("A posicao " + position
					+ " esta vazia, entao nao posso\nremover ninguem. Favor verificar o numero\nda pessoa que deseja remover!\n=============================================");
		}
	}

	// Organiza a lista apos remover alguem
	private Employee[] relocationInTheList() {
		for (int i = 0; i < length; i++) {
			if (Employers[i] == null && Employers[i + 1] != null) {
				Employers[i] = Employers[i + 1];
				Employers[i + 1] = null;
			}
		}
		return Employers;
	}

	public void printSearchEmployeeForName(String name) {
		System.out.println("\nBuscando " + name + " na lista...\n---------------------------------------------");
		if (searchEmployeeForName(name)) {
			System.out.println("Encontrei " + name + " na lista!\n=============================================");
		} else {
			System.out.println("Nao encontrei " + name + " na lista =(\n=============================================");
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

	public int listLength() {
		return Employers.length;
	}

	public void printList() {
		System.out.println(
				"\nLista de funcionarios e respectivos salarios\n---------------------------------------------");
		int i = 0;
		while (i < length) {
			System.out.println(i + " -> " + Employers[i].getName() + " - R$" + Employers[i].getSalary());
			i++;
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
		printAlphabeticalOrder(Employers);
		return Employers;
	}

	public void printAlphabeticalOrder(Employee[] arr) {
		System.out
				.println("\nLista de funcionarios em ordem alfabetica\n---------------------------------------------");
		for (int i = 0; i < length; i++) {
			System.out.println(i + " -> " + Employers[i].getName() + " - R$" + Employers[i].getSalary());
		}
		System.out.println("=============================================");
	}
}