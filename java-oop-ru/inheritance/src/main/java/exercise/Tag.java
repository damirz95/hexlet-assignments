package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    String openTag;
    Map<String, String> attribute;

    public Tag(String openTag, Map<String, String> attribute) {
        this.openTag = openTag;
        this.attribute = attribute;
    }

    public void setOpenTag(String openTag) {
        this.openTag = openTag;
    }

    public void setAttribute(Map attribute) {
        this.attribute = attribute;
    }
}
// END
