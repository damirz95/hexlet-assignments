package exercise;

import java.util.Map;
import java.util.Set;

// BEGIN
public class SingleTag extends Tag{
    public SingleTag(String openTag, Map<String, String> attribute) {
        super(openTag, attribute);
    }

    @Override
    public String toString() {
        Set<String> keys = attribute.keySet();
        String result = "<" + openTag + " ";
        String textAttribute = " ";
        for (String key: keys) {
            textAttribute = textAttribute + key + "=\"" + attribute.get(key) + "\" ";
        }
        result += textAttribute.trim();
        result = result.trim() + ">";
        return result;
    }
}
// END
