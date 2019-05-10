package task3;

import java.util.*;

/*В заданном тексте найти подстроку максимальной длины, являющуюся палиндромом, т.е. читающуюся слева направо и справа налево одинаково.*/
public class Palindrome {

    private String text = "The String class represents character strings. All string literals in Java programs, such as \"abc\", are implemented as instances " +
            "of this class. Strings are constant; their values cannot be changed after they are created. String buffers support mutable strings. " +
            "Because String objects are immutable they can be shared";
    private Set<String> palindromes = new HashSet<>();

    public void findAllPalindromes(String string){

        for (int i = 0; i < string.length(); i++) {
            for (int j = 1; j < string.length() - i; j++) {
                String substring = string.substring(i, i + j + 1);
                StringBuffer stringBuffer = new StringBuffer(substring);
                String reverseSubstring = stringBuffer.reverse().toString();
                if (substring.equals(reverseSubstring)){
                    palindromes.add(substring);
                }
               //System.out.println( "Substring: "+ substring);
                //System.out.println("Reverse substring: " + reverseSubstring);
            }
        }
        System.out.println("All palindromes: " + palindromes);
    }

    public void sortPalindromes(){
        List<String> sortSet = new ArrayList<>(palindromes);
        Collections.sort(sortSet, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
       System.out.println("Sort palindromes list: " + sortSet);
    }

    public static void main(String[] args) {
        Palindrome pl = new Palindrome();
        //pl.checkOnPalindrome(pl.text);
        System.out.println("String: " + pl.text);
        pl.findAllPalindromes(pl.text);
        pl.sortPalindromes();

    }
}
