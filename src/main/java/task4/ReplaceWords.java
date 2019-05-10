package task4;

import java.util.ArrayList;
import java.util.List;

/*В заданном тексте слова заданной длины заменить указанной
 подстрокой, длина которой может не совпадать с длиной слова*/
public class ReplaceWords {
    private   String text = "The String class represents character strings. All string literals in Java programs, such as \"abc\", are implemented as instances " +
            "of this class. Strings are constant; their values cannot be changed after they are created. String buffers support mutable strings. " +
            "Because String objects are immutable they can be shared.";
        //Words, which will replace has 8 symbols
    private String regex = "\\b[a-zA-Z]{8}\\b";
    private String substring = "ReplacementHere";
    private List<String> words = new ArrayList<>();

    public String replaceSymbolInWords() {
       String replaceAll = text.replaceAll(regex,substring);
       return replaceAll;
    }


    public static void main(String[] args) {
        ReplaceWords rw = new ReplaceWords();
        System.out.println("String: " + rw.text);
        System.out.println("String after replacement: " + rw.replaceSymbolInWords()); 

    }
}
