
public class programm {
    // private Printerimpl printerimpl; // sem 2
    public static void main(String[] args) {
        // Printerimpl printt = new Printerimpl(); // 2 домашка
        // SaveFiles savefiles = new Printerimpl(); // 2 домашка
        Person Oleg1 = new Person(1, "Oleg", "Brown", 70, Gender.MALE);
        Person Olga1 = new Person(2, "Olga", "Brown", 70, Gender.FEMALE);

        Person Lyuda1 = new Person(3, "Lyuda", "Brown", 50, Gender.FEMALE);
        Person Vitya1 = new Person(4, "Vitya", "Brown", 50, Gender.MALE);

        Person Vera = new Person(5, "Vera", "Brown", 23, Gender.FEMALE);

        Person Lily = new Person(6, "Lily", "Brown", 3, Gender.FEMALE);

        Person Kate = new Person(7, "Kate", "Brown", 5, Gender.FEMALE);
        Person Lena = new Person(8, "Lena", "Brown", 5, Gender.FEMALE);
        

        // создание родства и других связей

        Oleg1.addSpouse(Olga1);
        Lyuda1.addFather(Oleg1);
        Lyuda1.addMother(Olga1);
        Kate.addFather(Oleg1);

        Vitya1.addSpouse(Lyuda1);
        Vera.addFather(Vitya1);
        Vera.addMother(Lyuda1);

        Lily.addMother(Vera);
        Lena.addMother(Vera);
        
        System.out.printf("Дети Олега: " + Oleg1.getChildren() + "\n");
        System.out.println("Родители Веры: " + Vera.getMother() + " and " + Vera.getFather());
        // System.out.printf("У Люды есть ребенок:" + Lyuda1.getChildren());

        // создание дерева персонов
        FamilyTree tree1 = new FamilyTree();


        // добавление в дерево персонов
        tree1.addPerson(Oleg1);
        tree1.addPerson(Olga1);

        tree1.addPerson(Vitya1);
        tree1.addPerson(Lyuda1);

        tree1.addPerson(Vera);

        tree1.addPerson(Lily);
        tree1.addPerson(Kate);        
        tree1.addPerson(Lena);

        // методы нашего дерева

        tree1.printTree(); // вывод более-менее красиво
        // tree1.allTree(); // вывод списком
        tree1.saveToFile("newTree.txt"); // сохранение в файл

        // printt.print("linkk"); // семинар 2
        // savefiles.savefile("newfiles"); // созранение в файл 2 sem
    }

}