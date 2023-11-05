import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users;
    private List<User> registeredUsers;//1111


    public UserManager() {
        users = new ArrayList<>();
        registeredUsers = new ArrayList<>();//111
    }

    public boolean registerUser(String username, String password, String userType) {
    // 检查用户是否已存在
    for (User user : users) {
        if (user.getUsername().equals(username)) {
            return false; // 用户已存在，注册失败
        }
    }

    // 创建新用户并添加到用户列表
    User newUser = new User(username, password, userType);
    users.add(newUser);

    // 将成功注册的用户凭证添加到已注册用户列表
    registeredUsers.add(newUser);

    return true; // 注册成功
}


    public User loginUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user; // 用户名和密码匹配，返回用户对象
            }
        }
        return null; // 登录失败，未找到匹配的用户
    }

    public User loginUser(String username, String password, String userType) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password) && user.getUserType().equals(userType)) {
                return user; // 用户名、密码和用户类型匹配，返回用户对象
            }
        }
        return null; // 登录失败，未找到匹配的用户
    }
}
