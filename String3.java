public class String3 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.capacity());
        System.out.println(sb.length());
        sb.append("Sankalp                               ");
        System.out.println(sb.capacity());
        System.out.println(sb.length());
    }
}
