package exercise;

import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag{
    String body;
    List<Tag> child;

    public PairedTag(String openTag, Map<String, String> attribute, String body, List<Tag> child) {
        super(openTag, attribute);
        this.body = body;
        this.child = child;
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
        result += body;
        String testChild = "";
        for(var tag: child) {
            testChild += (tag.toString());
        }
        result += testChild;
        result += "</" + openTag + ">";
        return result;
    }
}
// END
