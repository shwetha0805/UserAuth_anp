package com.auth;

import java.util.List;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {

        UserDAO dao = new UserDAOImpl();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choice: ");

            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Username: ");
                    String u = sc.next();
                    System.out.print("Password: ");
                    String p = sc.next();
                    System.out.print("Role (ADMIN/USER): ");
                    String r = sc.next();
                    dao.register(new User(u, p, r));
                    break;

                case 2:
                    System.out.print("Username: ");
                    u = sc.next();
                    System.out.print("Password: ");
                    p = sc.next();

                    User user = dao.login(u, p);
                    if (user != null) {
                        System.out.println("Welcome " + user.getUsername());

                        if (user.getRole().equalsIgnoreCase("ADMIN")) {
                            List<User> users = dao.getAllUsers();
                            users.forEach(x ->
                                System.out.println(x.getId() + " " + x.getUsername())
                            );
                        }
                    } else {
                        System.out.println("Invalid Credentials");
                    }
                    break;

                case 3:
                    System.exit(0);
            }
        }
    }
}
