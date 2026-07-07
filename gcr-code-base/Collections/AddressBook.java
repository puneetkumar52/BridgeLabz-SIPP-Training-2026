import java.util.*;

class Contact {
    String name, phone, email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return name + " | " + phone + " | " + email;
    }
}

public class AddressBook {
    private ArrayList<Contact> contacts = new ArrayList<>();
    private HashMap<String, Contact> nameLookup = new HashMap<>();
    private HashSet<String> phoneNumbers = new HashSet<>();

    public void addContact(String name, String phone, String email) {
        if (phoneNumbers.contains(phone)) {
            System.out.println("Duplicate phone number not allowed!");
            return;
        }
        Contact c = new Contact(name, phone, email);
        contacts.add(c);
        nameLookup.put(name, c);
        phoneNumbers.add(phone);
    }

    public void searchByName(String name) {
        Contact c = nameLookup.get(name);
        if (c != null) System.out.println("Found: " + c);
        else System.out.println("Contact not found.");
    }

    public void deleteByName(String name) {
        Contact c = nameLookup.remove(name);
        if (c != null) {
            contacts.remove(c);
            phoneNumbers.remove(c.phone);
            System.out.println("Deleted: " + c);
        } else {
            System.out.println("No contact with that name.");
        }
    }

    public void displaySorted() {
        Collections.sort(contacts, Comparator.comparing(c -> c.name));
        System.out.println("Contacts (sorted):");
        for (Contact c : contacts) System.out.println(c);
    }

    public static void main(String[] args) {
        AddressBook book = new AddressBook();
        book.addContact("Alice", "111", "alice@mail.com");
        book.addContact("Bob", "222", "bob@mail.com");
        book.addContact("Charlie", "333", "charlie@mail.com");

        book.searchByName("Bob");
        book.deleteByName("Alice");
        book.displaySorted();
    }
}
