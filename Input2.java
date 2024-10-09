import java.util.Scanner;

public class Input2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner("This is 3rd year CSE sec B cb");
        int c = 0; 
        while (sc.hasNext()) {
            sc.next();
            c++;
        }
        System.out.println(c);

        // System.out.println("Please enter your roll no");
        // int roll = sc.nextInt();
        // System.out.println("This is the roll no :" + roll);
        // sc.nextLine();
        // System.out.println("Please enter your name");
        // String name = sc.nextLine();
        // System.out.println("This is the name :" + name);

    }
}
