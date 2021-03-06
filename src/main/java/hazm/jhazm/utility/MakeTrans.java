package hazm.jhazm.utility;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mojtaba Khallash
 */
public class MakeTrans {
    private final Map<Character, Character> d;

    public MakeTrans(String intab, String outab) {
        d = new HashMap<>();
        for (int i = 0; i < intab.length(); i++)
            d.put(intab.charAt(i), outab.charAt(i));
    }

    public String Translate(String src) {
        StringBuilder sb = new StringBuilder(src.length());
        for (char src_c : src.toCharArray()){
        	Character c = d.containsKey(src_c) ? d.get(src_c) : src_c;
        	sb.append(c);
        }
            
        return sb.toString();
    }
}