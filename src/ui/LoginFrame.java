package ui;

import javax.swing.*;
import dao.UserDaoImpl;
import model.User;

public class LoginFrame extends JFrame {

    JTextField userField;
    JPasswordField passField;
    JComboBox<String> roleBox;

    public LoginFrame() {
        setTitle("Login");
        setSize(350, 350);
        setLayout(null);

        JLabel u = new JLabel("Username");
        u.setBounds(20, 20, 80, 25);
        add(u);

        userField = new JTextField();
        userField.setBounds(100, 20, 150, 25);
        add(userField);

        JLabel p = new JLabel("Password");
        p.setBounds(20, 60, 80, 25);
        add(p);

        passField = new JPasswordField();
        passField.setBounds(100, 60, 150, 25);
        add(passField);

        JLabel r = new JLabel("Role");
        r.setBounds(20, 100, 80, 25);
        add(r);

        roleBox = new JComboBox<>(new String[]{"USER", "ADMIN"});
        roleBox.setBounds(100, 100, 150, 25);
        add(roleBox);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(30, 160, 100, 30);
        add(loginBtn);

        JButton regBtn = new JButton("Register");
        regBtn.setBounds(150, 160, 100, 30);
        add(regBtn);

        // ✅ VERY IMPORTANT (you missed this)
        loginBtn.addActionListener(e -> login());

        regBtn.addActionListener(e -> new RegisterFrame());

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    void login() {
        UserDaoImpl dao = new UserDaoImpl();

        String username = userField.getText();
        String password = new String(passField.getPassword());
        String selectedRole = roleBox.getSelectedItem().toString();

        User user = dao.login(username, password);

        if (user != null) {

            if ("ADMIN".equalsIgnoreCase(user.getRole())) {
                JOptionPane.showMessageDialog(this, "Admin Login Successful");
                new ViewUsersFrame();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "User Login Successful");
            }

            clearFields();

        } else {
            JOptionPane.showMessageDialog(this, "Invalid Credentials");
        }
        System.out.println("Entered Username: " + username);
        System.out.println("Entered Password: " + password);
        System.out.println("Selected Role: " + selectedRole);
        System.out.println("DB Role: " + (user != null ? user.getRole() : "null"));
    }

    void clearFields() {
        userField.setText("");
        passField.setText("");
    }
}