package hazm.jhazm;

import aak.tools.Strings;

//import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Mojtaba Khallash
 */
public class PersianStemmer {
    private final String[] ends = new String[] {
        "ات", "ان", "ترین", "تر", "م", "ت", "ش", "یی", "ی", "ها", "ٔ", "‌ا", //
    };

    public String Stem(String word) {
        for (String end : ends) {
            if (word.endsWith(end)) {
                word = word.substring(0, word.length() - end.length()).trim();
                
                word = Strings.specialTrim(word);
            }
        }

        if (word.endsWith("ۀ"))
            word = word.substring(0, word.length() - 1) + "ه";

        return word;
    }
}