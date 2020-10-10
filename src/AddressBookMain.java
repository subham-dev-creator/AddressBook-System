import java.util.*;
import java.util.stream.Collectors;

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

    private static void viewByState() {
        System.out.println("Enter the state to view contacts");
        String state = sc.next();
        List<AddressBook> c = addressBookMap.get(state);
        for(int j=0 ;j < c.size();j++) {
            System.out.println(" Name "+c.get(j).firstName+" "+c.get(j).lastName);
        }
    }

    private static void viewByCity() {
        System.out.println("Enter the city to view contacts");
        String city = sc.next();
        List<AddressBook> c = addressBookMap.get(city);
        for(int j=0 ;j < c.size();j++) {
            System.out.println(c.get(j).city);
            System.out.println(" Name "+c.get(j).firstName+" "+c.get(j).lastName);
        }
    }

    private static void searchByCity() {
        System.out.println("Enter the state to search contacts");
        String city =sc.next();
        if(addressBookMap.isEmpty())
        {
            System.out.println("No AddressBook Exists, add new AddressBook First");
            System.exit(0);
        }
        for(Map.Entry<String, ArrayList<AddressBook>> ab : addressBookMap.entrySet()) {
            List<AddressBook> c = ab.getValue().stream().filter(i->i.city.equals(i.city)).collect(Collectors.toList());
            if(c.size() == 0)
                System.out.println("No entry with city name in addressbook "+ab.getKey());

            else
                for(int j=0 ;j< c.size();j++) {
                    System.out.println("AddressBook "+ab.getKey()+" Name "+c.get(j).firstName+" "+c.get(j).lastName);
                }
        }
    }

    private static void searchByState() {
        System.out.println("Enter the city to search contacts");
        String State = sc.next();
        if(addressBookMap.isEmpty())
        {
            System.out.println("No AddressBook Exists, add new AddressBook First");
            System.exit(0);
        }
        for(Map.Entry<String, ArrayList<AddressBook>> ab : addressBookMap.entrySet()) {

            List<AddressBook> c = ab.getValue().stream().filter(i->i.state.equals(i.state)).collect(Collectors.toList());

            if(c.size() == 0)
                System.out.println("No entry with state name in addressbook "+ab.getKey());

            else
                for(int j=0 ;j< c.size();j++)
                    System.out.println("AddressBook "+ab.getKey()+" Name "+c.get(j).firstName+" "+c.get(j).lastName);
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book");
        int choice = 1;
        while(choice!=0)
        {
            System.out.println("Enter 1 to Create Address Book \n2 edit in Address Book \n3. delete in Address Book\n"
                    +"4. Add in Address Book  \n5. display Address Book \n 6.Search By City \n 7.Search By State \n" +
                    " 8.View By City \n 9.View By State \n 0 to exit");
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
                case 6:
                    searchByCity();
                    break;
                case 7:
                    searchByState();
                    break;
                case 8:
                    viewByCity();
                    break;
                case 9:
                    viewByState();
                    break;
                default :
                    System.out.println("Invalid Input ");
                    break;
            }
        }
    }
}
