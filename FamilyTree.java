import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FamilyTree {
    private List<Person> people;

    public FamilyTree() {
        this.people = new ArrayList<Person>();
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public void allTree() {
        System.out.println(people);
        System.out.println(people.size());
    }

    public void printTree() {
        // Integer ind = 1;
        for (Person person : people) {
            if (person.getParents().isEmpty()) { // check if person has no parents (is root)
                // ind++;
                printNode(person, 0);
            }
            // if (ind == 3) {
            //     break;
            // }
        }
    }
    

    private void printNode(Person person, int level) {
        String tabs = "";
        for (int i = 0; i < level; i++) {
            tabs += "\t";
        }
    
        // concatenate parents' names into a string
        String parents = "";
        Set<Person> parentsSet = new HashSet<>();
        for (Person parent : person.getParents()) {
            if(!parentsSet.contains(parent)){
                parents += parent.getName() + ", ";
            }
            parentsSet.add(parent);
        }
        if (parents.length() > 2) {
            parents = parents.substring(0, parents.length() - 2);
        }
        if (parents.length() < 1) {
            parents = "unknow";
        }
        
        // print person with parents' names
        System.out.println(tabs + person.getName() + "-parents: (" + parents + ")");
        
        // print children recursively
        for (Person child : person.getChildren()) {
            printNode(child, level + 1);
        }
    }

    public void printDescendants(Person person) {
        // recursively print the descendants of the person
    }

    public void printAncestors(Person person) {
        // recursively print the ancestors of the person
    }

    // other methods omitted for brevity
}
