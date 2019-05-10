package task1;

import java.util.*;

/*Существует текст и список слов. Для каждого слова из заданного списка найти, сколько раз оно встречается в тексте, и рассортировать
слова по убыванию общего количества вхождений.*/
public class SortByWords {
 private   String text = "The String class represents character strings. All string literals in Java programs, such as \"abc\", are implemented as instances " +
            "of this class. Strings are constant; their values cannot be changed after they are created. String buffers support mutable strings. " +
            "Because String objects are immutable they can be shared";

   private String regex = "[\\s,.!:;\"]+";

   private List<String> words;

   private List<String> splitText;

   private List<String> commonWords;

   private Map<String, Integer> everyCommonWord;

   public SortByWords(){
       words = Arrays.asList("string","are","as","be","instances","constant");
       splitText = new ArrayList<>();
        commonWords = new ArrayList<>();
        everyCommonWord = new HashMap<>();
   }

   public void splitText(){
       for (String currentWord: text.split(regex)) {
           splitText.add(currentWord);
       }
       //System.out.println(splitText);
   }

   public void findCoincidence(){
       for (int i = 0; i < splitText.size(); i++) {
           for (int j = 0; j < words.size(); j++) {
               String word1 = splitText.get(i);
               String word2 = words.get(j);
               if(word1.equalsIgnoreCase(word2)){
                   commonWords.add(word1);
               }
           }

       }
       //System.out.println(commonWords);
   }

   public void countCommonWords(){
       for(String currentWord : commonWords) {
           if(everyCommonWord.containsKey(currentWord)) {
               Integer  count = everyCommonWord.get(currentWord);
               everyCommonWord.put(currentWord, ++count);
           } else {
               everyCommonWord.put(currentWord,1);
           }
       }
       //System.out.println(everyCommonWord);
   }

   public void sortByCount(){
       everyCommonWord.entrySet().stream()
               .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
               .forEach(System.out::println);
   }


    public static void main(String[] args) {
        SortByWords sortByWords = new SortByWords();
        //System.out.println(sortByWords.text);
        //System.out.println(sortByWords.words);
        sortByWords.splitText();
        sortByWords.findCoincidence();
        sortByWords.countCommonWords();
        sortByWords.sortByCount();
    }
}
