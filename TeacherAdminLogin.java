// TeacherAdminLogin.java
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherAdminLogin extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private UserManager userManager;

    public TeacherAdminLogin(UserManager userManager) {
        this.userManager = userManager;

        setTitle("老师/管理员登录");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//表示在关闭窗口时
        //释放窗口资源，并且从内存中移除窗口对象。
        //这意味着窗口将被关闭，并且不再可见，但窗口对象将被销毁，释放内存资源

        JPanel loginPanel = new JPanel();
        JLabel usernameLabel = new JLabel("用户名:");
        usernameField = new JTextField(15);
        JLabel passwordLabel = new JLabel("密码:");
        passwordField = new JPasswordField(15);
        JButton loginButton = new JButton("登录");

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();
                // 在这里添加老师/管理员登录逻辑
                User user = userManager.loginUser(username, new String(password), "teacher_admin");
                if (user != null) {
                    // 登录成功，执行相应操作
                    dispose(); // 关闭登录窗口
                } else {
                    JOptionPane.showMessageDialog(null, "登录失败，请检查用户名和密码", "错误", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);

        add(loginPanel);
    }
}
