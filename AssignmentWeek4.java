import java.io.Serializable;
import java.util.LinkedList;
import java.util.*;
public class AssignmentWeek4 {
    public static void main(String[] args) {
        String menu;
        String name;
        String phone;
        String email;
        int del;
        String search;
        String esearch;
        LinkedList<LinkedList> cb = new LinkedList<>();
        boolean quit = false;

        while(quit == false) {
            LinkedList<String> c = new LinkedList<>();
            System.out.println("\n****************************");
            System.out.println(" (A)dd");
            System.out.println(" (D)elete");
            System.out.println(" (E)mail Search");
            System.out.println(" (P)rint List");
            System.out.println(" (S)earch");
            System.out.println(" (Q)uit");
            System.out.println("****************************");
            System.out.println("Please enter a command: ");

            Scanner scan = new Scanner(System.in);
            menu = scan.nextLine().toLowerCase();

            switch (menu) {
                case "a": // add
                    // scan and add name to c
                    System.out.print("Name          : ");
                    name = scan.nextLine().toLowerCase();
                    c.add(name);
                    // scan and add phone number to c
                    System.out.print("Phone number  : ");
                    phone = scan.nextLine();
                    c.add(phone);
                    // scan and add email to c
                    System.out.print("Email         : ");
                    email = scan.nextLine().toLowerCase();
                    c.add(email);
                    // inform user that data has been saved
                    System.out.println("-Data saved-");
                    // add the temporary linkedlist c into the main linkedlist cb
                    cb.add(c);
                    break;

                case "d": // delete
                    // if there is no entry yet,
                    if (cb.size() == 0) {
                        System.out.println("No contacts available");
                    }
                    // if user already input something,
                    else {
                        // for numbering
                        int count = 1;
                        // printing the list to let user choose which to delete
                        for (LinkedList i:cb) {
                            System.out.println(count++ + ". "  + i);
                        }
                        // asking for which entry to delete
                        System.out.println("Your entry (num only): ");
                        del = scan.nextInt();
                        // if user enter a negative value,
                        if (del <= 0) {
                            System.out.println("Entry not found.");
                        }
                        // if user input a value available,
                        else if (del <= cb.size()) {
                            cb.remove(del-1);
                            System.out.println("Entry number " + del + " has been deleted.");
                        }
                        // if the user input an out of range value,
                        else {
                            System.out.println("Entry not found.");
                        }
                    }
                    break;

                case "e": // email search
                    int n = 0;
                    // if there is no entry yet,
                    if (cb.size() == 0) {
                        System.out.println("No contacts available");
                    }
                    // if user already input something,
                    else {
                        // asking user to input an email,
                        System.out.println("Your entry: ");
                        esearch = scan.nextLine().toLowerCase();
                        // loop into the cb linkedlist to check
                        for (int i = 0; i < cb.size(); i++) {
                            // inputting the index 2 of i into a variable temp
                            String temp = (String) cb.get(i).get(2);
                            // if temp is the same as the user input,
                            if (temp.equals(esearch) == true) {
                                // print the whole contact information of that user
                                System.out.println(cb.get(i));
                            }
                            // if temp is not the same as the user input,
                            else {
                                // add 1 to n
                                n++;
                            }
                        }
                        // if n is the same amount as the size of cb, that means the user input is not found within cb
                        if (n == cb.size()) {
                            // so system will return the following sentence
                            System.out.println("Entry not found");
                        }
                    }
                    break;

                case "p": // print
                    // if there is no entry yet,
                    if(cb.size() == 0) {
                        System.out.println("No contacts available");
                    }
                    // if user already input something,
                    else {
                        System.out.println("Contact List:");
                        int no = 1;
                        // printing the list with numbering to look tidier
                        for (LinkedList i:cb) {
                            System.out.println(no++ + ". "  + i);
                        }
                    }
                    break;

                case "s": // search
                    // if there is no entry yet
                    if (cb.size() == 0) {
                        System.out.println("No contacts available");
                    }
                    // if user already input something,
                    else {
                        int m = 0;
                        // asking user to input a name,
                        System.out.println("Your entry: ");
                        search = scan.nextLine().toLowerCase();
                        // loop into cb linkedlist to check
                        for (int i = 0; i < cb.size(); i++) {
                            // inputting the index 0 of i into a variable temp
                            String temp = (String) cb.get(i).get(0);
                            // if temp is the same as the user input,
                            if(search.equals(temp) == true) {
                                // print the whole contact information of that user
                                System.out.println(cb.get(i));
                            }
                            // if temp is not the same as the user input,
                            else {
                                // add 1 to m
                                m++;
                            }
                        }
                        // if m is the same amount as the size of cb, that means the user input is not found within cb
                        if (m == cb.size()) {
                            // so system will return the following sentence
                            System.out.println("Entry not found");
                        }
                    }
                    break;

                case "q": // quit
                    System.out.println("Thank you 🙏 and Goodbye 👋");
                    // making quit equals to true so that the while loop stop
                    quit = true;
                    break;

                default:
                    System.out.println("Unknown entry");
            }

        }
    }
}
