package Revision;

class List {
    public List(Employee person) {
        Employee firstPerson;
        Employee lastPerson;
    }

    Employee maxEmployers[] = new Employee[100];


    public Employee search(int position) {
        if (maxEmployers[position] != null) {
            return maxEmployers[position];
        } else {
            return null;
        }
    }

    public boolean count(String name) {
        for (int i = 0; i < maxEmployers.length; i++) {
            if (name.equalsIgnoreCase(maxEmployers[i].getName())) {
                return true;
            }
        }
        return false;
    }

    public int getLength() {
        return maxEmployers.length;
    }

    public void printList() {
        for (int i = 0; i < maxEmployers.length; i++) {
            System.out.println("i -> " + maxEmployers[i].getName());
        }
    }

    private boolean countIsBusy(int position) {
        if (maxEmployers[position] == null) {
            return false;
        } else {
            return false;
        }
    }

}
