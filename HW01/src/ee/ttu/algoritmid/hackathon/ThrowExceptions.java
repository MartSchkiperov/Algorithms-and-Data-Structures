package ee.ttu.algoritmid.hackathon;

public class ThrowExceptions {


    public static void main(String[] args) throws IllegalArgumentException {
        Student nullStudent = null;
        System.out.println("\nZero value link student object:\n===");
        System.out.println("Object link: " + nullStudent); // null object link is null
        //System.out.println("Student code is: " + nullStudent.getStudentCode()); // null = not existing object attribute gives NullPointerException

        Student emptyConstructorStudent = new Student();
        System.out.println("\nEmpty constructor student object:\n===");
        System.out.println("Object link: " + emptyConstructorStudent); // object link
        System.out.println("Student code is: " + emptyConstructorStudent.getStudentCode()); // empty object primitive attribute default value: 0
        System.out.println("First name is: " + emptyConstructorStudent.getStudentFirstName()); // empty object object attribute default value: null

        Student errorStudent = new Student(-1, null, ""); // try write in studentCode null - doesnt compile!
        System.out.println("\nHow to throw exceptions on attribute data error student object:\n===");
        if (errorStudent.getStudentFirstName() == null) {
            throw new IllegalArgumentException();
        }

    }


    public static class Student {
        int studentCode;
        String studentFirstName;
        String studentLastName;

        public Student(int studentCode, String studentFirstName, String studentLastName) {
            this.studentCode = studentCode;
            this.studentFirstName = studentFirstName;
            this.studentLastName = studentLastName;
        }

        public Student() {

        }

        public int getStudentCode() {
            return studentCode;
        }

        public String getStudentFirstName() {
            return studentFirstName;
        }

        public String getStudentLastName() {
            return studentLastName;
        }
    }
}
