package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

import dao.UserDaoImpl;
import model.User;

public class ViewUsersFrame extends JFrame {

    JTable table;

    public ViewUsersFrame() {
        setTitle("Admin Panel");
        setSize(500, 350);
        setLayout(null);

        table = new JTable();
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20, 20, 440, 200);
        add(sp);

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(50, 250, 100, 30);
        add(deleteBtn);

        JButton updateBtn = new JButton("Update");
        updateBtn.setBounds(250, 250, 100, 30);
        add(updateBtn);

        loadData();

        deleteBtn.addActionListener(e -> deleteUser());
        updateBtn.addActionListener(e -> updateUser());

        setVisible(true);
    }

    void loadData() {
        List<User> users = new UserDaoImpl().getAllUsers();

        DefaultTableModel model = new DefaultTableModel(
            new String[]{"Username", "Password", "Role"}, 0
        );

        for (User u : users) {
            model.addRow(new Object[]{
                u.getUsername(),
                u.getPassword(),
                u.getRole()
            });
        }

        table.setModel(model);
    }

    void deleteUser() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            String username = table.getValueAt(row, 0).toString();

            int confirm = JOptionPane.showConfirmDialog(this, "Delete?");
            if (confirm == JOptionPane.YES_OPTION) {
                new UserDaoImpl().deleteUser(username);
                loadData();
            }
        }
    }

    void updateUser() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            String username = table.getValueAt(row, 0).toString();
            String newPass = JOptionPane.showInputDialog("New Password:");

            User u = new User();
            u.setUsername(username);
            u.setPassword(newPass);

            new UserDaoImpl().updateUser(u);
            loadData();
        }
    }
}