import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class User {
    private String name;
    private String email;
    private String gender;
    private String role;
    public User(String name, String email, String gender, String role) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.role = role;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getgender() {
        return gender;

    }
    public String getrole() {
        return role;

    }
    public String toString() {
        return "User [Name: " + name + ", Email: " + email + ", Gender: " + gender + ", role: " + role +"]";
    }
}
class UserList {
    private List<User> users;
    public UserList() {
        users = new ArrayList<>();
    }
    public void addUser(User user) {
        users.add(user);
    }
    
    public User getUserByName(String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }
    public User getUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null; 
    }
    public User getUserByrole(String role) {
        for (User user : users) {
            if (user.getrole().equals(role)) {
                return user;
            }
        }
        return null; 
    }
    public void listAllUsers() {
        if (users.isEmpty()) {
            System.out.println("No students in the list.");
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }
    }
}
public class db {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserList userList = new UserList();

        while (true) {
            System.out.println("1:Add Students");
            System.out.println("2:List All Students");
            System.out.println("3:Find students by Name");
            System.out.println("4:Find students by Email");
            System.out.println("5:Find students by Role");
            System.out.println("6:Exit");
            System.out.print("Choose an option (1-6): ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Student Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Student Gender: ");
                    String gender = scanner.nextLine();;
                    System.out.print("Enter Student Role: ");
                    String role = scanner.nextLine();
                    scanner.nextLine(); 
                    userList.addUser(new User(name, email, gender,role));
                    System.out.println("Students added successfully.");
                    break;

                case 2:
                    System.out.println("\n:List of all the students");
                    userList.listAllUsers();
                    break;

                case 3:
                    System.out.print("Enter Student Name to Search: ");
                    String searchName = scanner.nextLine();
                    User userByName = userList.getUserByName(searchName);
                    if (userByName != null) {
                        System.out.println("Student Found: " + userByName);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Student Email to Search: ");
                    String searchEmail = scanner.nextLine();
                    User userByEmail = userList.getUserByEmail(searchEmail);
                    if (userByEmail != null) {
                        System.out.println("Student Found: " + userByEmail);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                System.out.print("Enter Student Role to Search: ");
                String searchrole = scanner.nextLine();
                User userByrole = userList.getUserByrole(searchrole);
                if (userByrole != null) {
                    System.out.println("Student Found: " + userByrole);
                } else {
                    System.out.println("Student not found.");
                }
                break;

                case 6:
                    System.out.println("Exit the code.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Please choose a valid option (1-6).");
                    break;
            }
        }
    }
}
