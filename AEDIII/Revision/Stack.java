package Revision;

public class Stack {
    private Employee Employers[] = new Employee[100];
    private int length = 0;

    private boolean isEmpty(){
        if(Employers[0] == null){
            return true;
        }
        return false;
    }

    public void printIsEmpty(){
        System.out.println("\nVerificando se a pilha esta vazia...\n---------------------------------------------");
        if(isEmpty()){
            System.out.println("A pilha esta vazia!\n=============================================");
        } else {
            System.out.println("A nao pilha esta vazia!\n=============================================");
        }
    }


    public void push(Employee newEmployee) {
        //Como esta sendo inserido -> Iago, Edson, Rosa, Larissa, Lais, Bruno, Bruna
        //Como deve ser imprimido -> Bruna, Bruno, Lais, Larissa, Rosa, Edson, Iago
        if(length < Employers.length){
            if(Employers[0] == null){
                Employers[0] = newEmployee;
                length++;
            } else {
                for (int i = 0; i < length; i++) {
                    Employers[length - i] = Employers[length - i - 1];
                }
                Employers[0] = newEmployee;
                length++;
            }
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

    public void printContain(String name){
        System.out.println(
                "\nBuscando "+name+" na pilha...\n---------------------------------------------");
        if(contain(name)){
            System.out.println("Encontrei " + name + " na pilha!\n=============================================");
        } else{
            System.out.println("Nao encontrei " + name + " na pilha!\n=============================================");
        }
    }

    private boolean contain(String name) {
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
        for (int i = 0; i < length; i++) {
            System.out.println((length - i) + " -> " + Employers[i].getName() + " - R$" + Employers[i].getSalary());
        }
        System.out.println("=============================================");
    }

    public int size() {
        return length;
    }
}
