import java.util.Scanner;
import java.util.Vector;

public class ContactPerson extends AddressBookMain {
    // Functions
    public ContactPerson(String firstName, String lastName, String city, String state, int zip, String phoneNum, String email) {
        super(firstName, lastName, city, state, zip, phoneNum, email);
    }
    static void CreateContact(int numOfPerson, Vector<AddressBookMain> addArray) {
        for(int i=0;i<numOfPerson;i++){
            addArray.add(AddContact());
        }
    }
    static void EditContact(Vector<AddressBookMain> addArray) {
        Boolean flag=true;
        Scanner sc=new Scanner(System.in);
        while(flag){
            System.out.println("Enter the First Name Of Contact to Update ");
            String fn=sc.next();
            System.out.println(fn.getClass().getName());
            for (int i=0;i<addArray.size();i++) {
                System.out.println(addArray.get(i).firstName.getClass().getName());
                if(addArray.get(i).firstName.equals(fn))
                {
                    AddressBookMain newAdd =AddContact();
                    addArray.set(i,newAdd);
                }
            }
            System.out.println("Want To Edit More Contact press 1 ");
            int Choice = sc.nextInt();
            if(Choice!=1)
                flag=false;
        }
        sc.close();
    }
    static int DeleteContact(Vector<AddressBookMain> addArray) {
        int NumOfPerson=addArray.size();
        Boolean flag=true;
        Scanner sc=new Scanner(System.in);
        while(flag){
            if(addArray.size()==0)
            {
                System.out.println("No Element in address Book ");
                break;
            }
            else {
                System.out.println("Enter the First Name Of Contact to Delete ");
                String fn = sc.next();
                for (int i = 0; i < addArray.size(); i++) {
                    if (addArray.get(i).firstName.equals(fn)) {
                        addArray.remove(i);
                        NumOfPerson--;
                    }
                }
                System.out.println("Want To Delete More Contact press 1 ");
                int Choice = sc.nextInt();
                if (Choice != 1)
                    flag = false;
            }
        }
        sc.close();
        return NumOfPerson;
    }

    public static void main(String[] args) {
        int NumOfPerson;
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Number Of Persons");
        NumOfPerson=sc.nextInt();
        Vector<AddressBookMain> AddArray=new Vector<>();

        CreateContact(NumOfPerson,AddArray);

        for(int i=0;i<NumOfPerson;i++){
            System.out.println(AddArray.get(i).firstName);
        }
    }
}
