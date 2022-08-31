package addressBook;

import java.util.*;

public class userInterface {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int userSelection;
		ArrayList<entry> addressBook = new ArrayList<entry>();
	
		do {
			System.out.println("1) Add an entry");
			System.out.println("2) Remove an entry");
			System.out.println("3) Search for a specific entry");
			System.out.println("4) Print Address Book");
			System.out.println("5) Delete Book");
			System.out.println("6) Quit");
			System.out.println("Please choose what you'd like to do with the database: ");
			
			userSelection = sc.nextInt();
			
			String firstName;
			String lastName;
			String phoneNumber;
			String email;
			
			switch (userSelection) {
			case 1: //Add entry
				System.out.println("First Name: ");
				firstName = sc.next();
				System.out.println("Last Name: ");
				lastName = sc.next();
				System.out.println("Phone Number: ");
				phoneNumber = sc.next();
				System.out.println("Email Address: ");
				email = sc.next();
				entry U = new entry(firstName,lastName,phoneNumber,email);
				addressBook.add(U);
				System.out.println("Added new entry!");
				break;
			case 2: //Remove entry
				System.out.println("Enter an entry's email to remove: ");
				String emailDeleted = sc.next();
				System.out.println("Deleted the following entry:");
				for(entry person: addressBook) {
					if (person.getEmail().equals(emailDeleted)) {
						System.out.println("****************");
						System.out.println("First Name: " + person.getFirstName());
						System.out.println("Last Name: " + person.getLastName());
						System.out.println("Phone Number: " + person.getPhoneNumber());
						System.out.println("Email: " + person.getEmail());
						System.out.println("****************");
						addressBook.removeIf(entry -> entry.getEmail().equals(emailDeleted));
						break;
					}
					else {
						System.out.println("No entries matching search criteria. Please try again. Taking you back to main menu.");
						break;
					}
				}
				break;
			case 3: //Search for entry and ask for search type
				System.out.println("1) First Name");
				System.out.println("2) Last Name");
				System.out.println("3) Phone Number");
				System.out.println("4) Email Address");
				System.out.println("Choose a search type: ");
				int searchType = sc.nextInt();
				entry foundPerson2 = findBy(searchType, addressBook, sc);
				if (foundPerson2 == null) {
					System.out.println("No entries matching search criteria. Please try again. Taking you back to main menu.");
				}else {
					System.out.println("****************");
					System.out.println("First Name: " + foundPerson2.getFirstName());
					System.out.println("Last Name: " + foundPerson2.getLastName());
					System.out.println("Phone Number: " + foundPerson2.getPhoneNumber());
					System.out.println("Email: " + foundPerson2.getEmail());
					System.out.println("****************");
				}
				break;
			case 4: //Print address book
				if (addressBook.isEmpty() == true) {
					System.out.println("Address book is currently empty. Taking you back to main menu.");
					break;
				}else {
					for(entry person: addressBook) {
						System.out.println("****************");
						System.out.println("First Name: " + person.getFirstName());
						System.out.println("Last Name: " + person.getLastName());
						System.out.println("Phone Number: " + person.getPhoneNumber());
						System.out.println("Email: " + person.getEmail());
						System.out.println("****************");	
					}
				}
				break;
			case 5://Delete address book
				addressBook.clear();
				System.out.println("Address book cleared!");
				break;
			case 6:
				break;
			}
			
			
			
			
			
		}while(userSelection != 6);
		

	}
	public static entry findBy(int searchType, ArrayList<entry> addressBook, Scanner sc) {
		entry foundPerson = null;
		switch(searchType) {
		case 1: //first name
			System.out.println("Enter your search: ");
			String firstName = sc.next();
			for(entry person: addressBook) {
				if (person.getFirstName().startsWith(firstName)) {
					foundPerson = person;
				}
			}
			break;
		case 2: //last name
			System.out.println("Enter your search: ");
			String lastName = sc.next();
			for(entry person: addressBook) {
				if (person.getLastName().startsWith(lastName)) {
					foundPerson = person;
				}
			}
			break;
		case 3: //phone number
			System.out.println("Enter your search: ");
			String phoneNum = sc.next();
			for(entry person: addressBook) {
				if (person.getPhoneNumber().startsWith(phoneNum)) {
					foundPerson = person;
				}
			}
			break;
		case 4: //email address
			System.out.println("Enter your search: ");
			String email = sc.next();
			for(entry person: addressBook) {
				if (person.getEmail().startsWith(email)) {
					foundPerson = person;
				}
			}
			break;
			
		}
		return foundPerson;
		
		
		
		
	}

}
