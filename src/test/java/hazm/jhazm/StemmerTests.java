package hazm.jhazm;

import hazm.jhazm.PersianStemmer;

/**
 *
 * @author Mojtaba Khallash
 */
public class StemmerTests {
    
    public static void StemTest() {
        PersianStemmer stemmer = new PersianStemmer();

        String input, expected, actual;

        input = "کتابی";
        expected = "کتاب";
        actual = stemmer.Stem(input);
        Test.showCompare(actual, expected);

        input = "کتاب‌ها";
        expected = "کتاب";
        actual = stemmer.Stem(input);
        Test.showCompare(actual, expected);

        input = "کتاب‌هایی";
        expected = "کتاب";
        actual = stemmer.Stem(input);
        Test.showCompare(actual, expected);

        input = "کتابهایشان";
        expected = "کتاب";
        actual = stemmer.Stem(input);
        Test.showCompare(actual, expected);

        input = "اندیشه‌اش";
        expected = "اندیشه";
        actual = stemmer.Stem(input);
        Test.showCompare(actual, expected);
    }
    
    public static void main(String[] args) {
    	StemTest();
	}
    
}