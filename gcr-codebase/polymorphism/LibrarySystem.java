abstract class LibraryMember {
    String memberName;
    String memberId;

    LibraryMember(String memberName, String memberId) {
        this.memberName = memberName;
        this.memberId = memberId;
    }

    abstract double calculateFine(int overdueDays);

    void printDetails() {
        System.out.println("Member: " + memberName + " | ID: " + memberId);
    }
}

class StudentMember extends LibraryMember {
    StudentMember(String name, String id) { super(name, id); }
    @Override double calculateFine(int days) { return days * 1; }
}

class FacultyMember extends LibraryMember {
    FacultyMember(String name, String id) { super(name, id); }
    @Override double calculateFine(int days) { return days * 0.5; }
}

class GuestMember extends LibraryMember {
    GuestMember(String name, String id) { super(name, id); }
    @Override double calculateFine(int days) { return days * 2; }
}

public class LibrarySystem {
    public static void main(String[] args) {
        LibraryMember[] members = {
            new StudentMember("Alice", "S101"),
            new FacultyMember("Bob", "F202"),
            new GuestMember("Charlie", "G303")
        };

        for (LibraryMember m : members) {
            m.printDetails();
            System.out.println("Fine for 5 days overdue: " + m.calculateFine(5));
        }

        // Find member by ID
        String searchId = "F202";
        for (LibraryMember m : members) {
            if (m.memberId.equals(searchId)) {
                System.out.println("Found member with ID " + searchId + ": " + m.memberName);
            }
        }
    }
}
