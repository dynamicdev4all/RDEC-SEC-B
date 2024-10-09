public class CountWOrds {
    public static void main(String[] args) {
        String s = "        This is    RDEC college  ";
        s = s.trim(); // removes the exts whitespaces at the begin and at the last
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ' && s.charAt(i + 1) != ' ') {
                c++;
            }
        }
        System.out.println(c + 1);
    }
}
