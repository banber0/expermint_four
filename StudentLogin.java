// StudentLogin.java
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentLogin extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private UserManager userManager;

    public StudentLogin(UserManager userManager) {
        this.userManager = userManager;
        

        setTitle("学生登录");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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
                // 在这里添加学生登录逻辑
                User user = userManager.loginUser(username, new String(password), "student");
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
