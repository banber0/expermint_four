import java.util.ArrayList;
import java.util.List;

public class Subject {
    private String name;
    private Teacher teacher;
    private List<Student> enrolledStudents;

    public Subject(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
        enrolledStudents = new ArrayList<>();
    }

    public void addStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void removeStudent(Student student) {
        enrolledStudents.remove(student);
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    
}
