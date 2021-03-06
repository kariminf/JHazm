package hazm.jhazm;

import hazm.jhazm.PersianWordTokenizer;

import java.io.IOException;
import java.util.List;


/**
 *
 * @author Mojtaba Khallash
 */
public class WordTokenizerTest {

    public static void TokenizeTest() throws IOException {
        PersianWordTokenizer wordTokenizer = new PersianWordTokenizer(false);

        String input;
        String[] expected;
        List<String> actual;

        input = "این جمله (خیلی) پیچیده نیست!!!";
        expected = new String[] { "این", "جمله", "(", "خیلی", ")", "پیچیده", "نیست", "!!!"};
        actual = wordTokenizer.Tokenize(input);
        check(input, expected, actual);
    }

    public static void JoinVerbPartsTest() throws IOException {
        PersianWordTokenizer wordTokenizer = new PersianWordTokenizer(true);

        String input;
        String[] expected;
        List<String> actual;

        input = "خواهد رفت";
        expected = new String[] { "خواهد رفت" };
        actual = wordTokenizer.Tokenize(input);
        check(input, expected, actual);

        input = "رفته است";
        expected = new String[] { "رفته است" };
        actual = wordTokenizer.Tokenize(input);
        check(input, expected, actual);

        input = "گفته شده است";
        expected = new String[] { "گفته شده است" };
        actual = wordTokenizer.Tokenize(input);
        check(input, expected, actual);

        input = "گفته خواهد شد";
        expected = new String[] { "گفته خواهد شد" };
        actual = wordTokenizer.Tokenize(input);
        check(input, expected, actual);

        input = "خسته شدید";
        expected = new String[] { "خسته", "شدید" };
        actual = wordTokenizer.Tokenize(input);
        check(input, expected, actual);
    }
    
    private static void check(String input, String[] expected, List<String> actual) {
    	Test.showCompare("" + actual.size(), "" + expected.length);
        
        for (int i = 0; i < expected.length; i++) {
        	Test.showCompare(actual.get(i), expected[i]);
        }
    }
    
    public static void main(String[] args) {
    	try {
			TokenizeTest();
			JoinVerbPartsTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}