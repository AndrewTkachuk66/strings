package task2;

import java.util.*;

import static java.util.Comparator.comparingInt;
import static java.util.Comparator.naturalOrder;
import static java.util.stream.Collectors.toList;

/*Отсортировать слова в тексте по убыванию количества вхождений заданного символа, а в случае равенства – по алфавиту.*/
public class SortBySymbol {
   private List<String> words = new ArrayList<>();
   private char symbol = 'a';
   private Map<String, Integer> symbolInEveryWord = new HashMap<>();

    public List<String> getWords() {
        return words;
    }

    public char getSymbol() {
        return symbol;
    }

    public SortBySymbol(){
        words = Arrays.asList("cat", "mama", "amagama","count","map", "alphabet", "stream");
    }

    public void findSymbolInWords(){
        int count = 0;
        for (int i = 0; i < words.size(); i++){
            String currentWord = words.get(i);
            for (int j = 0; j < currentWord.length(); j++)
                if(currentWord.charAt(j) == symbol) {
                    count++;
                    symbolInEveryWord.put(currentWord, count);
                }
                count = 0;
        }
    }

    public void sortByNumberOfSymbolsInWords(){
        List list = new ArrayList(symbolInEveryWord.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                return b.getValue() - a.getValue();
            }
        });
        System.out.println(list);
    }

    public static void main(String[] args) {
        SortBySymbol sbs = new SortBySymbol();
        sbs.findSymbolInWords();
        System.out.println("List of words: " + sbs.getWords());
        System.out.println("Symbol: " + sbs.getSymbol());
        sbs.sortByNumberOfSymbolsInWords();
    }
}
