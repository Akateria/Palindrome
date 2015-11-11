import java.util.ArrayList;

public class Palindrome {

    private static final int DIGIT_NUMBER = 3;
    private static final int BIGGEST_NUMBER = 999;
    private static final int SMALLEST_FACTOR = 100;
    private int firstFactor;
    private int secondFactor;
    private int largestPalindrome;

    private int findNumberFirstPart(){
        int composition = BIGGEST_NUMBER*BIGGEST_NUMBER;

        while (composition > BIGGEST_NUMBER){
            composition = composition/10;
        }

        return composition;
    }

    private int makePalindrome(int value){
        ArrayList<Integer> valueArray;
        ArrayList<Integer> palindrome;
        StringBuffer palindromeString = new StringBuffer();

        valueArray = getArrayFromInt(value);
        palindrome = makeMirrorArray(valueArray);

        for(int i=0; i< palindrome.size(); i++){
            palindromeString.append(palindrome.get(i));
        }

        Integer palindromeNum = new Integer(palindromeString.toString());

        return palindromeNum;
    }

    private ArrayList<Integer> getArrayFromInt(int value){
        ArrayList<Integer> valueArray = new ArrayList<Integer>();
        while (value > 0 ){
            valueArray.add(value % 10);
            value = value/10;
        }
        return valueArray;
    }

    private ArrayList<Integer> makeMirrorArray(ArrayList<Integer> array){
        ArrayList<Integer> palindrome = new ArrayList<Integer>();

        for (int i=DIGIT_NUMBER-1; i>=0; i--){
            Integer currentNum = array.get(i);
            palindrome.add(currentNum);
        }

        for (int i = 0; i<DIGIT_NUMBER; i++){
            Integer currentNum = array.get(i);
            palindrome.add(currentNum);
        }

        return palindrome;
    }

    public void findLargestPalindrome(){
        boolean isFound = false;
        int firstPart = findNumberFirstPart();

        while (!isFound){
            firstPart = firstPart -1;
            int newPalindrome = makePalindrome(firstPart);

            for (int i = BIGGEST_NUMBER; i> SMALLEST_FACTOR - 1; i--){
                if ((newPalindrome / i) > BIGGEST_NUMBER || i*i < newPalindrome){
                    break;
                }

                if(newPalindrome % i ==0){
                    isFound = true;
                    firstFactor = newPalindrome/i;
                    secondFactor = i;
                    largestPalindrome = newPalindrome;
                }
            }
        }
    }

    public int getFirstFactor(){
        return firstFactor;
    }

    public int getSecondFactor(){
        return secondFactor;
    }

    public int getLargestPalindrome(){
        return largestPalindrome;
    }
}
