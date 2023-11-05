public class People {
    protected int id;
    protected String name;
    protected String sex;
    protected int age;

    public People(int id, String name, String sex,int age){
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;

    }
    public String getName(){
         return name;
    }
    protected void liu() {
        System.out.println("This is a protected method in people.");
    }
    void ze() {
        System.out.println("This is a default method in people.");
    }
    private void xu() {
        System.out.println("This is a private method in people.");
    }
}
       
    
