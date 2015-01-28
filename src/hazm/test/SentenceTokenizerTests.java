package hazm.test;

import hazm.jhazm.PersianSentTokenizer;

import java.util.List;


/**
 *
 * @author Mojtaba Khallash
 */
public class SentenceTokenizerTests {


    public static void tokenizeTest() {
        PersianSentTokenizer senTokenizer = new PersianSentTokenizer();
        
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
    
    public static void main(String[] args) {
    	tokenizeTest();
	}
}