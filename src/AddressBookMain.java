import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class AddressBookMain {
    private static HashMap<String, ArrayList<AddressBook>> addressBookMap = new HashMap<>();
    private static final Scanner sc =new Scanner(System.in);

    private static void deleteContact() {
        System.out.println(addressBookMap.keySet());
        System.out.println("Enter the name of the address book you want to edit");
        String name1 = sc.next();
        Iterator<String> itr1 = addressBookMap.keySet().iterator();
        ArrayList<AddressBook> listtmp1 = new ArrayList<>();
        while(itr1.hasNext())
        {
            String tmp = itr1.next();
            if(tmp.equals(name1))
                listtmp1 = addressBookMap.get(name1);
        }
        ContactPerson.DeleteContact(listtmp1);
        addressBookMap.put(name1, listtmp1);
    }

    private static void editContact() {
        System.out.println(addressBookMap.keySet());
        System.out.println("Enter the name of the address book you want to edit");
        String name1 = sc.next();
        Iterator<String> itr1 = addressBookMap.keySet().iterator();
        ArrayList<AddressBook> listtmp1 = new ArrayList<>();
        while(itr1.hasNext())
        {
            String tmp = itr1.next();
            if(tmp.equals(name1))
                listtmp1 = addressBookMap.get(name1);
        }
        ContactPerson.EditContact(listtmp1);
        addressBookMap.put(name1, listtmp1);
        System.out.println("Contact updated succesfully");
    }

    private static void addContact() {
        System.out.println(addressBookMap.keySet());
        System.out.println("Enter the name of the address book you want to add contact");
        String name = sc.next();
        Iterator<String> itr = addressBookMap.keySet().iterator();
        addressBookMap.put(name, ContactPerson.addContactPerson());
        System.out.println("Contact added successfully");
    }

    private static void addAddressBook() {
        System.out.println("Enter the name of the address book");
        String addressBookName = sc.next();
        ArrayList<AddressBook> list = new ArrayList<>();
        addressBookMap.put(addressBookName, list);
    }
    private static void displayContact() {
        System.out.println("Enter the name of the address book");
        String AddressBookName = sc.next();
        Iterator<String> itr3 = addressBookMap.keySet().iterator();
        ArrayList<AddressBook> list= new ArrayList<>();
        while(itr3.hasNext())
        {
            String tmp = itr3.next();
            if(tmp.equals(AddressBookName))
                list = addressBookMap.get(AddressBookName);
        }

        ContactPerson.displayContactPerson(list);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book");
        int choice = 1;
        while(choice!=0)
        {
            System.out.println("Enter 1 to Create Address Book \n2 edit in Address Book \n3. delete in Address Book\n"
                    +"4. Add in Address Book  \n5. display Address Book \n0 to exit");
            choice = sc.nextInt();
            switch(choice) {
                case 1 :
                    addAddressBook();
                    break;
                case 2 :
                    editContact();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
                    addContact();
                    break;
                case 5:
                    displayContact();
                default :
                    System.out.println("Invalid Input ");
                    break;
            }
        }
    }
}
