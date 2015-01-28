package hazm.jhazm;

import hazm.jhazm.utility.RegexPattern;

import java.util.Arrays;
import java.util.List;


/**
 *
 * @author Mojtaba Khallash
 */
public class PersianSentTokenizer {
    private final RegexPattern pattern;

    public PersianSentTokenizer() {
        this.pattern = new RegexPattern("([!\\.\\?⸮؟]+)[ \\n]+", "$1\n\n");
    }

    public List<String> Tokenize(String text) {
        text = this.pattern.Apply(text);
        List<String> sentences = Arrays.asList(text.split("\n\n"));
        for (String sentence : sentences) {
            sentence = sentence.replace("\n", " ").trim();
        }
        return sentences;
    }
}