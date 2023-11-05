import java.util.ArrayList;
import java.util.List;

public class Student extends People {
    private List<Subject> selectedSubjects;//泛型（generic）List，其中的元素类型是 Subject

    public Student(int id, String name, String sex,int age) {
        super(id, name, sex,age);
        selectedSubjects = new ArrayList<>();
    }
    

    public void selectSubject(Subject subject) {
        if (!selectedSubjects.contains(subject)) {
            selectedSubjects.add(subject);
            subject.addStudent(this); // 更新主题以包含该学生
        }
    }

    public void dropSubject(Subject subject) {
        selectedSubjects.remove(subject);
        subject.removeStudent(this); // 更新主题以删除该学生
    }

    public List<Subject> getSelectedSubjects() {
        return selectedSubjects;
    }


}
