package ui;

import javax.swing.*;
import dao.UserDaoImpl;
import model.User;

public class RegisterFrame extends JFrame {

    JTextField userField;
    JPasswordField passField;

    public RegisterFrame() {
        setTitle("Register");
        setSize(300, 250);
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

        JButton btn = new JButton("Register");
        btn.setBounds(100, 120, 100, 30);
        add(btn);

        btn.addActionListener(e -> register());

        setVisible(true);
    }

    void register() {
        User u = new User();
        u.setUsername(userField.getText());
        u.setPassword(new String(passField.getPassword()));

        if (new UserDaoImpl().register(u)) {
            JOptionPane.showMessageDialog(this, "Registered Successfully");
            userField.setText("");
            passField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Error!");
        }
    }
}