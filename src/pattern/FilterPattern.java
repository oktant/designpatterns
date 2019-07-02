package pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oalizada on 12/8/2016.
 */
public class FilterPattern {
}
class Person{
    private String name;
    private String gender;
    private String maritalStatus;
    public Person(String name, String gender, String maritalStatus){
        this.name = name;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
    }
    public String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }
    public String getMaritalStatus() {
        return maritalStatus;
    }

}

interface Criteria{
    public List<Person> meetCriteria(List<Person> personList);

}
class CriteriaMale implements Criteria{
    public List<Person> meetCriteria(List<Person> persons){
        List<Person> maleList=new ArrayList<>();
        for(Person person:persons){
            if(person.getGender().equals("male"));
                maleList.add(person);
        }
        return maleList;
    }

}
class CriteriaFemale implements Criteria{
    public List<Person> meetCriteria(List<Person> persons){
        List<Person> femaleList=new ArrayList<>();
        for(Person person:persons){
            if(person.getGender().equals("female"));
            femaleList.add(person);
        }
        return femaleList;
    }


}

class CriteriaSingle implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> singlePersons = new ArrayList<Person>();
        for (Person person : persons) {
            if(person.getMaritalStatus().equalsIgnoreCase("SINGLE")){
                singlePersons.add(person);
            }
        }
        return singlePersons;
    }
}

class AndCriteria implements  Criteria{
    Criteria criteria;
    Criteria othercriteria;

    AndCriteria(Criteria criteria, Criteria othercriteria){
        this.criteria=criteria;
        this.othercriteria=othercriteria;
    }
    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> firstPersonCriteria=criteria.meetCriteria(personList);
        return othercriteria.meetCriteria(firstPersonCriteria);
    }
}
class OrCriteria implements Criteria{
    Criteria criteria;
    Criteria otherCriteria;
    OrCriteria(Criteria criteria, Criteria otherCriteria){
        this.criteria=criteria;
        this.otherCriteria=otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> firsCriteria =criteria.meetCriteria(personList);
        List<Person> secondCriteria=criteria.meetCriteria(personList);
        for(Person aa:firsCriteria){
            if(secondCriteria.contains(aa)){
                secondCriteria.add(aa);
            }
        }
        return secondCriteria;
    }
}
 class CriteriaPatternDemo {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("Robert", "Male", "Single"));
        persons.add(new Person("John", "Male", "Married"));
        persons.add(new Person("Laura", "Female", "Married"));
        persons.add(new Person("Diana", "Female", "Single"));
        persons.add(new Person("Mike", "Male", "Single"));
        persons.add(new Person("Bobby", "Male", "Single"));
        Criteria male = new CriteriaMale();
        Criteria female = new CriteriaFemale();
        Criteria single = new CriteriaSingle();
        Criteria singleMale = new AndCriteria(single, male);
        Criteria singleOrFemale = new OrCriteria(single, female);
        System.out.println("Males: ");
        printPersons(male.meetCriteria(persons));
        System.out.println("\nFemales: ");
        printPersons(female.meetCriteria(persons));
        System.out.println("\nSingle Males: ");
        printPersons(singleMale.meetCriteria(persons));
        System.out.println("\nSingle Or Females: ");
        printPersons(singleOrFemale.meetCriteria(persons));
    }

    public static void printPersons(List<Person> persons) {
        for (Person person : persons) {
            System.out.println("Person : [ Name : " + person.getName()
                    + ", Gender : " + person.getGender()
                    + ", Marital Status : " + person.getMaritalStatus()
                    + " ]");
        }
    }
}