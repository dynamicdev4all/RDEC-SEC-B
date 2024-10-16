import java.util.*;

public class RbBundle {
    public static void main(String[] args) {
        ResourceBundle rb;
        Locale locale;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please choose your lang");
        System.out.println("Press 1 For English");
        System.out.println("Press 2 For Hindi");
        System.out.println("Press 3 For Japanese");
        int langChoice = sc.nextInt();
        if (langChoice == 1) {
            locale = new Locale("en", "US");
        } else if (langChoice == 2) {
            locale = new Locale("hi", "IN");
        } else if (langChoice == 3) {
            locale = new Locale("jp", "JP");
        } else {
            System.out.println("Invalid Input, default using English");
            locale = new Locale("en", "US");
        }
        rb = ResourceBundle.getBundle("ResourceBundle", locale);
        System.out.println(rb.getString("GET_NAME"));

    }
}
