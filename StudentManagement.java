import java.util.*;

class Student {

    int id;
    String name;
    int marks;

    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
}

public class StudentManagement {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(101, "Santhosh", 85));
        students.add(new Student(102, "Rahul", 78));
        students.add(new Student(103, "Anu", 92));
        students.add(new Student(101, "Santhosh", 85)); // duplicate

        Set<Integer> uniqueIds = new HashSet<>();
        ArrayList<Student> uniqueStudents = new ArrayList<>();

        for (Student s : students) {
            if (uniqueIds.add(s.id)) {
                uniqueStudents.add(s);
            }
        }

        HashMap<Integer, Student> studentMap = new HashMap<>();
        for (Student s : uniqueStudents) {
            studentMap.put(s.id, s);
        }

        uniqueStudents.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s2.marks - s1.marks;
            }
        });

        System.out.println("----- Student Report (Sorted by Marks) -----");
        for (Student s : uniqueStudents) {
            System.out.println("ID: " + s.id +
                    " | Name: " + s.name +
                    " | Marks: " + s.marks);
        }

        System.out.println("\n----- Fast Lookup Using HashMap -----");
        Student searchedStudent = studentMap.get(102);
        if (searchedStudent != null) {
            System.out.println("Found: " + searchedStudent.name +
                    " with marks " + searchedStudent.marks);
        }
    }
}
