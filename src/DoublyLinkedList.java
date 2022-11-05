import java.util.Scanner;

public class DoublyLinkedList<T extends Comparable> {
    Dnode<T> head;


    public Dnode<T> createNode(T val) {
        return new Dnode<>(val);
    }


    public void addToFront(T val) {
        Dnode<T> newNode = new Dnode<>(val);
        if (head == null)
            head = newNode;
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public int size() {
        Dnode<T> iterator = head;
        int count = 0;
        while (iterator != null) {
            count++;
            iterator = iterator.next;

        }
        return count;
    }


    public void addToEnd(T val) {
        Dnode<T> newNode = new Dnode<>(val);
        Dnode<T> iterator = head;
        if (head == null)
            head = newNode;
        else {
            while (iterator.next != null) {
                iterator = iterator.next;
            }
            iterator.next = newNode;
            newNode.prev = iterator;
        }
    }

    public boolean search(T val) {
        if (head == null)
            return false;
        Dnode<T> iterator = head;
        while (iterator != null) {
            if (iterator.value.compareTo(val) == -1)
                return true;
            iterator = iterator.next;
        }
        return false;
    }


    public void delete(T val) {
        if (search(val) == false) {
            System.out.println("value does not exist");
        }
        Dnode<T> iterator = head, prev = head;
        if (head.value.compareTo(val) == 0)
            head = head.next;
        else if (iterator.value != null) {
            while (iterator.value.compareTo(val) != 0) {
                prev = iterator;
                iterator = iterator.next;
            }
            prev.next = iterator.next;
        }
    }


    public void display1() {
        if (head == null) {
            System.out.println("Linked list is empty");
        } else {
            Dnode<T> iterator = head;
            while (iterator != null) {
                System.out.println(iterator.value);
                iterator = iterator.next;
            }
        }
    }


    public void deleteFromFront() {
        if (head != null) {
            if (head.next == null) {
                head = null;
            } else {
                head = head.next;
                head.prev = null;
            }
        }
    }

    public void addAfterHead(T val) {
        Dnode<T> temp = new Dnode<>(val);
        if (head == null) {
            head = temp;
        } else {
            temp.next = head.next;
            if (head.next != null)
                temp.next.prev = temp;
            temp.prev = head;
            head.next = temp;
        }
    }

    /*public void display2() {
        if(head==null){

        }else {
            Dnode<T> iterator = head;
            while (iterator != null) {
                Student student = (Student) iterator.value;
                String[] studentArray = new String[]{String.valueOf(student.getId()),student.getName(), String.valueOf(student.getMathNote()), String.valueOf(student.getDataStNote())};
                System.out.println(studentArray[0]+" "+studentArray[1]+" "+studentArray[2]+" "+studentArray[3]);
                iterator = iterator.next;
            }
        }*/

    public void sortedAvarage() {
        Dnode<T> iterator = head;
        while (iterator != null) {
            Student student = (Student) iterator.value;
            double avarage = (student.getDataStNote() + student.getMathNote()) / 2;

            iterator = iterator.next;
        }

    }

    public T findMax() {
        Dnode<T> iterator = head;
        if (head == null) {
            return null;
        }
        T max = iterator.value;
        int size = size();
        if (max instanceof Student) {
            for (int i = 0; i < size; i++) {
                iterator = head;
                max = iterator.value;
                while (iterator != null) {
                    if (iterator.value.compareTo(max) == 1)
                        max = iterator.value;
                    iterator = iterator.next;
                }
                System.out.println(max);
                delete(max);
            }
        }
        return max;
    }

    public void findDataMax() {
        Dnode<T> iterator = head;
        if (head == null) {
        }
        T max = iterator.value;
        int size = size();
        if (max instanceof Student) {
            for (int i = 0; i < size; i++) {
                iterator = head;
                max = iterator.value;
                while (iterator != null) {
                    Student a = null;
                    a = (Student) iterator.value;
                    if (a.compareTo2(max) == 1)
                        max = iterator.value;
                    iterator = iterator.next;
                }
                System.out.println(max);
                delete(max);
            }
        }
    }

    public void Mathavarage() {
        Dnode<T> iterator = head;
        if (head == null) {
        }
        int size = size();
        double count = 0;
        for (int i = 0; i < size; i++) {
            Student math = (Student) iterator.value;
            count = (math.getMathNote() + count);
            iterator = iterator.next;
        }
        count = count / size;
        System.out.println(count);
    }

    public void findDataMin() {
        Dnode<T> iterator = head;
        if (head == null) {
        }
        T min = iterator.value;
        int size = size();
        if (min instanceof Student) {
            for (int i = 0; i < size; i++) {
                iterator = head;
                min = iterator.value;
                while (iterator != null) {
                    Student a = null;
                    a = (Student) iterator.value;
                    if (a.compareTo2(min) == -1)
                        min = iterator.value;
                    iterator = iterator.next;
                }
            }

            iterator = head;
            while (iterator != null) {
                if (min.compareTo(iterator.value) == 0) {
                    System.out.println(iterator.value);
                }
                iterator = iterator.next;
            }
        }
    }

    public void deletewithid(int id) {

        Dnode<T> iterator = head, prev = head;
        Student id2 = (Student) iterator.value;
        if (id2.getId()== id) {

            if (head.value.compareTo(id2) == 0)
                head = head.next;
            else if (iterator.value != null) {
                while (iterator.value.compareTo(id2) != 0) {
                    prev = iterator;
                    iterator = iterator.next;
                }
                prev.next = iterator.next;
            }
            System.out.println("kişi silindi");
        }
        else{
            System.out.println("böyle bir kişi mevcut değil");
        }


    }


}









