class Person{
        private String name;
        private int age;
        //setter to add name

    public void setName(String name){
        this.name = name;  
    }
    public void setAge(int age){
        this.age = age;
    }
    public void getName(){
        // condition laga sktu boolean ki agar true hai toh access milega warna nahi 
        System.out.println(name);
    }
    public void getAge(){
        System.out.println(age);
    }
  
}
public class practise {
    
    public static void main(String[]args){
        Person p1 = new Person();
        p1.setName("Priyanshu");
        p1.setAge(21);
        p1.getName();
        p1.getAge();


    }
}
