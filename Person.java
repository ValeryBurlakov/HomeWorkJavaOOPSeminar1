import java.util.ArrayList;
import java.util.List;


public class Person {
    private String name;
    private String surname;
    private int age;
    private boolean isMale;
    private List<Person> children;
    private Person mother;
    private Person father;
    private List<Person> siblings;
    private List<Person> parents;

    public Person(String name, String surname, int age, boolean isMale) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.isMale = isMale;
        this.children = new ArrayList<Person>();
        this.siblings = new ArrayList<Person>();
        this.parents = new ArrayList<Person>();
    }

    // getters and setters omitted for brevity

    public void addChild(Person child) {
        children.add(child);
        child.setMother(this);
        child.setFather(this);
    }

    // public void addParents(Person parent) {
    //     parents.add(parent);
    //     parents.setChild(this);
    //     parents.setChild(this.getPartner());
    // }

    public void addSibling(Person sibling) {
        siblings.add(sibling);
        sibling.getSiblings().add(this);
    }

    public void setMother(Person mother) {
        this.mother = mother;
        parents.add(mother);
    }
    public void setFather(Person father) {
        this.father = father;
        parents.add(father);
    }

    // public List<Person> setChild(Person children) {
    //     this.children = children.getChildren();
    // }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public List<Person> getChildren() {
        return children;
    }

    public List<Person> getSiblings() {
        return siblings;
    }

    public List<Person> getParents() {
        return parents;
    }

    public String getName() {
        return name;
    }
    
    public Person getPartner() {
        if (isMale) {
            return getWife();
        } else {
            return getHusband();
        }
    }

    public Person getHusband() {
        for (Person sibling : siblings) {
            if (!sibling.isMale && sibling.getFather() == father) {
                return sibling;
            }
        }
        return null;
    }

    public Person getWife() {
        for (Person sibling : siblings) {
            if (sibling.isMale && sibling.getMother() == mother) {
                return sibling;
            }
        }
        return null;
    }

    @Override 
    public String toString() {
        // return "{" + "name='" + name + '\'' + " surname='" + surname + '\'' +
        //             ", age='" + age + '\'' + ", sex='" + sex + '\'' +'}';
        return String.format("name: %s %s age: %d, isMale: %s", name, surname, age, isMale);
    }


}