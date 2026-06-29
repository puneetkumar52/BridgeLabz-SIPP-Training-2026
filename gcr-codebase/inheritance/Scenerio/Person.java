class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person: " + name;
    }
}

class Student extends Person {
    final int studentId;
    double gpa;

    Student(String name, int studentId, double gpa) {
        super(name);
        this.studentId = studentId;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return super.toString() + ", Student ID: " + studentId + ", GPA: " + gpa;
    }
}

class GradStudent extends Student {
    String thesis;

    GradStudent(String name, int studentId, double gpa, String thesis) {
        super(name, studentId, gpa);
        this.thesis = thesis;
    }

    @Override
    public String toString() {
        return super.toString() + ", Thesis: " + thesis;
    }

    public static void main(String[] args) {
        GradStudent gs = new GradStudent("Anita", 101, 3.8, "AI in Healthcare");
        System.out.println(gs);
        // Demonstrates IS-A relationship
        Person p = gs;
        Student s = gs;
        System.out.println("GradStudent IS-A Student IS-A Person");
    }
}
