package Revision;

public class Stack {
	private Employee Employers[] = new Employee[100];
	private int length = 0;

	public boolean isEmpty() {
		return true;
	}

	public void push(Employee newEmployee) {
		if (length < 100) {
			for (int i = length; i == 0; i--) {
				Employers[i + 1] = Employers[i];
			}
			Employers[0] = newEmployee;
			length++;
		}
	}

	public void pop() {
		if (Employers[0] != null) {
			for (int i = 0; i < length; i++) {
				Employers[i] = Employers[i + 1];
			}
			Employers[length] = null;
			length--;
		}
	}

	public boolean contain(String name) {
		for (int i = 0; i < length; i++) {
			if (name.equalsIgnoreCase(Employers[i].getName())) {
				return true;
			}
		}
		return false;
	}

	public void print() {
		System.out.println(
				"\nLista de funcionarios e respectivos salarios\n---------------------------------------------");
		for (int i = length; i == 0; i++) {
			System.out.println(i + " -> " + Employers[i].getName() + " - R$" + Employers[i].getSalary());
		}
		System.out.println("=============================================");
	}

	public int size() {
		return length;
	}
}
