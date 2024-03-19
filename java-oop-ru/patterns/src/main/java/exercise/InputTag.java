package exercise;

// BEGIN
public class InputTag implements TagInterface{
    private String type;
    private  String value;

    public InputTag(String type, String value) {
        this.type = type;
        this.value = value;
    }
     @Override
    public String render() {
        StringBuilder result = new StringBuilder();
        result.append("<input type=\"").append(type).append("\" value=\"");
        result.append(value).append("\">");
        return result.toString();
     }
}
// END
