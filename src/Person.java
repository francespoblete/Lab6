public class Person {
    private String name;
    private int age;
    private String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    protected String getName() {
        return this.name;
    }
    protected int getAge() { return this.age; }
    protected String getGender() { return this.gender; }
    protected Person getPerson() { return this; }
}