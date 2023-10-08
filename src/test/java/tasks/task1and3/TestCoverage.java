package tasks.task1and3;

import java.util.ArrayList;
import org.testng.annotations.Test;

public class TestCoverage {

    @Test
    public void checkMultiplierTest() {
        ArrayList<Integer> testValues = new ArrayList<>();
        testValues.add(0);
        testValues.add(1);
        testValues.add(3);
        testValues.add(4);
        testValues.add(5);
        testValues.add(6);
        testValues.add(7);
        testValues.add(20);
        testValues.add(12);
        testValues.add(-4);
        testValues.add(-10);
        testValues.add(999999999);

        checkMultiplier(testValues);
    }

    @Test
    public void checkPalindromeTest() {

        ArrayList<String> testValues = new ArrayList<>();
        testValues.add("W");
        testValues.add("AVA");
        testValues.add("aba");
        testValues.add("AsDSA");
        testValues.add("asdfdsa");
        testValues.add("multiplier");
        testValues.add("123olo321");
        testValues.add("");

        checkPalindrome(testValues);
    }

    public void checkMultiplier(ArrayList<Integer> list) {
        for (int value : list) {
            if (value % 4 == 0 && value % 6 == 0) {
                System.out.println("This value is multiplier of 4 and 6 : " + value);
            } else if (value % 4 == 0) {
                System.out.println("This value is multiplier of 4 : " + value);
            } else if (value % 6 == 0) {
                System.out.println("This value is multiplier of 6 : " + value);
            }
        }
    }

    public void checkPalindrome(ArrayList<String> testValues) {
        for (String value : testValues) {
            String reversedValue = new StringBuffer(value).reverse().toString();
            if (value.equalsIgnoreCase(reversedValue)) {
                System.out.println(value + " is a palindrome");
            } else {
                System.out.println(value + " is not a palindrome");
            }
        }
    }
}