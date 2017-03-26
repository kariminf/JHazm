package hazm.jhazm;

import hazm.jhazm.PersianLemmatizer;

import java.io.IOException;
import java.util.List;


/**
 *
 * @author Mojtaba Khallash
 */
public class LemmatizerTest {
    
    public static void LemmatizeTest() throws IOException {
        PersianLemmatizer lemmatizer = new PersianLemmatizer();

        String input, expected, actual;

        input = "کتاب‌ها";
        expected = "کتاب";
        actual = lemmatizer.Lemmatize(input);
        
        Test.showCompare(actual, expected);

        input = "آتشفشان";
        expected = "آتشفشان";
        actual = lemmatizer.Lemmatize(input);
        Test.showCompare(actual, expected);

        input = "می‌روم";
        expected = "رفت#رو";
        actual = lemmatizer.Lemmatize(input);
        Test.showCompare(actual, expected);

        input = "گفته شده است";
        expected = "گفت#گو";
        actual = lemmatizer.Lemmatize(input);
        Test.showCompare(actual, expected);

        input = "مردم";
        expected = "مردم";
        actual = lemmatizer.Lemmatize(input, "N");
        Test.showCompare(actual, expected);
    }


    public static void ConjugationsTest() throws IOException {
        PersianLemmatizer lemmatizer = new PersianLemmatizer();

        String input;
        String[] expected;
        List<String> actual;

        input = "خورد#خور";
        expected = new String[] { 
            "خوردم", "خوردی", "خورد", "خوردیم", "خوردید", "خوردند", 
            "نخوردم", "نخوردی", "نخورد", "نخوردیم", "نخوردید", "نخوردند", 
            "خورم", "خوری", /*"خورد",*/ "خوریم", "خورید", "خورند", 
            "نخورم", "نخوری", /*"نخورد",*/ "نخوریم", "نخورید", "نخورند", 
            "می‌خوردم", "می‌خوردی", /*"می‌خورد",*/ "می‌خوردیم", "می‌خوردید", "می‌خوردند", 
            "نمی‌خوردم", "نمی‌خوردی", "نمی‌خورد", "نمی‌خوردیم", "نمی‌خوردید", "نمی‌خوردند", 
            "خورده‌ام", "خورده‌ای", "خورده", "خورده‌ایم", "خورده‌اید", "خورده‌اند", 
            "نخورده‌ام", "نخورده‌ای", "نخورده", "نخورده‌ایم", "نخورده‌اید", "نخورده‌اند", 
            "می‌خورم", "می‌خوری", "می‌خورد", "می‌خوریم", "می‌خورید", "می‌خورند", 
            "نمی‌خورم", "نمی‌خوری", /*"نمی‌خورد",*/ "نمی‌خوریم", "نمی‌خورید", "نمی‌خورند", 
            "بخورم", "بخوری", "بخورد", "بخوریم", "بخورید", "بخورند", 
            "بخور", "نخور" 
        };
        actual = lemmatizer.Conjugations(input);
        check(input, expected, actual);

        input = "آورد#آور";
        expected = new String[] { 
            "آوردم", "آوردی", "آورد", "آوردیم", "آوردید", "آوردند", 
            "نیاوردم", "نیاوردی", "نیاورد", "نیاوردیم", "نیاوردید", "نیاوردند", 
            "آورم", "آوری", /*"آورد",*/ "آوریم", "آورید", "آورند", 
            "نیاورم", "نیاوری", /*"نیاورد",*/ "نیاوریم", "نیاورید", "نیاورند", 
            "می‌آوردم", "می‌آوردی", /*"می‌آورد",*/ "می‌آوردیم", "می‌آوردید", "می‌آوردند", 
            "نمی‌آوردم", "نمی‌آوردی", "نمی‌آورد", "نمی‌آوردیم", "نمی‌آوردید", "نمی‌آوردند", 
            "آورده‌ام", "آورده‌ای", "آورده", "آورده‌ایم", "آورده‌اید", "آورده‌اند", 
            "نیاورده‌ام", "نیاورده‌ای", "نیاورده", "نیاورده‌ایم", "نیاورده‌اید", "نیاورده‌اند", 
            "می‌آورم", "می‌آوری", "می‌آورد", "می‌آوریم", "می‌آورید", "می‌آورند", 
            "نمی‌آورم", "نمی‌آوری", /*"نمی‌آورد",*/ "نمی‌آوریم", "نمی‌آورید", "نمی‌آورند", 
            "بیاورم", "بیاوری", "بیاورد", "بیاوریم", "بیاورید", "بیاورند", 
            "بیاور", "نیاور"
        };
        actual = lemmatizer.Conjugations(input);
        check(input, expected, actual);
    }
        
    private static void check(String input, String[] expected, List<String> actual) {
    	Test.showCompare("" + actual.size(), "" + expected.length);
        for (int i = 0; i < expected.length; i++) {
            if (!actual.contains(expected[i]))
            	Test.showCompare(actual.get(i), expected[i]);
        }
    }
    
    
    public static void main(String[] args) {
    	try {
			LemmatizeTest();
			ConjugationsTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}