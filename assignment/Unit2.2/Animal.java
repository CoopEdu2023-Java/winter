abstract class Animal {

    public abstract void sound();

}

class Lion extends Animal {

    @Override
    public void sound() {
        System.out.println("Ohhhhh");
    }

}

class Tiger extends Animal {

    @Override
    public void sound() {
        System.out.println("Meow");
    }
    
}