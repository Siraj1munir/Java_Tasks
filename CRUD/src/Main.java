import java.util.Scanner;
//Main Class
public class Main {
    protected String[] database;
    private Scanner input;
    
    public Main() {
        database = new String[0];
        input = new Scanner(System.in);
    }

    public void add(final String name) {
        String[] temp = new String[database.length + 1];
        System.arraycopy(database, 0, temp, 0, database.length);
        database = temp;
        database[database.length - 1] = name;
    }
    
  
    public int search(final String name) {
        int nameIndex = -1;
    
        for (int i = 0; i < database.length; i++) {
            int blankSpace = database[i].indexOf(" ");
            if (database[i].substring(0, blankSpace).equalsIgnoreCase(name)) {
                nameIndex = i;
            }
        }
        return nameIndex;
    }

    
    // Search handling
    public boolean remove(final String name) {
        int pos = search(name);
        if (pos >= 0) {
            String[] temp = new String[database.length - 1];
            System.arraycopy(database, 0, temp, 0, pos); 
            System.arraycopy(database, pos + 1, temp, pos, database.length - pos - 1);
            database = temp;
            return true;
        }
        return false;
    }
    

    // Choice options
    public void displayMenu() {
        System.out.println("\n\n\n1) Add");
        System.out.println("2) Delete");
        System.out.println("3) Search");
        System.out.println("4) Display All");
        System.out.println("5) Exit\n");
    }
    
    //User choice proceeding method
    public int getChoice() {
        int choice = 4;
        boolean done = false;
        while (!done) {
            System.out.print("choice? ");
            try {
                choice = input.nextInt();
            } catch (Exception e1) {
                System.err.println("Please enter a valid number" + e1.getMessage());

            }
            if (choice > 0 && choice <= 5) {
            
                done = true; 
            } else {
                System.out.println("\nYour choice is incorrect, please try again");
            }
        }
        return choice;
    }

    /** add new person. */
    public void addPerson() {
        String name = "";
        String phone = "";
        boolean done = false;
        try {
            System.out.print("Enter the persons name ");
            String checkName = input.next();
            for (int i = 0; i < database.length + 1; i++) {
                if (database.length != 0) {
                    if (database[i].toLowerCase().contains(checkName.toLowerCase())) {
                        System.out.println("This person is already stored."); 
                    } 
                } else {
                    name = checkName;
                    System.out.print("\nEnter the persons phone number ");
                    
                    phone = input.next();
                    
                    InsertPerson addPersonObj = new InsertPerson();
                    addPersonObj.addPerson(checkName, phone);
                }
            }
            System.out.println("");
        } catch (Exception e2) {
            System.err.println("Illegal input" + e2.getMessage());
        }
        add(name + " " + phone);
    }
    
    /** display all the data that input. */
    public void displayAll() {
        System.out.printf("%s - %s %s", "Name", "Phone Number");
        
        DisplayAll displayPersonObj = new DisplayAll();
        displayPersonObj.Display();
        
        for (int i = 0; i < database.length; i++) {
            int blankSpace = database[i].indexOf(" ");
            String printName = database[i].substring(0, blankSpace);
            String printPhone = database[i].substring(blankSpace + 1, database[i].length());
            System.out.printf("%-20s %-15s %n", printName, printPhone);
        }
    }
    
    // delete person
    public void deletePerson() {
        String name = "";
        try {
            System.out.print("Enter the persons name ");
            name = input.next();
            System.out.println("");
            DeleteUser deletePersonObj = new DeleteUser();
            deletePersonObj.DeletePerson(name);
        } catch (Exception e3) {
            System.err.println("Illegal input" + e3.getMessage());
        }
        if (!remove(name)) {
            System.out.println("Could not delete " + name);
        } else {
            System.out.println(name + " was deleted successfully");
        }
    }

    /** search a person. */
    public void findPerson() {
        String name = "";
        try {
            System.out.print("Enter the persons name ");
            name = input.next();
            System.out.println("");
        } catch (Exception e4) {
            System.err.println("Illegal input" + e4.getMessage());
        }
        int pos = search(name);
        if (pos >= 0) {
            int blankSpace = database[pos].indexOf(" ");
            System.out.printf("%-20s %-15s %n", "Name", "Phone Number");
            System.out.printf("%-20s %-15s %n", database[pos].substring(0, blankSpace),
                    database[pos].substring(blankSpace + 1, database[pos].length()));
        } else {
            System.out.println("No such person");
        }
    }
    //For terminating program
   public void exit(){
	   System.out.println("Exiting!");  
	   System.exit(0);
   }  
   public void run() {
        int choice = 0;
        do {
            displayMenu();
            choice = getChoice();
     //Switch condition for choice handling
            switch (choice) {
              case 1:
                  addPerson();
                  break;
              case 2:
                  deletePerson();
                  break;
              case 3:
                  findPerson();
                  break;
              case 4:
                  displayAll();
                  break;
              case 5:
            	  exit();
              default:
            }
        } 
        while (choice != 6);
    }

    public static void main(String[] args) {
        new Main().run();
    }
}