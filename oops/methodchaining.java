// Current object ke methods ko access krna 
class Person {
    private String name;
    private int age;


    Person setName(String name) {
        this.name = name;
        return this;  // current object return kar raha hai
    }

    Person setAge(int age) {
        this.age = age;
        return this;  // current object return kar raha hai
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}


public class methodchaining{
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Alice").setAge(30).display();  // method chaining
        
    }

}
