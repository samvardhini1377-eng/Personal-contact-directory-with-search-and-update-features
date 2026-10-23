import java.util.Scanner;

class Contact {
    String name;
    String phone;
    String email;
    String address;
}

public class PersonalContactDirectory {

    static Contact contacts[] = new Contact[100];
    static int count = 0;

    public static void addContact(Scanner sc) {
        if (count >= 100) {
            System.out.println("Contact directory is full!");
            return;
        }

        Contact c = new Contact();

        System.out.print("Enter Name: ");
        c.name = sc.nextLine();

        System.out.print("Enter Phone Number: ");
        c.phone = sc.nextLine();

        System.out.print("Enter Email: ");
        c.email = sc.nextLine();

        System.out.print("Enter Address: ");
        c.address = sc.nextLine();

        contacts[count] = c;
        count++;

        System.out.println("Contact added successfully!");
    }

    public static void displayContacts() {
        if (count == 0) {
            System.out.println("No contacts available.");
            return;
        }

        System.out.println("\n---- Contact List ----");
        for (int i = 0; i < count; i++) {
            System.out.println("Contact " + (i + 1));
            System.out.println("Name: " + contacts[i].name);
            System.out.println("Phone: " + contacts[i].phone);
            System.out.println("Email: " + contacts[i].email);
            System.out.println("Address: " + contacts[i].address);
            System.out.println("----------------------");
        }
    }

    public static void searchContact(Scanner sc) {
        System.out.print("Enter name to search: ");
        String searchName = sc.nextLine();

        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (contacts[i].name.equalsIgnoreCase(searchName)) {
                System.out.println("Contact Found!");
                System.out.println("Name: " + contacts[i].name);
                System.out.println("Phone: " + contacts[i].phone);
                System.out.println("Email: " + contacts[i].email);
                System.out.println("Address: " + contacts[i].address);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    public static void updateContact(Scanner sc) {
        System.out.print("Enter name of contact to update: ");
        String name = sc.nextLine();

        for (int i = 0; i < count; i++) {
            if (contacts[i].name.equalsIgnoreCase(name)) {

                System.out.print("Enter new phone number: ");
                contacts[i].phone = sc.nextLine();

                System.out.print("Enter new email: ");
                contacts[i].email = sc.nextLine();

                System.out.print("Enter new address: ");
                contacts[i].address = sc.nextLine();

                System.out.println("Contact updated successfully!");
                return;
            }
        }

        System.out.println("Contact not found.");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Personal Contact Directory =====");
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Update Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {

                case 1:
                    addContact(sc);
                    break;

                case 2:
                    displayContacts();
                    break;

                case 3:
                    searchContact(sc);
                    break;

                case 4:
                    updateContact(sc);
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}