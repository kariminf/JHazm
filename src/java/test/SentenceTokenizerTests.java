package java.test;

import java.jhazm.SentenceTokenizer;
import java.util.List;


/**
 *
 * @author Mojtaba Khallash
 */
public class SentenceTokenizerTests {


    public static void tokenizeTest() {
        SentenceTokenizer senTokenizer = new SentenceTokenizer();
        
        String input = "جدا کردن ساده است. تقریبا البته!";
        System.out.println("input: " + input);
        
        String[] expected = new String[] { "جدا کردن ساده است.", "تقریبا البته!" };
        
        System.out.println("actual: ");
        List<String> actual = senTokenizer.Tokenize(input);
        
        Test.showCompare(""+actual.size(), "" + expected.length);
        for (int i = 0; i < actual.size(); i++) {
            String sentence = actual.get(i);
            System.out.println("\t" + sentence);
            Test.showCompare(actual.get(i), expected[i]);
            
        }
    }
}