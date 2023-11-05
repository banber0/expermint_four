
import javax.swing.*;


public class PrintSubjects extends JFrame {
    private JTextArea subjectTextArea;

    public PrintSubjects() {
        setTitle("课程打印");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String selectedSubjects = FileOperations.readFile("selected_subjects.txt");
        //读取file 储存到selectedSubjects 
        subjectTextArea = new JTextArea(selectedSubjects);//开创文本区域内容
        subjectTextArea.setEditable(false);//不能修改文本内容

        JScrollPane scrollPane = new JScrollPane(subjectTextArea);

        add(scrollPane);
        
        // 设置窗口可见
        setVisible(true);
    }
}
