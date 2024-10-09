import java.util.*;
import java.text.*;

public class LocaleDemo {

    static void printTotal(Locale locale) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        System.out.println(nf.format(4580));
    }

    static void printDate(Locale locale) {
        Date date = new Date();
        DateFormat dtf = DateFormat.getDateInstance(DateFormat.SHORT, locale);
        System.out.println(dtf.format(date));
    }

    public static void main(String[] args) {
        // DDMMYY - IN RS 1,00,000.00
        // MMDDYY - US USD 100,000.00
        // YYMMDD - JP JPYs

        // System.out.println(Locale.getDefault());
        Locale locale = new Locale("hi", "IN");
        printTotal(locale);
        printDate(locale);
    }
}