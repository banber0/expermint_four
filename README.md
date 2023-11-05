# expermint_four
将选课结果写入文件保存




# expermint_three
把实验二更细节化，子类父类super用法 
**#一实验目的**  
1.掌握权限访问控制修饰符的使用；
2.掌握继承的使用。
**#二业务要求**
1.保持实验二的代码和readme版本不变
2.新建代码仓库，在实验二代码的基础上完成本次实验
3.业务过程同实验二，但在类的设计上，采用父类-子类的继承关系定义，探讨该系统中哪些类具有共性，作为父类，定义子类
4.父类定义构造方法，子类定义构造方法，掌握super()用法
5.基础对象类和测试类分别存放于不同的package中，验证权限访问控制、继承后属性及方法的可见性。
**##角色**
学校人员分为学生和教师，学生选课老师授课  
定义每种角色人员的属性，及其操作方法  
##**基本要求**  
学生可以注册登录选课退课并打印课程

#**解题思路**   
寻找不同类别中所具有相同属性的类别，Student和Teacher类可以看作是People类的子类，在子类中继承父类的方法和成员变量，减少代码的长度，使得代码更简便，通过super调用父类中的成员变量和方法。对于验证权限的访问，建立example和test两个包，分别放入父类和子类，在子类用super调用父类中的private、public、protested和缺省的方法和成员变量，查看方法是否可见，子类是否能使用，进而来验证。

#**流程图**  
![Imange text](https://github.com/banber0/expermint_two/blob/main/%E6%B5%81%E7%A8%8B%E5%9B%BE.png)  


#**关键代码**  
1.学生选课模块ChoiceSubject类  

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
2.退课模块  

    public QuitSubjects() {
        // ... （省略部分代码）

        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 获取用户选择要退课的课程
                String selectedSubjects = "";
                for (int i = 0; i < subjectList.getSelectedValuesList().size(); i++) {
                    selectedSubjects += subjectList.getSelectedValuesList().get(i) + " ";
                }
                // 假设当前登录的学生名字为"张三"
                FileOperations.writeFile("selected_subjects.txt", "张三: " + selectedSubjects);
                JOptionPane.showMessageDialog(null, "退课成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
                // 关闭当前窗口
                QuitSubjects.this.dispose();
            }
        });

        // ... （省略部分代码）
    }
}'  
QuitSubjects 类允许学生退课，将退课结果更新到文件中，并提供友好的界面交互  
3.用户类  

    public boolean registerUser(String username, String password, String userType) {
        // 用户注册逻辑，将用户信息存储到内存中
        // ...

        return true; // 注册成功
    }

    public User loginUser(String username, String password, UserRole userRole) {
        // 用户登录逻辑，验证用户名、密码、角色，返回用户对象
        // ...

        return null; // 登录失败
    }

    // ... （省略部分代码）
}'  


registerUser 方法用于用户注册，将用户信息存储在内存中  
loginUser 方法用于用户登录，验证用户名、密码和角色，返回用户对象  
UserManager 类管理用户的注册和登录，根据提供的用户名、密码和角色验证用户身份  

4.Teacher

import java.util.ArrayList;
import java.util.List;

public class Teacher extends People {
    private List<Subject> teachingSubjects;
    public Teacher(int id, String name, String sex,int age, String subject) {
        super(id, name, sex,age);
        ...
    }   
    ...
    ...
    }

5.Student

public class Student extends People {
    private List<Subject> selectedSubjects;
    public Student(int id, String name, String sex,int age) {
        super(id, name, sex,age);
        ...
        }
    ...
    ...
    }

6.People

public class People {
    protected int id;
    protected String name;
    protected String sex;
    protected int age;

    public People(int id, String name, String sex,int age){
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        ...
        ...
        }


#**验证可见性**  
创建了example和text两个包，分别放入父类People和子类Teacher,在父类中定义公开的方法和私有的方法
1.父类
package example;
public class People {
    protected int id;
    protected String name;
    protected String sex;
    private int age;
public class People {
    ...
    public String getName(){
         return name;
    }
    protected void liu() {
        System.out.println("This is a protected method in people.");
    }
    private void ze() {
        System.out.println("This is a default method in people.");
    }
    private void xu() {
        System.out.println("This is a private method in people.");
    }
}
}

2.Tteacher子类
package test;
...
import example.People;
public class Teacher extends People {
private List<Subject> teachingSubjects;
    public Teacher(int id, String name, String sex,int age, String subject) {
        super(id, name, sex,age);
        teachingSubjects = new ArrayList<>();
    }
    ...
    }
     public void verifyAccessControl() {
        super.liu(); // 可见
        //从People类访问私有方法
        super.ze(); 
        super.xu();//不可见，私有方法在子类中不可见。
        }


    


在Text包子类Teacher中访问父类所定义的方法，访问private和缺省方法报错：The method ze() from the type People is not visible，而protected方法没报错。
这样就验证了对于不同权限的方法的访问，不同包中的子类private和缺省的方法成员不能访问，而public和protected方法可以访问。

#**子类与父类** 

Student和Teacher是People的子类,人有id name sex age共性 ，QuitSubjects，PrintSubjects，RegisterUser，StudentLogin为Java中JFrame的子类GUI窗口，子类中用super使用被子类隐藏的方法super(id, name, sex,age);


#**系统运行截图**  
**1.主页面**  
![Image text](https://github.com/banber0/expermint_two/blob/main/%E7%B3%BB%E7%BB%9F%E7%95%8C%E9%9D%A2.png)  
**2.登录页面,没有注册则会报错**  
![Imange text](https://github.com/banber0/expermint_two/blob/main/%E7%99%BB%E5%BD%95.png)  
**3.注册页面,分为学生和教师**  
![Imange text](https://github.com/banber0/expermint_two/blob/main/%E6%B3%A8%E5%86%8C.png)  
**4.注册成功**  
![Imange text](https://github.com/banber0/expermint_two/blob/main/%E6%B3%A8%E5%86%8C%E6%88%90%E5%8A%9F.png)  
**5.选课**  
![Imange text](https://github.com/banber0/expermint_two/blob/main/%E9%80%89%E8%AF%BE.png)  
**6.选课成功**  
![Imange text](https://github.com/banber0/expermint_two/blob/main/%E9%80%89%E8%AF%BE%E6%88%90%E5%8A%9F.png)  
**7.退课**  
![Imange text](https://github.com/banber0/expermint_two/blob/main/%E9%80%80%E8%AF%BE%E6%88%90%E5%8A%9F.png)

**#感想与体会**  
了解创建GUI程序基本步骤包括创建窗体、容器和组件，以及为组件绑定事件监听器理清业务逻辑关系，角色之间的继承关系，掌握了文件的读取与写入，特别是使用BufferedReader来高效地一行一行读取文件内容。这对于数据的读写和共享在实际应用中非常重要。  
在运行中出现很多错误，不断地修改调试代码，修改bug，得到最终代码  
这次实验对java编程能力要求叫较高，对java有了更深的认识，在之后的编程当中遇到问题要及时搜索查阅资料进行解决。


**感想22**

在此次实验中，我掌握了继承的使用。通过编写父类，使Student类和Teacher类进行继承，减少代码的行数，使代码更加简便。对于子类继承父类更加了解，对权限访问深有体会，再次熟悉了构造方法和new函数，使用的更加得心应手。这次实验我学会了很多东西，在之后的编程当中要学会去使用子类继承父类，搞清楚权限的使用，让代码更加流畅可读。

