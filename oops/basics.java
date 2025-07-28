// class has Properties and behaviour
class Person{
    String name;
    String branch;
    int age;
    static String college;

    void talk(){
        System.out.println("Dhairya bolta kafi hai");
    }

    void walk(){
        System.out.println("He walks");
    }
    
    static int count;
    // public Person(){
    //     count++;
    //     System.out.println("This is 1ST constructor");
    // }

    void lazy(int n){
        System.out.print("Priyanshu is very lazy"+n);
    }
}
public class basics{
    public static void main(String[]args){
        Person p1 = new Person();// default constructor koi bhi arguments nhi leta hai 
        p1.name = "Priyanshu";
        p1.branch = "CSE";
        p1.college="Bharati vidhyapeeth college of engineering";
        System.out.println(p1.name);
        System.out.println(p1.branch);
        System.out.println(p1.college);
        Person p2 = new Person();
        p2.name = "Dhruv";
        p2.branch = "IT";
        System.out.println(p2.name);
        System.out.println(p2.branch);
        System.out.println(p2.college );
        p1.walk();
        
    }
    

}

