# expermint_four
## **一实验目的**  
1.把选课结果写入文件保存
2.掌握继承的使用
## **二业务要求**
1.保持实验三的代码和readme版本不变
2.新建代码仓库，在实验三代码的基础上完成本次实验
3.业务过程同实验三，能课程打印功能
4.将课程写入文本文件，并从该文件中读取
## **基本要求**  
学生可以注册登录选课退课并打印课程
## **解题思路**   
在实验三上进行改进，使得selected_subjects.txt文件可以解析出来而不出现乱码，并且使得课程输出出来，用FileOperations类来循环读取文件内容，并加入try模块来捕捉异常操作，PrintSubjects类为打印类，并在IndexTest类中加入打印课程按钮，可以将课程打印出来到selected_subjects.txt文本中。

## **流程图**  
![Imange text](https://github.com/banber0/expermint_two/blob/main/%E6%B5%81%E7%A8%8B%E5%9B%BE.png)  


## **关键代码**  
1.选课模块ChoiceSubject类  

    public ChoiceSubject() {
        // ... （省略部分代码）

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 获取勾选的课程并将其写入文件
                String selectedSubjects = "选修的课程：";
                for (int i = 0; i < subjects.length; i++) {
                    if (checkBoxes[i].isSelected()) {
                        selectedSubjects += subjects[i] + " ";
                    }
                }
                // 假设当前登录的学生名字为"张三"
                FileOperations.writeFile("selected_subjects.txt", "张三: " + selectedSubjects);
                JOptionPane.showMessageDialog(null, "选课成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });

        // ... （省略部分代码）
    }
}'  
ChoiceSubject 类允许学生选择课程，将选课结果写入文件，并提供友好的界面交互  
2.文件读取FileOperations模块  

    import java.io.*;

    public class FileOperations {
        public static void writeFile(String filename, String data) {
            try {
                FileWriter writer = new FileWriter(filename, true);
                writer.write(data + "\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //异常处理结构
        }

        public static String readFile(String filename) {
            StringBuilder content = new StringBuilder();
            try {
                FileReader reader = new FileReader(filename);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line).append("\n");
                }//循环读取内容  null表示文件结束
                reader.close();//关闭文件读取器
            } catch (IOException e) {
                e.printStackTrace();//文件读取发生异常 捕获异常并打印错误信息
            }
            return content.toString();//以字符串的形式返回文件内容
        }
    }
  

3.PrintSubjects打印类  

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
  String selectedSubjects = FileOperations.readFile("selected_subjects.txt")用于从文 
  件"selected_subjects.txt"中读取文本内容，并将其存储在selectedSubjects变量中



## **系统运行截图**  
## **1.主页面**  
![Image text](https://github.com/banber0/expermint_two/blob/main/%E7%B3%BB%E7%BB%9F%E7%95%8C%E9%9D%A2.png)  
## **2.登录页面,没有注册则会报错**  
![Imange text](https://github.com/banber0/expermint_two/blob/main/%E7%99%BB%E5%BD%95.png)  
## **3.注册页面,分为学生和教师**  
![Imange text](https://github.com/banber0/expermint_two/blob/main/%E6%B3%A8%E5%86%8C.png)  
## **4.注册成功**  
![Imange text](https://github.com/banber0/expermint_two/blob/main/%E6%B3%A8%E5%86%8C%E6%88%90%E5%8A%9F.png)  
## **5.选课**  
![Imange text](https://github.com/banber0/expermint_two/blob/main/%E9%80%89%E8%AF%BE.png)  
## **6.选课成功**  
![Imange text](https://github.com/banber0/expermint_two/blob/main/%E9%80%89%E8%AF%BE%E6%88%90%E5%8A%9F.png)  
## **7.退课**  
![Imange text](https://github.com/banber0/expermint_two/blob/main/%E9%80%80%E8%AF%BE%E6%88%90%E5%8A%9F.png)
## **8.课程打印**  
！[Imange text]
(https://github.com/banber0/expermint_four/blob/main/%E6%89%93%E5%8D%B0%E9%80%89%E8%AF%BE.png)

## **感想与体会**
通过本次实验，我体会到了选课的输入输出，了解到了循环文件的读取，对于文本乱码的问题，在写入文本的时候有编码，要进行编码。在文件操作中可能出现问题，添加了异常处理模块，提高程序稳定性。对于Java有了更深刻的认识，学到很多东西，希望在未来更加努力提升自己的代码能力。


