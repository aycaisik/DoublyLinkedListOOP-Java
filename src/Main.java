import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        menu();

    }

    public static void menu() {
        Scanner X = new Scanner(System.in);
        File file2 = new File("students.txt");
        Scanner reader = null;
        try {
            reader = new Scanner(file2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Integer.parseInt(reader.nextLine().trim());

        DoublyLinkedList ayca = new DoublyLinkedList();
        ArrayList listem = new ArrayList<>();
        ArrayList liste = new ArrayList<>();

        while (reader.hasNext()) {
            Student stu = null;
            try {
                stu = new Student();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            stu.setId(reader.nextInt());
            stu.setName(reader.next());
            stu.setMathNote(reader.nextInt());
            stu.setDataStNote(reader.nextInt());
            int a = (int) stu.getDataStNote();
            liste.add(a + " " + stu.getName());

            ayca.addToEnd(stu);

        }


        while (true) {

            System.out.println("öğrencileri listelemek için 1e basınız");
            System.out.println("ortalaması en yüksek öğrenciye göre sıralamak için 2ye basınız");
            System.out.println("data notu en yüksek öğrenciye göre sıralamak için 3e basınız");
            System.out.println("sınıfın matematik ortalamasını hesaplamak için 4e basınız");
            System.out.println("data notu en düşük öğrenciyi göstermek için 5e basınız");
            System.out.println("bir öğrenciyi silmek için 6ya basınız");
            System.out.println("bir öğrenciyi eklemek için 7ye basınız");
            System.out.println("öğrenci sayısını listelemek için 8e basınız");
            System.out.println("geçen öğrencileri bulmak için 9a basınız");
            System.out.println("programı kapatmak için 0a basınız");
            int A = X.nextInt();

            if (ayca.size() == 0) {
                Scanner sc = null;
                try {
                    sc = new Scanner(file2);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                for (int i = 0; i < ayca.size(); i++) {
                    Student stu1 = null;
                    try {
                        stu1 = new Student();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    stu1.setId(sc.nextInt());
                    stu1.setName(sc.next());
                    stu1.setMathNote(sc.nextInt());
                    stu1.setDataStNote(sc.nextInt());

                    ayca.addToEnd(stu1);
                }
            }

            if (A == 0) {
                break;
            }
            if (A == 1) {
                ayca.display1();
            }
            if (A == 2) {
                ayca.findMax();
            }
            if (A == 3) {
                ayca.findDataMax();
            }
            if (A == 4) {
                System.out.println("sınıfın matematik ortalaması : ");
                ayca.Mathavarage();
            }
            if (A == 5) {
                ayca.findDataMin();
            }
            if (A == 6) {
                Scanner scn = new Scanner(System.in);
                int id = scn.nextInt();
                ayca.deletewithid(id);
            }
            if (A == 7) {
                Scanner scn = new Scanner(System.in);
                int id = scn.nextInt();
                String name = scn.next();
                int mat = scn.nextInt();
                int data = scn.nextInt();
                try {
                    Student ogrencı = new Student(id,name,mat,data);
                    ayca.addToEnd(ogrencı);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            if(A == 8){
                System.out.println("öğrenci sayısı...");
                System.out.println(ayca.size());
            }
            if(A == 9){
                ayca.displaySuccessfulStudents();

            }



        }
    }
}


