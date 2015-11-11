
public class Main {
    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        palindrome.findLargestPalindrome();
        System.out.println("First factor: " + palindrome.getFirstFactor());
        System.out.println("Second factor: " + palindrome.getSecondFactor());
        System.out.println("Palindrome: " + palindrome.getLargestPalindrome());
    }
}
