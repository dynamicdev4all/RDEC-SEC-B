public class Variables {
    public static void main(String[] args) {
        String name = "Ayush";
        // String name2 = "ayush";
        String name2 = new String("Ayush").intern() ;
        System.out.println(name == name2);
    }
}
