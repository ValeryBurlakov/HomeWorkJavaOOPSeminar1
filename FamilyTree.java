import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FamilyTree {
    
    private List<Person> people;
    private List<Person> partners;

    public FamilyTree() {
        this.people = new ArrayList<Person>();
        this.partners = new ArrayList<Person>();
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
                parents += parent.getName() + " " + parent.getSurname() + " ";
            }
            parentsSet.add(parent);
        }
        if (parents.length() > 1) {
            parents = parents.substring(0, parents.length()); // было: length() - 2
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

    public void saveToFile(String filename) {
        try {
            FileWriter writer = new FileWriter(filename);
            
            // iterate over all people in the tree
            for (Person person : people) {
                // concatenate parents' names into a string
                String parents = "";
                Set<Person> parentsSet = new HashSet<>();
                for (Person parent : person.getParents()) {
                    if(!parentsSet.contains(parent)){
                        parents += parent.getName() + " " + parent.getSurname() + " ";
                    }
                    parentsSet.add(parent);
                }
                if (parents.length() > 1) {
                    parents = parents.substring(0, parents.length() - 1);
                }
                if (parents.length() < 1) {
                    parents = "unknown";
                }
                
                // concatenate children's names into a string
                String children = "";
                Set<Person> childrenSet = new HashSet<>();
                for (Person child : person.getChildren()) {
                    if(!childrenSet.contains(child)){
                        children += child.getName() + " " + child.getSurname() + ", ";
                    }
                    childrenSet.add(child);
                }
                if (children.length() > 2) {
                    children = children.substring(0, children.length() - 2);
                }
                if (children.length() < 1) {
                    children = "none";
                }
                
                // write person's data to file
                writer.write(person.getId() + ": " + person.getName() + " " + person.getSurname() +  " partner: " + person.getPartner()
                                            + ", parents: " + parents + ", children: " + children + "\n");
            }
            
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // other methods omitted for brevity
}



    // private void printNode(Person person, int level) {
    //     String tabs = "";
    //     for (int i = 0; i < level; i++) {
    //         tabs += "\t";
    //     }
    
    //     // concatenate parents' names into a string
    //     String parents = "";
    //     Set<Person> parentsSet = new HashSet<>();
    //     if (person.getParents().isEmpty()) {
    //         parents = "unknown";
    //     } else {
    //     for (Person parent : person.getParents()) {
    //         if(!parentsSet.contains(parent)){
    //             parents += parent.getName() + " " + parent.getSurname() + " ";
    //         }
    //         parentsSet.add(parent);
    //     }
    //     if (parents.length() > 2) {
    //         parents = parents.substring(0, parents.length()); // было: length() - 2
    //     }
    //     // if (parents.length() < 1) {
    //     //     parents = "unknownqq";
    //     }
    
    //     // concatenate children's names into a string
    //     String children = "";
    //     Set<Person> childrenSet = new HashSet<>();
    //     for (Person child : person.getChildren()) {
    //         if(!childrenSet.contains(child)){
    //             children += child.getName() + " " + child.getSurname() + ", ";
    //         }
    //         childrenSet.add(child);
    //     }
    //     if (children.length() > 2) {
    //         children = children.substring(0, children.length() - 2);
    //     }
    //     if (children.length() < 1) {
    //         children = "none";
    //     }
    
    //     // concatenate spouse's name into a string
    //     String spouse = (person.getPartner() != null) ? person.getPartner().getName() + " " + person.getPartner().getSurname() : "unknownww";
    //     System.out.println(tabs + person.getName() + " " + person.getSurname() + ", spouse: " + spouse + ", parents: (" + parents + ")");
    
    //     // print children recursively
    //     for (Person child : person.getChildren()) {
    //         printNode(child, level + 1);
    //     }
    // }
    
