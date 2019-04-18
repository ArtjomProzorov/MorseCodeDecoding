package SDAallDay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Morse {

    public static void main(String[] args) throws IOException {

        Map <String, String> dictionary = getDictionary ();
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        String b = reader.readLine ();

        if (b == null || b.isEmpty () || b.endsWith (" ")) {
            throw new RuntimeException ("Input is empty or there are spaces at the end of the input");
        } else if (!b.chars ().allMatch (letter -> letter == ' ' || letter == '-' || letter == '.')) {
            throw new RuntimeException ("Morse code only have dots and hyphens");
        } else{
                System.out.println (convertFrom (dictionary, b));
            }
        }



    private static String convertFrom(Map <String, String> dictionary, String source) {


        StringBuilder phrase = new StringBuilder ();

        if (source.contains ("    ")) {
            throw new RuntimeException ();
        }
        String words[] = source.split ("   ");


        for (int wordNumber = 0; wordNumber < words.length; wordNumber++) {
            if (words[wordNumber].contains ("  ")) {
                throw new RuntimeException ("too many spaces");
            }

            String symbol[] = words[wordNumber].split (" ");

            for (String letter : symbol) {
                phrase.append (dictionary.get (letter));


            }

            if (wordNumber < words.length - 1) {
                phrase.append (" ");
            }


        }

        return phrase.toString ();

    }


    private static Map <String, String> getDictionary() {
        Map <String, String> dictionary = new HashMap <> ();
        dictionary.put (".-", "A");
        dictionary.put ("-...", "B");
        dictionary.put ("-.-.", "C");
        dictionary.put ("-..", "D");
        dictionary.put (".", "E");
        dictionary.put ("..-.", "F");
        dictionary.put ("--.", "G");
        dictionary.put ("....", "H");
        dictionary.put ("..", "I");
        dictionary.put (".---", "J");
        dictionary.put ("-.-", "K");
        dictionary.put (".-..", "L");
        dictionary.put ("--", "M");
        dictionary.put ("-.", "N");
        dictionary.put ("---", "O");
        dictionary.put (".--.", "P");
        dictionary.put ("--.-", "Q");
        dictionary.put (".-.", "R");
        dictionary.put ("...", "S");
        dictionary.put ("-", "T");
        dictionary.put ("..-", "U");
        dictionary.put ("...-", "V");
        dictionary.put (".--", "W");
        dictionary.put ("-..-", "X");
        dictionary.put ("-.--", "Y");
        dictionary.put ("--..", "Z");
        dictionary.put ("-----", "0");
        dictionary.put (".----", "1");
        dictionary.put ("..---", "2");
        dictionary.put ("...--", "3");
        dictionary.put ("....-", "4");
        dictionary.put (".....", "5");
        dictionary.put ("-....", "6");
        dictionary.put ("--...", "7");
        dictionary.put ("---..", "8");
        dictionary.put ("----.", "9");
        dictionary.put ("...---...", "SOS");
        return dictionary;
    }
}

