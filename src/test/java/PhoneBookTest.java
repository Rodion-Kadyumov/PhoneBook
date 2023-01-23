import org.example.PhoneBook;
import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneBookTest {
    PhoneBook phoneBook;


    @BeforeEach
    public void initPhoneBook() {
        phoneBook = new PhoneBook();
    }

    @AfterEach
    public void nullPhonebook() {
        phoneBook = null;

    }

    @Test
    public void testAddContact() {
        String name = "Екатерина";
        String phoneNumber = "9-999-999-99";

        int expected = 1;
        int result = phoneBook.addContact(name, phoneNumber);

        assertEquals(expected, result);
    }

    @Test
    public void testFindByNumber() {
        phoneBook.addContact("Алина", "8-888-888-77");
        phoneBook.addContact("Наталья", "8-888-999-99");
        phoneBook.addContact("Алия", "8-888-000-07");

        String phoneNumber = "8-888-000-07";
        String expected = "Алия";
        String result = phoneBook.findByNumber(phoneNumber);
        assertEquals(expected, result);

    }

    @Test
    public void testFindByName() {
        phoneBook.addContact("Алина", "8-888-888-77");
        phoneBook.addContact("Наталья", "8-888-999-99");
        phoneBook.addContact("Алия", "8-888-000-07");
        phoneBook.addContact("Катя", "8-999-999-99");

        String name = "Катя";
        String expected = "8-999-999-99";
        String result = phoneBook.findByName(name);
        assertEquals(expected, result);

    }

    @Test
    public void testPrintAllNames() {
        phoneBook.addContact("Алина", "8-888-888-77");
        phoneBook.addContact("Наталья", "8-888-999-99");
        phoneBook.addContact("Алия", "8-888-000-07");

        Set<String> treeSet = phoneBook.printAllNames();
        Object[] names = treeSet.toArray();
        String expected1 = "Алина";
        String expected2 = "Наталья";
        String expected3 = "Алия";

        assertEquals(names[0], expected1);
        assertEquals(names[1], expected2);
        assertEquals(names[2], expected3);

    }
}

