
public class programm {
    // private Printerimpl printerimpl; // sem 2
    public static void main(String[] args) {
        // Printerimpl printt = new Printerimpl(); // 2 домашка
        // SaveFiles savefiles = new Printerimpl(); // 2 домашка
        Person Oleg1 = new Person(1, "Oleg", "Brown", 70, Gender.MALE);
        Person Olga1 = new Person(2, "Olga", "Brown", 70, Gender.FEMALE);

        Person Lyuda1 = new Person(3, "Lyuda", "Brown", 50, Gender.FEMALE);
        Person Vitya1 = new Person(4, "Vitya", "Brown", 50, Gender.MALE);

        Person Vera1 = new Person(5, "Vera", "Brown", 23, Gender.FEMALE);

        Person Vera2 = new Person(6, "Vera2", "Brown", 3, Gender.FEMALE);
        // System.out.println(Oleg1);
        // System.out.println(Lyuda1);

        // создание родства
        Oleg1.setPartner(Olga1);
        Olga1.setPartner(Oleg1);
        Oleg1.addSpouse(Olga1);
        Olga1.addSpouse(Oleg1);
        Lyuda1.addFather(Oleg1);
        Lyuda1.addMother(Olga1);

        Vitya1.setPartner(Lyuda1);
        Lyuda1.setPartner(Vitya1);
        Vera1.addFather(Vitya1);
        Vera1.addMother(Lyuda1);

        Vera2.addMother(Vera1);
        // Vera1.addChild(Vera2);
        
        // System.out.printf("У Олега есть ребенок:" + Oleg1.getChildren());
        // System.out.printf("У Люды есть ребенок:" + Lyuda1.getChildren());

        // создание дерева персонов
        FamilyTree tree1 = new FamilyTree();


        // добавление в дерево персонов
        tree1.addPerson(Oleg1);
        tree1.addPerson(Olga1);

        tree1.addPerson(Vitya1);
        tree1.addPerson(Lyuda1);

        tree1.addPerson(Vera1);

        tree1.addPerson(Vera2);

        // Oleg1.getPartner();
        // System.out.println(Oleg1.getSpouse(Oleg1));
        // System.out.println(Olga1.getSpouse(Olga1));
        // System.out.println(Oleg1.getPartner());
        // методы нашего дерева
        tree1.printTree(); // вывод более-менее красиво
        // tree1.allTree(); // вывод списком
        tree1.saveToFile("newTree.txt"); // сохранение в файл

        // printt.print("linkk"); // семинар 2
        // savefiles.savefile("newfiles"); // созранение в файл 2 sem
    }

}