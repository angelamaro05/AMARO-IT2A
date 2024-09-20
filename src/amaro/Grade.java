package amaro;

import java.util.Scanner;

public class Grade {

public void editGrades(Grades[] grs, int id, int size) {
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < size; i++) {
        if (id == grs[i].id) {
            System.out.println("Enter NEW grades of student " + grs[i].id + ":");
            System.out.print("Prelim: ");
            double npr = sc.nextDouble();
            grs[i].p = npr;
        }
    }
}

public void genGrade() {
    Scanner sc = new Scanner(System.in);
    Grades[] gr = new Grades[100];

    int nums = 0;
    int res;

    do {
        System.out.println("Grades Demo App");
        System.out.println("-------------------------------------");
        System.out.println("Actions:");
        System.out.println("1. Add Records");
        System.out.println("2. View Records");
        System.out.println("3. Edit Records");
        System.out.println("4. Delete Records");
        System.out.println("5. Exit");
        System.out.println("------------------------------------");

        System.out.print("Select an Option: ");
        int option = sc.nextInt();

        while (option > 5) {
            System.out.print("Invalid Selection, Try Again: ");
            option = sc.nextInt();
        }

        switch (option) {
            case 1:
                System.out.print("Enter no. of Students: ");
                nums = sc.nextInt();

                for (int i = 0; i < nums; i++) {
                    System.out.println("Enter details of student " + (i + 1) + ":");
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    System.out.print("Name: ");
                    String name = sc.next();
                    System.out.print("Prelim: ");
                    double pr = sc.nextDouble();
                    System.out.print("Midterm: ");
                    double md = sc.nextDouble();
                    System.out.print("Prefinal: ");
                    double pf = sc.nextDouble();
                    System.out.print("Final: ");
                    double fn = sc.nextDouble();
                    gr[i] = new Grades();
                    gr[i].addGrades(id, name, pr, md, pf, fn);
                }
                break;
            case 2:
                for (int i = 0; i < nums; i++) {
                    gr[i].viewGrades();
                }
                break;
            case 3:
                System.out.println("Enter id to update: ");
                int ids = sc.nextInt();
                editGrades(gr, ids, nums);
                break;
        }

        System.out.print("Do you want to continue ?  (1 / 0):  ");
        res = sc.nextInt();

    } while (res != 0);

}
}