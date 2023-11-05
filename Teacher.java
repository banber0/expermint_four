import java.util.ArrayList;
import java.util.List;

public class Teacher extends People {
    private List<Subject> teachingSubjects;

    public Teacher(int id, String name, String sex,int age, String subject) {
        super(id, name, sex,age);
        teachingSubjects = new ArrayList<>();
    }

    public void addTeachingSubject(Subject subject) {
        teachingSubjects.add(subject);
        subject.setTeacher(this); // 更新课程包括老师
    }

    public List<Subject> getTeachingSubjects() {
        return teachingSubjects;
    }

   
}
