abstract class Employee {

    public abstract void calcutateSalary();
    public abstract void displayInfo();
    
}

class Manager extends Employee {

    @Override
    public void calcutateSalary() {}

    @Override
    public void displayInfo() {}

}

class Programmer extends Employee {

    @Override
    public void calcutateSalary() {}

    @Override
    public void displayInfo() {}

}