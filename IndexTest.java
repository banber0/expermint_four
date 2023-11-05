import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IndexTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("学生选课系统");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JButton selectSubjectButton = new JButton("学生选课");
        JButton quitSubjectButton = new JButton("学生退课");
        JButton printSubjectsButton = new JButton("课程打印");
        JButton studentLoginButton = new JButton("学生登录");
        JButton teacherAdminLoginButton = new JButton("老师/管理员登录");
        JButton registerButton = new JButton("注册"); // 添加注册按钮

        panel.add(selectSubjectButton);
        panel.add(quitSubjectButton);
        panel.add(printSubjectsButton);
        panel.add(studentLoginButton);
        panel.add(teacherAdminLoginButton);
        panel.add(registerButton); 

        frame.add(panel);
        frame.setVisible(true);

        // 创建用户管理器
        UserManager userManager = new UserManager();

        // 学生登录按钮事件监听器
        
        studentLoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 创建学生登录窗口
                StudentLogin studentLogin = new StudentLogin(userManager);
                studentLogin.setVisible(true);
            }
        });

        // 老师/管理员登录按钮事件监听器
        teacherAdminLoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 创建老师/管理员登录窗口
                TeacherAdminLogin teacherAdminLogin = new TeacherAdminLogin(userManager);
                teacherAdminLogin.setVisible(true);
            }
        });

        // 注册按钮事件监听器
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 创建注册窗口
                RegisterUser registerUser = new RegisterUser(userManager);
                registerUser.setVisible(true);
            }
        });

        // 学生选课按钮事件监听器，学生退课和课程打印保持不变
        selectSubjectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChoiceSubject choiceSubject = new ChoiceSubject();
                choiceSubject.setVisible(true);
            }
        });

        quitSubjectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                QuitSubjects quitSubjects = new QuitSubjects();
                quitSubjects.setVisible(true);
            }
        });

        printSubjectsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PrintSubjects printSubjects = new PrintSubjects();
                printSubjects.setVisible(true);
            }
        });
    }
}
