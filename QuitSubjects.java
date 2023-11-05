
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuitSubjects extends JFrame {
    private JList<String> subjectList;
    private JButton quitButton;

    public QuitSubjects() {
        setTitle("学生退课");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String selectedSubjects = FileOperations.readFile("selected_subjects.txt");
        String[] subjects = selectedSubjects.split(": ")[1].split(" ");

        subjectList = new JList<>(subjects);
        subjectList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        quitButton = new JButton("退课");
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedSubjects = "";
                for (int i = 0; i < subjectList.getSelectedValuesList().size(); i++) {
                    selectedSubjects += subjectList.getSelectedValuesList().get(i) + " ";
                }
                // 假设当前登录的学生名字为"张三"
                FileOperations.writeFile("selected_subjects.txt", ": " + selectedSubjects);
                JOptionPane.showMessageDialog(null, "退课成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
                // 修改下面这行，关闭当前窗口
                QuitSubjects.this.dispose(); // 使用QuitSubjects.this以引用外部类的实例
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(subjectList), BorderLayout.CENTER);//滚动列表
        panel.add(quitButton, BorderLayout.SOUTH);//底部退出按钮

        add(panel);//panel添加当前窗口
    }
}
