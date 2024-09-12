abstract class BankAccount{

    public abstract void deposit();
    public abstract void withdraw();

}

class SavingsAccount extends BankAccount{

    @Override
    public void deposit() {}

    @Override
    public void withdraw() {}

}

class CurrentAccount extends BankAccount{

    @Override
    public void deposit() {}

    @Override
    public void withdraw() {}
    
}