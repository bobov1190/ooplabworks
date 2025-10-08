import java.util.ArrayList;
import java.util.Map;

public class PhoneBook {

    private String name;
    private ArrayList<Contact> contacts;

    public PhoneBook(String name) {
        this.name = name;
        contacts = new ArrayList<>();
    }


    public String getName() {
        return name;
    }


    public void add(String first, String last, String number) {
        Contact c = new Contact(first,last,number);

        contacts.add(c);
    }

    public String first() {
        return contacts.get(0).getFirst() + contacts.get(0).getLast() + contacts.get(0).getNumber();
    }

    public String get(int i) {
        return null;
    }

    public String toString() {
        return null;
    }

    public String find(String needle) {
        return null;
    }

}
