// RegisterUser.java
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterUser extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> userTypeComboBox;
    private UserManager userManager;

    public RegisterUser(UserManager userManager) {
        this.userManager = userManager;

        setTitle("用户注册");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel registerPanel = new JPanel();
        JLabel usernameLabel = new JLabel("用户名:");
        usernameField = new JTextField(15);
        JLabel passwordLabel = new JLabel("密码:");
        passwordField = new JPasswordField(15);
        JLabel userTypeLabel = new JLabel("用户类型:");
        String[] userTypes = {"student", "teacher_admin"};//数组
        userTypeComboBox = new JComboBox<>(userTypes);
        JButton registerButton = new JButton("注册");

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();
                String userType = (String) userTypeComboBox.getSelectedItem();
                // 在这里添加用户注册逻辑
                boolean registered = userManager.registerUser(username, new String(password), userType);
                if (registered) {
                    JOptionPane.showMessageDialog(null, "注册成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
                    dispose(); // 关闭注册窗口
                } else {
                    JOptionPane.showMessageDialog(null, "注册失败，用户名已存在", "错误", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        registerPanel.add(usernameLabel);
        registerPanel.add(usernameField);
        registerPanel.add(passwordLabel);
        registerPanel.add(passwordField);
        registerPanel.add(userTypeLabel);
        registerPanel.add(userTypeComboBox);
        registerPanel.add(registerButton);

        add(registerPanel);
    }
}
