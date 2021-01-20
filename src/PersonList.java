import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonList extends java.awt.List {
    private int capacity;
    private final List<Person> list = new ArrayList<Person>();

    public PersonList(int maxPersons) { this.capacity = maxPersons; }

    private void addPerson(Person person) {
        if (list.size() == this.capacity) {
            System.out.println("The list is already full.");
        }
        else list.add(person);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\tName\t\t|\t Age \t|\tGender\n------------------------------------------\n");
        this.list.forEach((person) -> {
            stringBuilder.append("\t").append(person.getName())
                    .append("\t\t\t  ").append(person.getAge())
                    .append("\t\t").append(person.getGender()).append('\n');
        });
        return stringBuilder.toString();
    }

    private int getAverageOfAges() {
        int totalAge = this.list.stream()
                .peek(System.out::println)
                .map(Person::getAge)
                .peek(System.out::println)
                .reduce(0, Integer::sum);

        return totalAge/list.size();
    }

    private List<Person> getPersonsByCondition(Predicate<Person> condition) {
        return this.list.stream().
                filter(condition)
                .map(Person::getPerson)
                .collect(Collectors.toList());
    }

    private String printFiltered(List<Person> filteredList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\tName\t\t|\t Age \t|\tGender\n------------------------------------------\n");
        filteredList.forEach(person -> {
            stringBuilder.append("\t").append(person.getName())
                    .append("\t\t\t  ").append(person.getAge())
                    .append("\t\t").append(person.getGender()).append('\n');
        });
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Person one = new Person("John", 35, "male");
        Person two = new Person("Jane", 26, "female");
        Person three = new Person("Kyle", 45, "male");
        PersonList testList = new PersonList(3);
        testList.addPerson(one);
        testList.addPerson(two);
        testList.addPerson(three);

        System.out.println(testList.toString());
        System.out.println("Average age: " + testList.getAverageOfAges() + "\n");

        List<Person> filteredList =
                testList.getPersonsByCondition(person -> person.getGender().equals("female") && person.getAge()>18);
        System.out.println(testList.printFiltered(filteredList));
    }
}