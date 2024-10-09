public class Armstrong {
    public static void main(String[] args) {
        int n = 1234;
        int n2 = n;
        int n3 = n;
        int sum = 0;
        int l = 0;
        while (n != 0) {
            n = n / 10;
            l++;
        }
        while (n2 != 0) {
            int lastDigit = n2 % 10;
            sum = sum + (int) Math.pow(lastDigit, l);
            n2 = n2 / 10;
        }

        if(sum == n3){
            
        }
    }
}
