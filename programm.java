
public class programm {
    public static void main(String[] args) {
        Person Oleg1 = new Person("Oleg", "Brown", 70, true);
        Person Olga1 = new Person("Olga", "Brown", 70, false);

        Person Lyuda1 = new Person("Lyuda", "Brown", 50, false);
        Person Vitya1 = new Person("Vitya", "Brown", 50, true);

        Person Vera1 = new Person("Vera", "Brown", 23, false);

        Person Vera2 = new Person("Vera2", "Brown", 3, false);
        // System.out.println(Oleg1);
        // System.out.println(Lyuda1);

        // создание родства
        Oleg1.addChild(Lyuda1);
        Olga1.addChild(Lyuda1);

        Vitya1.addChild(Vera1);
        Lyuda1.addChild(Vera1);

        Vera1.addChild(Vera2);

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


        // вывод нашего дерева
        // tree1.printTree();
        tree1.allTree();
    }

}