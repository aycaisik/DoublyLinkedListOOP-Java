import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Student<T extends Comparable> implements Comparable {
    int id;
    String name;
    double MathNote;
    double DataStNote;
    double avarage = (getMathNote() + getDataStNote()) / 2;


    public Student() throws FileNotFoundException {
        this(0, "", 0, 0);
    }

    public Student(int id, String name, int MathNote, int DataStNote) throws FileNotFoundException {
        this.id = id;
        this.name = name;
        this.MathNote = MathNote;
        this.DataStNote = DataStNote;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMathNote() {
        return MathNote;
    }

    public void setMathNote(int mathNote) {
        MathNote = mathNote;
    }

    public double getDataStNote() {
        return DataStNote;
    }

    public void setDataStNote(int dataStNote) {
        DataStNote = dataStNote;
    }



    public String toString() {
        int x = (int) this.MathNote;
        int x2 = (int) this.DataStNote;
        return this.id + " " + this.name + " " + x + " " + x2;
    }


    public int compareTo(Object o) {
        Student s = ((Student) o);
        double avarage1 = (this.getMathNote()+this.getDataStNote())/2;
        double avarage2 = (s.getMathNote()+s.getDataStNote())/2;
        if (avarage1 == avarage2)
            return 0;
        else if (avarage1 > avarage2)
            return 1;
        else
            return -1;
    }
    public int compareTo2(Object o) {
        Student s = ((Student) o);
        double data1 = this.getDataStNote();
        double data2 =s.getDataStNote();
        if (data1 == data2)
            return 0;
        else if (data1 > data2)
            return 1;
        else
            return -1;
    }



    public void display(Student student) {
        System.out.println(student.id);
        System.out.println(student.name);
        System.out.println(student.MathNote);
        System.out.println(student.DataStNote);
    }


}
