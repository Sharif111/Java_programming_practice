package Inheritance;

class Animal {

    // field and method of the parent class
    String name;

    public void eat() {
        System.out.println("I can eat");
    }
}

// inherit from Animal
class JerryTheMouse extends Animal {

    // new method in subclass
    public void display() {
        System.out.println("My name is " + name);
    }
}

public class Main {

    public static void main(String[] args) {

        // create an object of the subclass
        JerryTheMouse obj = new JerryTheMouse();

        // access field of superclass
        obj.name = "Jerry";
        obj.display();
        

        // call method of superclass
        // using object of subclass
        obj.eat();

    }
}
