public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog("Yorkie");
        dog.breathe();
        dog.eat();

        Parrot parrot = new Parrot("Parrot");
        parrot.breathe();
        parrot.fly();
        parrot.eat();

        Penguin penguin = new Penguin("Emperor");
        penguin.fly();
    }
}
