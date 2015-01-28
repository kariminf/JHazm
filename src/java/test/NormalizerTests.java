package java.test;

import java.jhazm.Normalizer;

/**
 *
 * @author Mojtaba Khallash
 */
public class NormalizerTests {

    public static void CharacterRefinementTest() {
        Normalizer normalizer = new Normalizer(true, false, false);

        String input, expected, actual;

        input = "اصلاح كاف و ياي عربي";
        expected = "اصلاح کاف و یای عربی";
        actual = normalizer.Run(input);
        Test.showCompare(actual, expected);

        input = "رمــــان";
        expected = "رمان";
        actual = normalizer.Run(input);
        Test.showCompare(actual, expected);

        input = "1,2,3,...";
        expected = "۱,۲,۳, …";
        actual = normalizer.Run(input);
        Test.showCompare(actual, expected);
    }

 
    public static void PunctuationSpacing() {
        Normalizer normalizer = new Normalizer(false, true, false);

        String input, expected, actual;

        input = "اصلاح ( پرانتزها ) در متن .";
        expected = "اصلاح (پرانتزها) در متن.";
        actual = normalizer.Run(input);
        Test.showCompare(actual, expected);
    }

    public static void AffixSpacing() {
        Normalizer normalizer = new Normalizer(false, false, true);

        String input, expected, actual;

        input = "خانه ی پدری";
        expected = "خانه‌ی پدری";
        actual = normalizer.Run(input);
        Test.showCompare(actual, expected);

        input = "فاصله میان پیشوند ها و پسوند ها را اصلاح می کند.";
        expected = "فاصله میان پیشوند‌ها و پسوند‌ها را اصلاح می‌کند.";
        actual = normalizer.Run(input);
        Test.showCompare(actual, expected);

        input = "می روم";
        expected = "می‌روم";
        actual = normalizer.Run(input);
        Test.showCompare(actual, expected);

        input = "حرفه ای";
        expected = "حرفه‌ای";
        actual = normalizer.Run(input);
        Test.showCompare(actual, expected);
    }
}