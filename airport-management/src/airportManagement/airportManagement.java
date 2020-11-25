package airportManagement;

import java.util.*;
import javax.mail.*;  
import javax.mail.internet.*;   
import javax.activation.*;  

@SuppressWarnings("unused")
public class airportManagement {

	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	
	static String firstName;
	static String lastName;
	static String dob;
	static String email;
	static String accountId;
	static String lastFlightPlace;
	static String lastFlightId;
	static boolean init;
	
	public static void main(String[] args) {
		init = false;
		mainMenu();

	}
	
	public static void mainMenu() {
		clearScreen();
		@SuppressWarnings("resource")
		Scanner choiceS = new Scanner(System.in);
		System.out.println("				Welcome to Comanche Airlines!");
		System.out.println("				 How may we help you today?\n\n");
		System.out.println("				   01) Create an Account"); 
		System.out.println("				   02) Profile");
		System.out.println("				   03) Scedule a Flight");
		System.out.println("				   04) Cancel a Flight");
		System.out.println("				   05) Customer help");
		
		System.out.print("\n				Type the option number:    ");
		int choice = choiceS.nextInt();
		
		if (choice == 1) {
			createAccount();
		} else if (choice == 2) {
			profile();
		} else if (choice == 3) {
			schedule();
		} else if (choice == 4) {
			cancel();
		} else if (choice == 5) {
			help();
		} else {
			mainMenu();
		}
		
	}
	
	public static void help() {
		clearScreen();
		
		if (init == true) {
		
		@SuppressWarnings("resource")
		Scanner helpMessageS = new Scanner(System.in);
		helpMessageS.useDelimiter("\n");
		System.out.println("You are about to contact customer service. Please write down you concern or question down and we will reply to you.\n");
		String helpMessage = helpMessageS.next();
	      // Recipient's email ID needs to be mentioned.
	      String to = "pmahalatkar@gmail.com";

	      // Sender's email ID needs to be mentioned
	      String from = "airportManagementHelp@airportManage.com";

	      // Assuming you are sending email from localhost
	      String host = "localhost";

	      // Get system properties
	      Properties properties = System.getProperties();

	      // Setup mail server
	      properties.setProperty("mail.smtp.host", host);

	      // Get the default Session object.
	      Session session = Session.getDefaultInstance(properties);

	      try {
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	         // Set Subject: header field
	         message.setSubject(firstName + " " + lastName + " needs help");

	         // Now set the actual message
	         message.setText("\n\n" + firstName + " says:\n\n" + helpMessage + "\n\n" + email + "\n");

	         // Send message
	         Transport.send(message);

	      } catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	     
	      mainMenu();
	      
		} else {
	      
	      mainMenu();
	      
		}
	}
	
	public static void cancel() {
		clearScreen();
		@SuppressWarnings("resource")
		Scanner cancelS = new Scanner(System.in);
		System.out.println("Would you like to cancel this flight? \"y\" or \"n\"\n");
		System.out.println(lastFlightPlace + "    " + lastFlightId + "\n");
		String cancel = cancelS.next();
		if (cancel == "y") {
			lastFlightPlace = "";
			lastFlightId = "";
		} else {
			mainMenu();
		}
		
	}
	
	public static void schedule() {
		clearScreen();
		@SuppressWarnings("resource")
		Scanner placeS = new Scanner(System.in);
		placeS.useDelimiter("\n");
		System.out.println("Where would you like to go today " + firstName + " " + lastName + "? e.x. New York City NY\n");
		lastFlightPlace = placeS.next();
		lastFlightId = alphaNumeric(8);
		mainMenu();
		
	}
	
	public static void profile() {
		clearScreen();
		@SuppressWarnings("resource")
		Scanner nullS = new Scanner(System.in);
		System.out.println("Full Name:    " + firstName + " " + lastName);
		System.out.println("Account Id:    " + accountId);
		System.out.println("Date of Birth:    " + dob);
		System.out.println("Email Address:    " + email);
		System.out.println("Last Flight:    " + lastFlightPlace + "    " + lastFlightId + " \n\n");
		System.out.println("To exit, press \"y\":    ");
		String nullI = nullS.next();
		nullI = "";
		mainMenu();
		
	}
	
	public static void createAccount() {
		if (init == true) {
			mainMenu();
		} else {
			clearScreen();
			@SuppressWarnings("resource")
			Scanner firstNameS = new Scanner(System.in);
			@SuppressWarnings("resource")
			Scanner lastNameS = new Scanner(System.in);
			@SuppressWarnings("resource")
			Scanner dobS = new Scanner(System.in);
			@SuppressWarnings("resource")
			Scanner emailS = new Scanner(System.in);
			accountId = alphaNumeric(16);
			System.out.print("What is your first name?    ");
			firstName = firstNameS.next();
			System.out.print("\nWhat is your last name?    ");
			lastName = lastNameS.next();
			System.out.print("\nWhat is your DOB? mm/dd/yyyy    ");
			dob = dobS.next();
			System.out.print("\nWhat is your email? example@email.com    ");
			email = emailS.next();
			init = true;
			mainMenu();
			
		}
		
	}
	
	
	
	public static String alphaNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- !=0) {
			int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
			
		}
		return builder.toString();
		
	}
	
	public static void clearScreen() {   
	    System.out.print("\033[H\033[2J");   
	    System.out.flush();  

	}

}
